package aims;

import hust.soict.dsai.aims.media.Media;
import hust.soict.cyber.aims.screen.StoreScreen;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import aims.Cart.Cart;
import aims.Store.Store;
import hust.soict.dsai.aims.media.Playable;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Aims {
    private static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        // Optionally populate store with some sample media for demo/testing.
        seedSampleData();

        while (true) {
            showMenu();
            int choice = readIntInRange(0, 3);
            switch (choice) {
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    viewCart();
                    break;
                default:
                    System.out.println("Unknown option. Try again.");
            }
        }

    }
   

    private static void showMenu() {
        System.out.println();
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    private static void viewStore() {
        while (true) {
            System.out.println();
            System.out.println("Items in store:");
            printStoreItems();

            storeMenu();
            int choice = readIntInRange(0, 4);
            switch (choice) {
                case 0:
                    return; // back to main menu
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCartFromStore();
                    break;
                case 3:
                    playMediaFromStore();
                    break;
                case 4:
                    viewCartBrief();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    private static void printStoreItems() {
        ArrayList<Media> items = store.getItemsInStore();
        if (items.isEmpty()) {
            System.out.println("Store is empty.");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            Media m = items.get(i);
            System.out.printf("%d. %s - %s - %.2f\n", i + 1, m.getTitle(), m.getClass().getSimpleName(), m.getCost());
        }
    }

    private static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = readNonEmptyLine();
        Media m = findMediaInStoreByTitle(title);
        if (m == null) {
            System.out.println("Media not found in store with that title.");
            return;
        }
        System.out.println("---- Media Details ----");
        System.out.println(m.toString());
        System.out.println("------------------------");

        mediaDetailsMenu();
        int choice = readIntInRange(0, 2);
        switch (choice) {
            case 0:
                return;
            case 1:
                cart.addMedia(m);
                System.out.println("Added to cart. Number of items in cart: " + cart.getItemsOrdered().size());
                return;
            case 2:
                if (m instanceof Playable) {
                    ((Playable) m).play();
                } else {
                    System.out.println("This media cannot be played.");
                }
                return;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    private static void addMediaToCartFromStore() {
        System.out.print("Enter the title of the media to add: ");
        String title = readNonEmptyLine();
        Media m = findMediaInStoreByTitle(title);
        if (m == null) {
            System.out.println("No media found with that title.");
            return;
        }
        cart.addMedia(m);
        System.out.println("Added \"" + m.getTitle() + "\" to cart.");
        System.out.println("Cart now has " + cart.getItemsOrdered().size() + " items.");
    }

    private static void playMediaFromStore() {
        System.out.print("Enter the title of the media to play: ");
        String title = readNonEmptyLine();
        Media m = findMediaInStoreByTitle(title);
        if (m == null) {
            System.out.println("No media found with that title.");
            return;
        }
        if (m instanceof Playable) {
            ((Playable) m).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static void updateStore() {
        while (true) {
            updateStoreMenu();
            int choice = readIntInRange(0, 2);
            switch (choice) {
                case 0:
                    return; // back to main menu
                case 1:
                    addMediaToStoreInteractive();
                    break;
                case 2:
                    removeMediaFromStoreInteractive();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void updateStoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to the store");
        System.out.println("2. Remove a media from the store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    private static void addMediaToStoreInteractive() {
        System.out.println("Choose type to add:");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        System.out.println("0. Cancel");
        int type = readIntInRange(0, 3);
        if (type == 0) return;

        System.out.print("Enter id (int): ");
        int id = readInt();
        System.out.print("Enter title: ");
        String title = readNonEmptyLine();
        System.out.print("Enter category: ");
        String category = readNonEmptyLine();
        System.out.print("Enter cost (float): ");
        float cost = readFloat();

        switch (type) {
            case 1: // Book
                Book book = new Book(id, category, category, cost);
                book.setId(id);
                book.setTitle(title);
                book.setCategory(category);
                book.setCost(cost);
                // Add authors interactively
                System.out.println("Enter authors (enter blank line to finish):");
                while (true) {
                    String author = scanner.nextLine().trim();
                    if (author.isEmpty()) break;
                    book.addAuthor(author);
                }
                store.addMedia(book);
                System.out.println("Book added to store.");
                break;
            case 2: // DVD
			String director = null;
			DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, id, cost);
                dvd.setId(id);
                dvd.setTitle(title);
                dvd.setCategory(category);
                dvd.setCost(cost);
                System.out.print("Enter director: ");
                String director1 = readNonEmptyLine();
                dvd.setDirector(director1);
                System.out.print("Enter length (int): ");
                int length = readInt();
                dvd.setLength(length);
                store.addMedia(dvd);
                System.out.println("DVD added to store.");
                break;
            case 3: // CD
			String artist = null;
		    String director2 = null;
			CompactDisc cd = new CompactDisc(title, category, artist, director2, id, cost);
                cd.setId(id);
                cd.setTitle(title);
                cd.setCategory(category);
                cd.setCost(cost);
                System.out.print("Enter artist: ");
                String artist1 = readNonEmptyLine();
                cd.setArtist(artist1);
                System.out.print("Enter director: ");
                String cdDirector = readNonEmptyLine();
                cd.setDirector(director2);
                // Add tracks
                System.out.println("Now add tracks (empty title to finish):");
                while (true) {
                    System.out.print("Track title: ");
                    String ttitle = scanner.nextLine().trim();
                    if (ttitle.isEmpty()) break;
                    System.out.print("Track length (int): ");
                    int tlen = readInt();
                    Track t = new Track(ttitle, tlen);
                    cd.addTrack(t);
                    System.out.println("Track added.");
                }
                store.addMedia(cd);
                System.out.println("CD added to store.");
                break;
            default:
                System.out.println("Unknown type.");
        }
    }

    private static void removeMediaFromStoreInteractive() {
        System.out.print("Enter title of media to remove: ");
        String title = readNonEmptyLine();
        Media m = findMediaInStoreByTitle(title);
        if (m == null) {
            System.out.println("No media with that title in store.");
            return;
        }
        store.removeMedia(m);
        System.out.println("Removed \"" + m.getTitle() + "\" from store.");
    }

    // ---------------------- VIEW CART ----------------------
    private static void viewCart() {
        while (true) {
            System.out.println();
            printCartDetails();
            cartMenu();
            int choice = readIntInRange(0, 5);
            switch (choice) {
                case 0:
                    return; // back
                case 1:
                    filterMediasInCart();
                    break;
                case 2:
                    sortMediasInCart();
                    break;
                case 3:
                    removeMediaFromCartInteractive();
                    break;
                case 4:
                    playMediaFromCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private static void printCartDetails() {
        ArrayList<Media> items = cart.getItemsOrdered();
        System.out.println("Your cart:");
        if (items.isEmpty()) {
            System.out.println("(empty)");
        } else {
            for (int i = 0; i < items.size(); i++) {
                Media m = items.get(i);
                System.out.printf("%d. %s - %s - %.2f\n", i + 1, m.getTitle(), m.getClass().getSimpleName(), m.getCost());
            }
            System.out.printf("Total cost: %.2f\n", cart.totalCost());
        }
    }

    private static void viewCartBrief() {
        ArrayList<Media> items = cart.getItemsOrdered();
        System.out.println("Cart contains " + items.size() + " items. Total: " + cart.totalCost());
    }

    private static void filterMediasInCart() {
        System.out.println("Filter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.println("0. Cancel");
        int choice = readIntInRange(0, 2);
        if (choice == 0) return;
        if (choice == 1) {
            System.out.print("Enter id: ");
            int id = readInt();
            boolean found = false;
            for (Media m : cart.getItemsOrdered()) {
                if (m.getId() == id) {
                    System.out.println(m);
                    found = true;
                }
            }
            if (!found) System.out.println("No media with id " + id + " in cart.");
        } else {
            System.out.print("Enter title or substring: ");
            String q = readNonEmptyLine().toLowerCase();
            boolean found = false;
            for (Media m : cart.getItemsOrdered()) {
                if (m.getTitle().toLowerCase().contains(q)) {
                    System.out.println(m);
                    found = true;
                }
            }
            if (!found) System.out.println("No media matched the query.");
        }
    }

    private static void sortMediasInCart() {
        System.out.println("Sort by:");
        System.out.println("1. Title (title asc, cost desc as tiebreaker)");
        System.out.println("2. Cost (cost desc, title asc as tiebreaker)");
        System.out.println("0. Cancel");
        int choice = readIntInRange(0, 2);
        if (choice == 0) return;
        ArrayList<Media> items = cart.getItemsOrdered();
        switch (choice) {
            case 1:
                Collections.sort(items, Media.COMPARE_BY_TITLE_COST);
                System.out.println("Sorted by title then cost.");
                break;
            case 2:
                Collections.sort(items, Media.COMPARE_BY_COST_TITLE);
                System.out.println("Sorted by cost then title.");
                break;
        }
    }

    private static void removeMediaFromCartInteractive() {
        System.out.print("Enter title of media to remove from cart: ");
        String title = readNonEmptyLine();
        Media found = null;
        for (Media m : cart.getItemsOrdered()) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                found = m;
                break;
            }
        }
        if (found == null) {
            System.out.println("No such media in cart.");
            return;
        }
        cart.removeMedia(found);
        System.out.println("Removed \"" + found.getTitle() + "\" from cart.");
    }

    private static void playMediaFromCart() {
        System.out.print("Enter title of media to play from cart: ");
        String title = readNonEmptyLine();
        Media found = null;
        for (Media m : cart.getItemsOrdered()) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                found = m;
                break;
            }
        }
        if (found == null) {
            System.out.println("No such media in cart.");
            return;
        }
        if (found instanceof Playable) {
            ((Playable) found).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static void placeOrder() {
        if (cart.getItemsOrdered().isEmpty()) {
            System.out.println("Cart is empty. Cannot place order.");
            return;
        }
        System.out.println("An order has been created. Total: " + cart.totalCost());
        // For this lab, simply empty the cart after placing order
        cart.emptyCart();
        System.out.println("Cart is now empty.");
    }

    private static Media findMediaInStoreByTitle(String title) {
        for (Media m : store.getItemsInStore()) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }

    private static int readInt() {
        while (true) {
            try {
                int v = Integer.parseInt(scanner.nextLine().trim());
                return v;
            } catch (NumberFormatException e) {
                System.out.print("Invalid integer. Try again: ");
            }
        }
    }

    private static int readIntInRange(int min, int max) {
        while (true) {
            int v = readInt();
            if (v >= min && v <= max) return v;
            System.out.print("Input out of range (" + min + "-" + max + "). Try again: ");
        }
    }

    private static float readFloat() {
        while (true) {
            try {
                float f = Float.parseFloat(scanner.nextLine().trim());
                return f;
            } catch (NumberFormatException e) {
                System.out.print("Invalid float. Try again: ");
            }
        }
    }

    private static String readNonEmptyLine() {
        while (true) {
            String s = scanner.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.print("Input cannot be empty. Try again: ");
        }
    }
    private static void seedSampleData() {
        if (!store.getItemsInStore().isEmpty()) return;
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 24.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 18.50f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 21.99f);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 17.99f);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Avatar", "Sci-Fi", "James Cameron", 162, 22.99f);
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
        Book book2 = new Book("1984", "Dystopian", 8.99f);
        book2.addAuthor("George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Fiction", 12.99f);
        book3.addAuthor("Harper Lee");
    }

}
