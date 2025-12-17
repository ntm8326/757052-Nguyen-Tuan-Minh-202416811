package aims.screen;

import java.awt.*;
import javax.swing.*;
import aims.cart.Cart;
import aims.media.CompactDisc;
import aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfArtist;
    private JTextField tfCost;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        setTitle("Add CD to Store");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 10, 10)); 

        center.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        center.add(tfDirector);

        center.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        center.add(tfArtist);

        center.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        center.add(tfCost);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> {
            CompactDisc cd = new CompactDisc(
                tfTitle.getText(),
                tfCategory.getText(),
                tfDirector.getText(),
                Float.parseFloat(tfCost.getText()),
                tfArtist.getText()
            );
            store.addMedia(cd);
            JOptionPane.showMessageDialog(null, "CD Added Successfully!");
        });
        center.add(btnAdd);

        return center;
    }
}