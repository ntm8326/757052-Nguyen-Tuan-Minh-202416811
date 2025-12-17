package aims.screen;

import java.awt.*;
import javax.swing.*;
import aims.cart.Cart;
import aims.media.Book;
import aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        setTitle("Add Book to Store");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 2, 10, 10));

        center.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        center.add(tfCost);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> {
            Book book = new Book(
                tfTitle.getText(),
                tfCategory.getText(),
                Float.parseFloat(tfCost.getText())
            );
            store.addMedia(book);
            JOptionPane.showMessageDialog(null, "Book Added Successfully!");
        });
        center.add(btnAdd);

        return center;
    }
}