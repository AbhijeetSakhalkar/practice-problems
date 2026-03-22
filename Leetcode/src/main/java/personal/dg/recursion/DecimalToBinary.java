package personal.dg.recursion;

public class DecimalToBinary {
    public String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }
        return decimalToBinaryRec(decimal / 2) + (decimal % 2); // Recursive call
    }

    private String decimalToBinaryRec(int decimal) {
        if (decimal == 0) {
            return ""; // Base case
        }
        return decimalToBinaryRec(decimal / 2) + (decimal % 2); // Recursive call
    }

    public static void main(String[] args) {
        DecimalToBinary sol = new DecimalToBinary();
        int[] examples = {10, 27, 5};

        for (int example : examples) {
            String binary = sol.decimalToBinary(example);
            System.out.println("Binary representation of " + example + " is: " + binary);
        }
    }
}
