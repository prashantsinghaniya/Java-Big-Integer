package arbitraryarithmetic;
import arbitraryarithmetic.AInteger;


public class AFloat {
    String value;
	AFloat() {
		this.value = "0.0";
	}
	AFloat (String value) {
		this.value = value;
	}
    AFloat(AFloat other){
        this.value = other.value;
    }

	public static String[] padding(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();

		if(len1 < len2) {
			s1 += "0".repeat( len2 - len1);
		} else {
			s2 += "0".repeat(len1 - len2);
		}
		return new String[] {s1, s2};
	}

	public static String f_padding(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		String ch = "";
		if(len1 < len2) {
			ch += "0".repeat(len2-len1);
		}
		return new String (ch+s1);
	}

    public static AFloat parse (String s){
        return new AFloat(s); 
    }

	@Override
    public String toString() {
        return this.value;
    }

    public static AFloat addition(AFloat num1, AFloat num2) {

		boolean num1_neg = false;
		boolean num2_neg = false;
		if(num1.value.charAt(0) == '-') {
			num1.value = num1.value.substring(1);
			num1_neg = true;
		}
		if(num2.value.charAt(0) == '-') {
			num2.value = num2.value.substring(1);
			num2_neg = true;
		}
		if(num1_neg == true && num2_neg == false) return AFloat.subtraction(num2, num1);
		else if(num1_neg == false && num2_neg == true) {
			return AFloat.subtraction(num1, num2);
		}
		else if(num1_neg == true && num2_neg == true) return new AFloat( (AFloat.addition(num1,num2).value.equals("0.0")) ? "0.0" : "-" + AFloat.addition(num1,num2).value);

		if( !num1.value.contains(".") ) num1.value += ".0";
		String[] num1_parts = num1.value.split("\\.");
		String num1_int = num1_parts[0];
		String num1_flot = num1_parts[1];
		if(!num2.value.contains(".")) num2.value += ".0";
		String[] num2_parts = num2.value.split("\\.");
		String num2_int = num2_parts[0];
		String num2_flot = num2_parts[1];

		String[] s = padding(num1_flot, num2_flot);

		AInteger sumFlot = AInteger.addition(AInteger.parse(s[0]), AInteger.parse(s[1]));
		AInteger sumInt = AInteger.addition(AInteger.parse(num1_int), AInteger.parse(num2_int));

		if(sumFlot.getInt().length() > s[1].length()) {
			sumInt = AInteger.addition(sumInt, AInteger.parse("1"));
			sumFlot.value = sumFlot.getInt().substring(1);
		}
		else {
			sumFlot.value = AFloat.f_padding(sumFlot.getInt(), s[1]);
		}
		sumFlot.value = sumFlot.value.replaceAll("0+$","");
		if( sumFlot.value.isEmpty() ) sumFlot.value = "0";

		return new AFloat(sumInt.getInt() + "." + sumFlot.getInt());
	}

    



}
