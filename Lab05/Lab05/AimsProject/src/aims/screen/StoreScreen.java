package aims.screen;
import javax.swing.*;
import aims.store.Store;
import aims.cart.Cart;
import aims.media.Media;
import aims.media.Book;
import aims.media.CompactDisc;
import aims.media.DigitalVideoDisc;
import aims.media.Track;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    
    private Store store;
    private Cart cart;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        
        // Link "Add Book"
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            new AddBookToStoreScreen(store, cart);
            this.dispose();
        });
        smUpdateStore.add(addBook);

        // Link "Add CD"
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store, cart);
            this.dispose();
        });
        smUpdateStore.add(addCD);

        // Link "Add DVD"
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store, cart);
            this.dispose();
        });
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);
        
        // Link "View Store" (Refresh)
        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> {
            new StoreScreen(store, cart);
            this.dispose();
        });
        menu.add(viewStore);
        
        // Link "View Cart" (Menu Item)
        JMenuItem viewCart = new JMenuItem("View Cart");
        viewCart.addActionListener(e -> new CartScreen(cart));
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 50));
        title.setForeground(Color.CYAN);

        JButton cartButton = new JButton("View Cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize(new Dimension(100, 50));
        
        cartButton.addActionListener(e -> new CartScreen(cart)); 

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(0, 3, 10, 10));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (Media m : mediaInStore) {
            MediaStore cell = new MediaStore(m, cart);
            grid.add(cell);
        }

        return grid;
    }

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd1  = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2  = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3  = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        CompactDisc cd1 = new CompactDisc("Hybrid Theory", "Rock", "Linkin Park", 15.99f, "Chester Bennington");
        cd1.addTrack(new Track("Papercut", 185));
        cd1.addTrack(new Track("One Step Closer", 155));
        cd1.addTrack(new Track("With You", 200));
        CompactDisc cd2 = new CompactDisc("Back in Black", "Rock", "AC/DC", 14.99f, "Brian Johnson");
        cd2.addTrack(new Track("Hells Bells", 312));
        cd2.addTrack(new Track("Shoot to Thrill", 315));    
        CompactDisc cd3 = new CompactDisc("The Dark Side of the Moon", "Progressive Rock", "Pink Floyd", 16.99f, "David Gilmour");
        cd3.addTrack(new Track("Speak to Me", 90));
        cd3.addTrack(new Track("Breathe", 163));

        Book book1 = new Book("The Great Gatsby", "Fiction", 10.99f);
        book1.addAuthor("F. Scott Fitzgerald");
        book1.addAuthor("Other Authors");
        Book book2 = new Book("1984", "Dystopian", 8.99f);
        book2.addAuthor("George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Fiction", 12.99f);
        book3.addAuthor("Harper Lee");

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);

        DigitalVideoDisc brokenDVD = new DigitalVideoDisc("Broken DVD", "Test", "Tester", 0, 5.0f); // Length is 0!
        store.addMedia(brokenDVD);

        CompactDisc brokenCD = new CompactDisc("Broken CD", "Bruh", "Lmao", 10, "Kekw");
        brokenCD.addTrack(new Track("Good Track", 5));
        brokenCD.addTrack(new Track("Bad Track", 0)); // Length 0!
        store.addMedia(brokenCD);

        new StoreScreen(store, cart);
    }
}
