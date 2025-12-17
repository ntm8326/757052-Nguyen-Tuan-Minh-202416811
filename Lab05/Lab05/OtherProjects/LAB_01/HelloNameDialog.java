package OtherProjects.LAB_01;
import javax.swing.JOptionPane;

public class HelloNameDialog {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Please Enter Your Name:");
        JOptionPane.showMessageDialog(null, "Hello " + name + "!");
        System.exit(0);
    }
}
