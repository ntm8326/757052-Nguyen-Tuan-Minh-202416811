package hust.soict.cyber.aims.screen;
import aims.Store.*;
import hust.soict.dsai.aims.media.*;
import javax.swing.*;
import java.awt.*;
import aims.Cart.*;
public class MediaStore extends JPanel {
    private Media media;
    private Cart cart = new Cart();

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAdd = new JButton("Add to cart");
        btnAdd.addActionListener(e -> cart.addMedia(media));
        container.add(btnAdd);
        
        if (media instanceof Playable) {
        	JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(e -> {
                showPlayDialog();
            });
            container.add(btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    private void showPlayDialog() {

        JDialog dialog = new JDialog();
        dialog.setTitle("Playing: " + media.getTitle());
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(null);

        JLabel info = new JLabel(((Playable) media).play(), SwingConstants.CENTER);
        dialog.add(info);

        dialog.setVisible(true);
    }


}

