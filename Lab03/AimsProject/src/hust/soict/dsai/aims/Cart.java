package hust.soict.dsai.aims;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		}
		else if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc " + disc.getTitle() + " has successfully added!");
			
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdlist) {
		int len = dvdlist.length;
		if (qtyOrdered + len > MAX_NUMBERS_ORDERED) {
			System.out.println("Can not add these amount of discs");
		}
		else {
			for (int i = 0 ; i < len; i++) {
				itemsOrdered[qtyOrdered] = dvdlist[i];
				qtyOrdered++;
				System.out.println("The disc " + dvdlist[i].getTitle() + " has successfully added!");
			}
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if(qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full.");
		}
		else {
			itemsOrdered[qtyOrdered] = dvd1;
			itemsOrdered[qtyOrdered+1] = dvd2;
			System.out.println("Two disc has successfully added");
		}
	}
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean isEmpty = true;
        boolean found = false;
        for(int j = 0; j < qtyOrdered; j++) {
            if(itemsOrdered[j] != null) {
                isEmpty = false;
                break;
            }
        }
        if (qtyOrdered == 0 || isEmpty) {
            System.out.println("This cart has no item yet!");
        }
        else {
        	for(int i = 0; i < qtyOrdered; i++) {
                if(itemsOrdered[i] == disc) {
                    itemsOrdered[i] = null;
                    System.out.println("The disc " + disc.getTitle() + " has successfully removed!");
                    found = true;
                    for(int j = i; j < qtyOrdered - 1; j++) {
                    	DigitalVideoDisc temp = itemsOrdered[i];
                    	itemsOrdered[i] = itemsOrdered[i+1];
                    	itemsOrdered[i+1] = temp;
                    }
                    qtyOrdered--;
                    break;
                    }
                }
             if (!found) {
                 System.out.println("Disc not found in the cart");
             }
        }
    }
	public float totalCost() {
		float total = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] != null) {
				total += itemsOrdered[i].getCost();
			}
		}
		return total;
	}
	public void printInfo() {
		for(int i=0;i<qtyOrdered;i++) {
			System.out.println((i+1)+"   "+(itemsOrdered[i].getTitle())+"  "+ (itemsOrdered[i].getCost()) );
		}
	}
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found: " + itemsOrdered[i]);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No match for ID: " + id);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found: " + itemsOrdered[i]);
                found = true;
            }
        }
        if (!found) System.out.println("No match for title: " + title);
    }
}
