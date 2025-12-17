package aims.store;
import java.util.ArrayList;
import aims.media.Media;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 1000;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public static int qtyInStore = 0;

    public void addMedia(Media media) {
        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore.add(media);
            qtyInStore++;
            System.out.println("'" + media.getTitle() + "'" + " has been added to store.");
        } else {
            System.out.println("Store is full. Cannot add DVD.");
        }
    }

    public void removeMedia(Media media) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore.get(i).equals(media)) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore.set(j, itemsInStore.get(j + 1));
                }
                itemsInStore.remove(qtyInStore - 1);
                qtyInStore--;
                System.out.println("'" + media.getTitle() + "'" + " has been removed from store.");
                return;
            }
        }
        System.out.println("'" + media.getTitle() + "'" + " not found in store.");
    }

    public Media findMediaByTitle(String title, Store store) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore.get(i).getTitle().equalsIgnoreCase(title)) {
                return itemsInStore.get(i);
            }
        }
        return null; // Not found
    }

    public void printStore() {
        System.out.println("**********************************************STORE**********************************************");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).getAllInfo());
        }
        System.out.println("*************************************************************************************************");
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

}
