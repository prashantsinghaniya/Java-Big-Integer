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

}