package OtherProjects.LAB_01;
import javax.swing.JOptionPane;

public class Calc {
    public static void main(String[] args) {
        String strnum1, strnum2;
        strnum1 = JOptionPane.showInputDialog(null, "Please input the first number:", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strnum2 = JOptionPane.showInputDialog(null, "Please input the second number:", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        
        //check divisor is not zero
        if (strnum2.equals("0")) {
            JOptionPane.showMessageDialog(null, "The divisor can't be zero", "Input error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        double num1 = Double.parseDouble(strnum1);
        double num2 = Double.parseDouble(strnum2);

        double sum = num1 + num2;
        double diff = num1 - num2;
        double prod = num1 * num2;
        double quot = num1 / num2;
        JOptionPane.showMessageDialog(null, "Results:\n" +
                                            num1 + " + " + num2 + " = " + sum + "\n" +
                                            num1 + " - " + num2 + " = " + diff + "\n" +
                                            num1 + " * " + num2 + " = " + prod + "\n" +
                                            num1 + " / " + num2 + " = " + quot,
                                            "Calculation Results", JOptionPane.INFORMATION_MESSAGE);

    }
}
