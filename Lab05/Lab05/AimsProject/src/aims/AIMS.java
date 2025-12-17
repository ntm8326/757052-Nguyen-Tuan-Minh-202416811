package aims;

import java.util.Scanner;

import aims.cart.Cart;
import aims.exceptions.LimitExceededException; // Import your custom exception
import aims.exceptions.PlayerException;        // Import your custom exception
import aims.media.Book;
import aims.media.CompactDisc;
import aims.media.DigitalVideoDisc;
import aims.media.Media;
import aims.media.Play; // Use the interface for play checks
import aims.media.Track;
import aims.store.Store;

public class AIMS {

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Store Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("Media Details Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (media instanceof Play) { // Check interface instead of class type
            System.out.println("2. Play");
        }
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Cart Options: ");
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

    // ... (Sort and Filter menus remain the same) ...
    public static void sortMenu() {
        System.out.println("Sorting Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void filterMenu() {
        System.out.println("Filter Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by title");
        System.out.println("2. Filter by ID");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void main(String[] args) {

        // 1. Setup Data
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

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

        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        Store store = new Store();

        // 2. Setup Store and Cart (Wrap in try-catch for robustness)
        store.addMedia(dvd1); store.addMedia(dvd2); store.addMedia(dvd3);
        store.addMedia(cd1); store.addMedia(cd2); store.addMedia(cd3);
        store.addMedia(book1); store.addMedia(book2); store.addMedia(book3);

        try {
            cart.addMedia(dvd1);
            cart.addMedia(cd1);
            cart.addMedia(book1);
        } catch (LimitExceededException e) {
            System.out.println("Cannot initialize cart: " + e.getMessage());
        }

        // 3. Application Loop
        while (true) {
            showMenu();
            int choice = -1;
            try { choice = Integer.parseInt(scanner.nextLine().trim()); } catch (Exception e) { choice = -1; }

            if (choice == 0) {
                System.out.println("Exiting the application.");
                break;
            }

            if (choice == 1) { // View store
                boolean backToMain = false;
                while (!backToMain) {
                    store.printStore();
                    storeMenu();
                    int storeChoice = -1;
                    try { storeChoice = Integer.parseInt(scanner.nextLine().trim()); } catch(Exception e) {}

                    switch (storeChoice) {
                        case 0: backToMain = true; break;
                        case 1: { // See media details
                            System.out.print("Enter the media's title: ");
                            String title = scanner.nextLine().trim();
                            Media found = store.findMediaByTitle(title, store);
                            if (found == null) {
                                System.out.println("Media not found");
                            } else {
                                System.out.println(found.getAllInfo());
                                mediaDetailsMenu(found);
                                int mdChoice = Integer.parseInt(scanner.nextLine().trim());
                                if (mdChoice == 1) {
                                    // FIX: Catch LimitExceededException
                                    try {
                                        cart.addMedia(found);
                                        System.out.println("Added to cart. Items: " + cart.getQtyOrdered());
                                    } catch (LimitExceededException e) {
                                        System.err.println(e.getMessage());
                                    }
                                } else if (mdChoice == 2) {
                                    // FIX: Catch PlayerException
                                    if (found instanceof Play) {
                                        try {
                                            ((Play) found).play();
                                        } catch (PlayerException e) {
                                            System.err.println(e.getMessage());
                                        }
                                    }
                                }
                            }
                            break;
                        }
                        case 2: { // Add to cart
                            System.out.print("Enter the media's title: ");
                            String title = scanner.nextLine().trim();
                            Media found = store.findMediaByTitle(title, store);
                            if (found != null) {
                                // FIX: Catch LimitExceededException
                                try {
                                    cart.addMedia(found);
                                    System.out.println("Number of items in cart: " + cart.getQtyOrdered());
                                } catch (LimitExceededException e) {
                                    System.err.println(e.getMessage());
                                }
                            } else {
                                System.out.println("Media not found");
                            }
                            break;
                        }
                        case 3: { // Play media
                            System.out.print("Enter the media's title: ");
                            String title = scanner.nextLine().trim();
                            Media found = store.findMediaByTitle(title, store);
                            if (found != null) {
                                // FIX: Catch PlayerException
                                if (found instanceof Play) {
                                    try {
                                        ((Play) found).play();
                                    } catch (PlayerException e) {
                                        System.err.println(e.getMessage());
                                    }
                                } else {
                                    System.out.println("This media cannot be played.");
                                }
                            } else {
                                System.out.println("Media not found");
                            }
                            break;
                        }
                        case 4: { // See current cart
                            // Logic largely same, just checking play/remove exceptions if needed
                            boolean backToStore = false;
                            while (!backToStore) {
                                cart.printCart();
                                cartMenu();
                                int cartChoice = Integer.parseInt(scanner.nextLine().trim());
                                switch (cartChoice) {
                                    case 0: backToStore = true; break;
                                    case 1: // Filter
                                        filterMenu();
                                        int fChoice = Integer.parseInt(scanner.nextLine().trim());
                                        if (fChoice == 1) {
                                            System.out.print("Enter title: ");
                                            cart.filterByTitle(scanner.nextLine().trim());
                                        } else if (fChoice == 2) {
                                            System.out.print("Enter ID: ");
                                            cart.filterById(Integer.parseInt(scanner.nextLine().trim()));
                                        }
                                        break;
                                    case 2: // Sort
                                        sortMenu();
                                        int sChoice = Integer.parseInt(scanner.nextLine().trim());
                                        if (sChoice == 1) cart.sortByTitle();
                                        else if (sChoice == 2) cart.sortByCost();
                                        break;
                                    case 3: // Remove
                                        System.out.print("Enter title to remove: ");
                                        String rmTitle = scanner.nextLine().trim();
                                        Media rmFound = store.findMediaByTitle(rmTitle, store); // Simplification, usually search cart
                                        if (rmFound != null) cart.removeMedia(rmFound);
                                        break;
                                    case 4: // Play
                                        System.out.print("Enter title to play: ");
                                        String pTitle = scanner.nextLine().trim();
                                        Media pFound = store.findMediaByTitle(pTitle, store);
                                        if (pFound instanceof Play) {
                                            try {
                                                ((Play) pFound).play();
                                            } catch (PlayerException e) {
                                                System.err.println(e.getMessage());
                                            }
                                        }
                                        break;
                                    case 5: // Place Order
                                        System.out.println("Order created!");
                                        cart.clearCart();
                                        break;
                                }
                            }
                            break;
                        }
                    }
                }
            } else if (choice == 2) { 
                System.out.println("Update store feature not implemented in Console View.");
            } else if (choice == 3) { 
                // See Cart (Copy logic from Case 1.4 or refactor into method)
                System.out.println("Please enter View Store -> See Cart to access cart features.");
            }
        }
        scanner.close();
    }
}