package aims.screen;
import javax.swing.*;

import aims.media.*;
import aims.cart.Cart;
import aims.exceptions.LimitExceededException;
import aims.exceptions.PlayerException;

import java.awt.*;

public class MediaStore extends JPanel{

    private Media media;
    private Cart cart;
    
    public MediaStore(Media media) {
        this(media, null);
    }
    
    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addButton = new JButton("Add to cart");
        addButton.addActionListener(e -> addToCart());
        container.add(addButton);
        
        if (media instanceof Play) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> playMedia());
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void addToCart() {
        if (cart != null) {
            try {
                cart.addMedia(media);
                
                JOptionPane.showMessageDialog(this,
                        "Media '" + media.getTitle() + "' has been added to cart.",
                        "Add to Cart",
                        JOptionPane.INFORMATION_MESSAGE);
                        
            } catch (LimitExceededException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Cart Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void playMedia() {
        if (media instanceof Play) {
            try {
                ((Play) media).play();
                JPanel panel = new JPanel(new BorderLayout());
                panel.add(new JLabel("Media Playing... "), BorderLayout.CENTER);

                JDialog dialog = new JDialog();
                dialog.setTitle("Playing: " + media.getTitle());
                dialog.setSize(300, 150);
                dialog.setLocationRelativeTo(this);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                JButton backButton = new JButton("Back");
                backButton.addActionListener(e -> dialog.dispose());

                JPanel bottomPanel = new JPanel();
                bottomPanel.add(backButton);

                dialog.add(panel, BorderLayout.CENTER);
                dialog.add(bottomPanel, BorderLayout.SOUTH);
                dialog.setVisible(true);

            } catch (PlayerException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Illegal Media Length", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}


