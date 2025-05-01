package arbitraryarithmetic;

public class AInteger{
    String value;
    AInteger(){
        this.value = "0";
    }
    AInteger(String value) {
        this.value = value;
    }

    public static AInteger parse (String s){
        return new AInteger(s); 
    }

    public String getInt(){
        return this.value;
    }

    public AInteger(AInteger other){
        this.value = other.value; 
    }
    public static AInteger addition(AInteger num1, AInteger num2) {
        boolean num1_neg = false;
        boolean num2_neg = false;
        if(num1.value.charAt(0) == '-'){
            num1.value = num1.value.substring(1);
            num1_neg = true;
        }
        if(num2.value.charAt(0) == '-'){
            num2.value = num2.value.substring(1);
            num2_neg = true;
        }
        if(num1_neg == true && num2_neg == false) return AInteger.subtraction(num2, num1);
        else if(num1_neg == false && num2_neg == true){
            return AInteger.subtraction(num1, num2);
        }
        else if(num1_neg == true && num2_neg == true) return new AInteger("-" + AInteger.addition(num1,num2).getInt());
        
        int[] result = new int[Math.max(num1.value.length(), num2.value.length()) + 1];
        int[] n1 = new int[result.length];
        int[] n2 = new int[result.length];
        
        // Fill n1 from num1.value
        for (int i = result.length - 1, j = num1.value.length() - 1; j >= 0; i--, j--) {
            n1[i] = num1.value.charAt(j) - '0';
        }
        
        // Fill n2 from num2.value
        for (int i = result.length - 1, j = num2.value.length() - 1; j >= 0; i--, j--) {
            n2[i] = num2.value.charAt(j) - '0';
        }
        
        int carry = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            int sum = n1[i] + n2[i] + carry;
            result[i] = sum % 10;
            carry = sum / 10;
        }
        
        // Convert result[] to String, skipping leading zeros
        StringBuilder sb = new StringBuilder();
        boolean leading = true;
        for (int digit : result) {
            if (digit == 0 && leading) continue;
            leading = false;
            sb.append(digit);
        }
        
        return new AInteger(leading ? "0" : sb.toString());
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static AInteger subtraction(AInteger num1, AInteger num2){
        boolean num1_neg = false;
        boolean num2_neg = false;
        if(num1.value.charAt(0) == '-'){
            num1.value = num1.value.substring(1);
            num1_neg = true;
        }
        if(num2.value.charAt(0) == '-'){
            num2.value = num2.value.substring(1);
            num2_neg = true;
        }
        if(num1_neg == true && num2_neg == false) return new AInteger("-" + AInteger.addition(num1, num2).getInt());
        else if(num1_neg == false && num2_neg == true) return AInteger.addition(num1, num2);
        else if(num1_neg == true && num2_neg == true) return AInteger.subtraction(num2,num1);
        
        int[] result = new int[Math.max(num1.value.length(), num2.value.length())];
        int[] n1 = new int[result.length];
        int[] n2 = new int[result.length];
        
        for (int i = result.length - 1, j = num1.value.length() - 1; j >= 0; i--, j--) {
            n1[i] = num1.value.charAt(j) - '0';
        }

        // Fill n2 from num2.value
        for (int i = result.length - 1, j = num2.value.length() - 1; j >= 0; i--, j--) {
            n2[i] = num2.value.charAt(j) - '0';
        }
        
        boolean result_is_neg = false;
        for(int i = 0; i<result.length; i++){
            if(n1[i] < n2[i]){ result_is_neg = true; break;}
            if(n1[i] > n2[i]) { break; } 
        }
        if(result_is_neg){
            int[]  temp = n1;
            n1 = n2;
            n2 = temp;
        }
        int carry = 0;

        for (int i = result.length - 1; i >= 0; i--) {
            n1[i]-=carry;
            if(n1[i] < n2[i] ){
                carry = 1;
                result[i] = 10 + n1[i] - n2[i];
            } 
            else{
                carry = 0;
                result[i] = n1[i] - n2[i];
            } 
        }
        StringBuilder sb = new StringBuilder();
        if(result_is_neg){
            sb.append("-");
            result_is_neg = false;
        }
        boolean leading = true;
        for(int digit : result){
            if(digit == 0 && leading == true) continue;
            leading = false;
            sb.append(digit);
        }
        return new AInteger(leading ? "0" : sb.toString());
    }

