package OtherProjects.LAB_01;
import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String num1, num2;
        String res = "You've entered ";
        num1 = JOptionPane.showInputDialog(null, "Please input the first number:", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        res += num1 + " and ";
        num2 = JOptionPane.showInputDialog(null, "Please input the second number:", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        res += num2;

        JOptionPane.showMessageDialog(null, res, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
