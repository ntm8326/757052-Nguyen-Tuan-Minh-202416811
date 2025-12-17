package OtherProjects.LAB_01;
import javax.swing.JOptionPane;

public class ChoosingOption {

    public static void main(String[] args) {
        
        int choice1 = JOptionPane.showConfirmDialog(null, "Do you wish to upgrade to first class?");

        JOptionPane.showMessageDialog(null, "You've chosen: " + (choice1 == JOptionPane.YES_OPTION ? "Yes" : "No"));

        String[] options = {"I do", "I don't"};
        int choice2 = JOptionPane.showOptionDialog(
            null,
            "Do you wish to upgrade to first class?",
            "Confirm",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[1]
        );
        JOptionPane.showMessageDialog(null, "You've chosen: " + (choice2 == 0 ? "Yes" : "No"));
    }
    
}
