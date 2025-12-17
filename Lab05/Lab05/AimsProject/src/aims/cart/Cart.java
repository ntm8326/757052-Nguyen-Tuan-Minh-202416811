package aims.cart;

// 1. USE YOUR CUSTOM EXCEPTION
import aims.exceptions.LimitExceededException; 
import aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Collections;
import java.util.Comparator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media media) throws LimitExceededException {
        
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media has been added");
        } else {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            qtyOrdered--;
            System.out.println("Removed from cart: " + media.getTitle());
        } else {
            System.out.println("Media not found " + media.getTitle());
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }
    
    public void filterById(int id) {
        boolean found = false;
        System.out.println("Filtering by ID: " + id);
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Result: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with ID: " + id);
        }
    }

    public void filterByTitle(String title) {
        boolean found = false;
        System.out.println("Filtering by Title: " + title);
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Result: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found matching: " + title);
        }
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, new Comparator<Media>() {
            @Override
            public int compare(Media m1, Media m2) {
                int titleComparison = m1.getTitle().compareToIgnoreCase(m2.getTitle());
                
                if (titleComparison != 0) {
                    return titleComparison;
                }
                
                return Double.compare(m2.getCost(), m1.getCost());
            }
        });
        System.out.println("Cart sorted by Title.");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, new Comparator<Media>() {
            @Override
            public int compare(Media m1, Media m2) {
                int costComparison = Double.compare(m2.getCost(), m1.getCost());
                
                if (costComparison != 0) {
                    return costComparison;
                }
            
                return m1.getTitle().compareToIgnoreCase(m2.getTitle());
            }
        });
        System.out.println("Cart sorted by Cost.");
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void clearCart() {
        itemsOrdered.clear();
        
        qtyOrdered = 0; 
        
        System.out.println("Cart has been cleared.");
    }
}