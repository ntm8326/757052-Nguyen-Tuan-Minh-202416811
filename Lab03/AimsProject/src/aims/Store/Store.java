package aims.Store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
public class Store {
	public static final int MAX_NUMBERS_IN_STORE = 100;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    private int qtyInStore = 0;	

    public void printStore() {
        System.out.println("***********************STORE***********************");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        }
        System.out.println("***************************************************");
    }

}
