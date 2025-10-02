import javax.swing.JOptionPane;
public class firstdegree {
    public static void first(String[] args) {
        String a11, a12, a21, a22, b1, b2;
        String strNotification = "You've just entered: ";

        a11 = JOptionPane.showInputDialog(
            null,
            "Please input the a11:",
            "Input the first number",
            JOptionPane.INFORMATION_MESSAGE
        );
        strNotification += a11 + " and ";

        a12 = JOptionPane.showInputDialog(
            null,
            "Please input the a11:",
            "Input the second number",
            JOptionPane.INFORMATION_MESSAGE
        );
        strNotification += a12 + " and ";

        a21 = JOptionPane.showInputDialog(
            null,
            "Please input the a11:",
            "Input the third number",
            JOptionPane.INFORMATION_MESSAGE
        );
        strNotification += a21 + " and ";

        a22 = JOptionPane.showInputDialog(
            null,
            "Please input the a11:",
            "Input the first number",
            JOptionPane.INFORMATION_MESSAGE
        );
        strNotification += a22 + " and ";

        b1 = JOptionPane.showInputDialog(
            null,
            "Please input the a11:",
            "Input the first number",
            JOptionPane.INFORMATION_MESSAGE
        );
        strNotification += b1 + " and ";

        b2 = JOptionPane.showInputDialog(
            null,
            "Please input the second number:",
            "Input the second number",
            JOptionPane.INFORMATION_MESSAGE
        );
        strNotification += b2 + '\n';
        double num1 = Double.parseDouble(a11);
        double num2 = Double.parseDouble(a12);
    }

}
