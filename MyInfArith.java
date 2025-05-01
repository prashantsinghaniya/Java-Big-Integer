import arbitraryarithmetic.AInteger;
import arbitraryarithmetic.AFloat;

public class MyInfArith {
    public static void main(String[] args){
        if (args.length != 4){
            System.out.println("Usage: java MyInfArith <int/float> <add/sub/mul/div> <operand1> <operand2>");
        }
        String type = args[0];
        String operation = args[1];
        String operand1 = args[2];
        String operand2 = args[3];

        try{
            if(type.equals("int")){
                AInteger a = AInteger.parse(operand1);
                AInteger b = AInteger.parse(operand2);
                AInteger result = null;

                switch (operation) {
                    case "add":
                        result = AInteger.addition(a,b);
                        break;
                
                    case "sub":
                        result = AInteger.subtraction(a,b);
                        break;
                
                    case "mul":
                        result = AInteger.multiplication(a,b);
                        break;
                
                    case "div":
                        result = AInteger.division(a,b);
                        break;
                
                    default:
                        System.out.println("Invalid operation: " + operation);
                        return;
                }
                System.out.println(result);
            }
            else if (type.equals("float")){
                AFloat a = AFloat.parse(operand1);
                AFloat b = AFloat.parse(operand2);
                AFloat result = null;

                switch (operation) {
                    case "add":
                        result = AFloat.addition(a,b);
                        break;
                
                    case "sub":
                        result = AFloat.subtraction(a,b);
                        break;
                
                    case "mul":
                        result = AFloat.multiplication(a,b);
                        break;
                
                    case "div":
                        result = AFloat.division(a,b);
                        break;
                
                    default:
                        System.out.println("Invalid operation: " + operation);
                        return;
                }
                System.out.println(result);
            }
            else {
                System.out.println("Invalid type: " + type);
            }   
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}