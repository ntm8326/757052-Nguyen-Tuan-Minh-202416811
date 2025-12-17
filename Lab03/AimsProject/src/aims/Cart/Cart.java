package aims.Cart;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import hust.soict.dsai.aims.media.Media;

public class Cart {

    // DÙNG ObservableList THAY VÌ ArrayList
    private ObservableList<Media> itemsOrdered =
            FXCollections.observableArrayList();

    public void addMedia(Media media) {
        itemsOrdered.add(media);
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The order had no item yet");
        } else {
            boolean found = false;
            Iterator<Media> iterator = itemsOrdered.iterator();
            while (iterator.hasNext()) {
                Media item = iterator.next();
                if (item.equals(media)) {
                    iterator.remove();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("The item has not been in the list yet!");
            }
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void printInfo() {
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.println(i + "   " + media.getTitle() + "  " + media.getCost());
            i++;
        }
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.println(i + ". " + media.toString());
            i++;
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void emptyCart() {
        itemsOrdered.clear();
    }

    // QUAN TRỌNG: TRẢ VỀ ObservableList
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void setItemsOrdered(ObservableList<Media> itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }
}

