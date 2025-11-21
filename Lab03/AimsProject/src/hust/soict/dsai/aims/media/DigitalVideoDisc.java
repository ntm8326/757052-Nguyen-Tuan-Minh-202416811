package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;
	public DigitalVideoDisc(String title) {
		super();
		setTitle(title);
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String category, String title, float cost) {
		super();
		setCategory(category);
		setTitle(title);
		setCost(cost);
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String director, String category, String title, float cost) {
		super();
		setDirector(director);
		setCategory(category);
		setTitle(title);
		setCost(cost);
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		setTitle(title);
		setCategory(category);
		setDirector(director);
		setLength(length);
		setCost(cost);
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
	}
	 public String toString() {
	        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
	        }
	 public boolean isMatch(String title) {
	        return getTitle().equalsIgnoreCase(title);
	        }
	 public static int getNbDigitalVideoDiscs() {
		 return nbDigitalVideoDiscs;
	 }
	 public static void setNbDigitalVideoDiscs(int nbDigitalVideoDiscs) {
		 DigitalVideoDisc.nbDigitalVideoDiscs = nbDigitalVideoDiscs;
	 }
	 public void play(){
		 System.out.println("Playing DVD: " + this.getTitle());
		 System.out.println("DVD length: " + this.getLength());
	 }
}