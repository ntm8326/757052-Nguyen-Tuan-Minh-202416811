package aims.Store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
public class Store {
	public static final int MAX_NUMBERS_IN_STORE = 1000;
    private int qtyInStore = 0;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public void addMedia(Media media) {
		if(qtyInStore < MAX_NUMBERS_IN_STORE) {
			boolean exist = false;
			for(Media item : itemsInStore) {
				if (item.equals(media)) {
					exist = true;
					break;
				}
			}
			if(exist) {
				System.out.println("The item is already existed!");
			}
			else {
				itemsInStore.add(media);
				qtyInStore++;
			}
		}
		else {
			System.out.println("Our store reached limit. Can not add more item!");
		}
	}
	public void removeMedia(Media media) {
		if( itemsInStore.size() == 0 || qtyInStore == 0){
			System.out.println("The store had no item yet");
		}
		else {
			boolean found = false;
			for(Media item : itemsInStore) {
				if (item.equals(media)) {
					itemsInStore.remove(media);
					qtyInStore--;
					found = true;
					break;
				}
			}
			if(!found) {
				System.out.println("We have not had this item yet!");
			}
		}
	}
    public void printStore() {
        System.out.println("***********************STORE***********************");
        int i = 1;
        for (Media item : itemsInStore) {
            System.out.println(i + ". " + item.toString());
            i++;
        }
        System.out.println("***************************************************");
    }
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
