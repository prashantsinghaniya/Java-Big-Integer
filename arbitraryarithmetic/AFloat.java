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

}
