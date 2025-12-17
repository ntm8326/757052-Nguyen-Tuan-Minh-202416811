package OtherProjects.LAB_01;
import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {

        // Select the type of equation
        String[] options = {"Linear Equation", "Linear System", "Quadratic Equation"};
        int choice = JOptionPane.showOptionDialog(null, "Select type of equation:", "Equation Solver",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) { // linear equation
            String stra = JOptionPane.showInputDialog(null, "Please input the first coefficient:", "Input the first coefficient", JOptionPane.INFORMATION_MESSAGE);
            String strb = JOptionPane.showInputDialog(null, "Please input the second coefficient:", "Input the second coefficient", JOptionPane.INFORMATION_MESSAGE);
            double a = Double.parseDouble(stra);
            double b = Double.parseDouble(strb);
            if (a == 0) {
                JOptionPane.showMessageDialog(null, "No solution", "Result", JOptionPane.INFORMATION_MESSAGE);
            } else {
                double x = -b / a;
                JOptionPane.showMessageDialog(null, "x = " + x, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (choice == 1) { //linear system
            String stra1 = JOptionPane.showInputDialog(null, "Please input the first coefficient of the first equation:", "Input the first coefficient", JOptionPane.INFORMATION_MESSAGE);
            String strb1 = JOptionPane.showInputDialog(null, "Please input the second coefficient of the first equation:", "Input the second coefficient", JOptionPane.INFORMATION_MESSAGE);
            String strc1 = JOptionPane.showInputDialog(null, "Please input the result of the first equation:", "Input the result", JOptionPane.INFORMATION_MESSAGE);
            String stra2 = JOptionPane.showInputDialog(null, "Please input the first coefficient of the second equation:", "Input the first coefficient", JOptionPane.INFORMATION_MESSAGE);
            String strb2 = JOptionPane.showInputDialog(null, "Please input the second coefficient of the second equation:", "Input the second coefficient", JOptionPane.INFORMATION_MESSAGE);
            String strc2 = JOptionPane.showInputDialog(null, "Please input the result of the second equation:", "Input the result", JOptionPane.INFORMATION_MESSAGE);
            double a1 = Double.parseDouble(stra1);
            double b1 = Double.parseDouble(strb1);
            double c1 = Double.parseDouble(strc1);
            double a2 = Double.parseDouble(stra2);
            double b2 = Double.parseDouble(strb2);
            double c2 = Double.parseDouble(strc2);
            double D1 = a1 * b2 - a2 * b1;
            double D2 = c1 * b2 - c2 * b1;
            double D3 = a1 * c2 - a2 * c1;

            if (D1 == 0) {
                if (D2 == 0 && D3 == 0) {
                    JOptionPane.showMessageDialog(null, "Infinite solutions", "Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No solution", "Result", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                double x = D2 / D1;
                double y = D3 / D1;
                JOptionPane.showMessageDialog(null, "x = " + x + ", y = " + y, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (choice == 2) { //quadratic equation
            String stra = JOptionPane.showInputDialog(null, "Please input the first coefficient:", "Input the first coefficient", JOptionPane.INFORMATION_MESSAGE);
            String strb = JOptionPane.showInputDialog(null, "Please input the second coefficient:", "Input the second coefficient", JOptionPane.INFORMATION_MESSAGE);
            String strc = JOptionPane.showInputDialog(null, "Please input the third coefficient:", "Input the third coefficient", JOptionPane.INFORMATION_MESSAGE);
            double a = Double.parseDouble(stra);
            double b = Double.parseDouble(strb);
            double c = Double.parseDouble(strc);
            if (a == 0) {
                if (b == 0) {
                    JOptionPane.showMessageDialog(null, "No solution", "Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    double x = -c / b;
                    JOptionPane.showMessageDialog(null, "x = " + x, "Result", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                double delta = b * b - 4 * a * c;
                if (delta < 0) {
                    JOptionPane.showMessageDialog(null, "No real solution", "Result", JOptionPane.INFORMATION_MESSAGE);
                } else if (delta == 0) {
                    double x = -b / (2 * a);
                    JOptionPane.showMessageDialog(null, "x = " + x, "Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    JOptionPane.showMessageDialog(null, "x1 = " + x1 + ", x2 = " + x2, "Result", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