    public static AInteger multiplication(AInteger num1, AInteger num2) {
        boolean num1_neg = false;
        boolean num2_neg = false;
        if(num1.value.charAt(0) == '-'){
            num1.value = num1.value.substring(1);
            if(num1.value.replaceFirst("^0+(?!$)","").equals("0")){
                return new AInteger("0");
            }
            num1_neg = true;
        }
        if(num2.value.charAt(0) == '-'){
            num2.value = num2.value.substring(1);
            if(num2.value.replaceFirst("^0+(?!$)","").equals("0")){
                return new AInteger("0");
            }
            num2_neg = true;
        }
        if(num1_neg == true && num2_neg == false) return new AInteger( (AInteger.multiplication(num1, num2).getInt().equals("0")) ? "0" : "-" + AInteger.multiplication(num1, num2).getInt());
        else if(num1_neg == false && num2_neg == true) return new AInteger( (AInteger.multiplication(num1, num2).getInt()).equals("0") ? "0" : "-" + AInteger.multiplication(num1, num2).getInt());
        int len1 = num1.value.length();
        int len2 = num2.value.length();
        int[] n1 = new int[len1];
        int[] n2 = new int[len2];
        
        // Fill n1
        for (int i = len1 - 1, j = 0; i >= 0; i--, j++) {
            n1[j] = num1.value.charAt(i) - '0';  // reverse order for easy calc
        }
        // Fill n2
        for (int i = len2 - 1, j = 0; i >= 0; i--, j++) {
            n2[j] = num2.value.charAt(i) - '0';
        }
        
        int[] result = new int[len1 + len2];
    
        // Multiply digits by element to element
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                result[i + j] += n1[i] * n2[j];
                // Handle carry
                result[i + j + 1] += result[i + j] / 10;
                result[i + j] %= 10;
            }
        }
        
        // Build string from result and skipping leading zeros
        StringBuilder sb = new StringBuilder();
        boolean leading = true;
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] == 0 && leading) continue;
            leading = false;
            sb.append(result[i]);
        }
        
        return new AInteger(leading ? "0" : sb.toString());
    }

    public static int compare(AInteger divident, AInteger divisor){
        if(divident.value.length()>divisor.value.length()) return 1;
        else if (divident.value.length()<divisor.value.length()) return -1;
        return divident.value.compareTo(divisor.value);
    }

    public static AInteger division(AInteger dividend, AInteger divisor) {
        if (divisor.value.replaceFirst("^0+(?!$)","").equals("0")) throw new ArithmeticException("Division by Zero error");
        if(dividend.value.replaceFirst("^0+(?!$)","").equals("0")){
            return new AInteger("0");
        }

        boolean num1_neg = false;
        boolean num2_neg = false;
        if(divisor.value.charAt(0) == '-'){
            divisor.value = divisor.value.substring(1);
            if(divisor.value.replaceFirst("^0+(?!$)","").equals("0")) throw new ArithmeticException("Division by zero error");
            num2_neg = true;
        }
        if(dividend.value.charAt(0) == '-'){
            dividend.value = dividend.value.substring(1);
            if(dividend.value.replaceFirst("^0+(?!$)","").equals("0")){
                return new AInteger("0");
            }
            num1_neg = true;
        }
        
        if(num1_neg == true && num2_neg == false) return new AInteger((AInteger.division(dividend, divisor).getInt()).equals("0") ? "0" : "-" + AInteger.division(dividend, divisor).getInt());
        else if(num1_neg == false && num2_neg == true) return new AInteger((AInteger.division(dividend, divisor).getInt()).equals("0") ? "0" : "-" + AInteger.division(dividend, divisor).getInt());

        dividend.value = dividend.value.replaceFirst("^0+(?!$)","");
        divisor.value = divisor.value.replaceFirst("^0+(?!$)","");
        
        if (divisor.value.equals("0")) throw new ArithmeticException("Division by Zero error");
        
        if (compare(dividend, divisor) < 0) return new AInteger("0");
    
        StringBuilder result = new StringBuilder();
        AInteger temp = new AInteger("0"); 
    
        for (int i = 0; i < dividend.value.length(); i++) {
            temp.value += dividend.value.charAt(i);
            temp.value = temp.value.replaceFirst("^0+(?!$)", "");  // remove leading zeros
            int count = 0;
            while (compare(temp, divisor) >= 0) {
                temp = subtraction(temp, divisor);
                count++;
            }
            result.append(count);
        }
    
        // Remove leading zeros from the result
        String finalResult = result.toString().replaceFirst("^0+(?!$)", "");
        return new AInteger(finalResult);
    }


}