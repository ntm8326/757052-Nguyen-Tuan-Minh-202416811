package aims.screen;

import java.awt.*;
import javax.swing.*;
import aims.cart.Cart;
import aims.media.DigitalVideoDisc;
import aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        setTitle("Add DVD to Store");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 10, 10)); // 6 rows, 2 columns

        center.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        center.add(tfDirector);

        center.add(new JLabel("Length:"));
        tfLength = new JTextField();
        center.add(tfLength);

        center.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        center.add(tfCost);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> {
            DigitalVideoDisc dvd = new DigitalVideoDisc(
                tfTitle.getText(),
                tfCategory.getText(),
                tfDirector.getText(),
                Integer.parseInt(tfLength.getText()),
                Float.parseFloat(tfCost.getText())
            );
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(null, "DVD Added Successfully!");
        });
        center.add(btnAdd);

        return center;
    }
}