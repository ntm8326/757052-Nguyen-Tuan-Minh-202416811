package aims.Store;

import aims.Disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_IN_STORE = 100;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_IN_STORE];
    private int qtyInStore = 0;	

    public void addDVD(DigitalVideoDisc disc) {
        if (qtyInStore >= MAX_NUMBERS_IN_STORE) {
            System.out.println("The store is full. Cannot add more DVDs.");
        } else {
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("The DVD \"" + disc.getTitle() + "\" has been added to the store.");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == disc) {
                found = true;
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("The DVD \"" + disc.getTitle() + "\" has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("The DVD \"" + disc.getTitle() + "\" is not found in the store.");
        }
    }
    public void printStore() {
        System.out.println("***********************STORE***********************");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        }
        System.out.println("***************************************************");
    }

}
