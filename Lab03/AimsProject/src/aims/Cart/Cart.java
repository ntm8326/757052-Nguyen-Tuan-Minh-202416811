package aims.Cart;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public void addMedia(Media media) {
		boolean exist = false;
		for(Media item : itemsOrdered) {
			if (item.equals(media)) {
				exist = true;
				break;
			}
		}
		if(exist) {
			System.out.println("The item is already existed!");
		}
		else {
			itemsOrdered.add(media);
		}
	}
	public void removeMedia(Media media) {
		if( itemsOrdered.size() == 0){
			System.out.println("The order had no name yet");
		}
		else {
			boolean found = false;
			for(Media item : itemsOrdered) {
				if (item.equals(media)) {
					itemsOrdered.remove(media);
					found = true;
					break;
				}
			}
			if(!found) {
				System.out.println("The item has not been in the list yet!");
			}
		}
	}
	public float totalCost() {
		float total = 0;
		for(Media media : itemsOrdered) {
			total += media.getCost();
		}
		return total;
	}
	public void printInfo() {
		int i = 1;
		for(Media media : itemsOrdered) {
			System.out.println((i)+"   "+(media.getTitle())+"  "+ (media.getCost()) );
			i++;
		}
	}
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.println((i) + ". " + media.toString());
            i++;
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found: " + media);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No match for ID: " + id);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Found: " + media);
                found = true;
            }
        }
        if (!found) System.out.println("No match for title: " + title);
    }
}
