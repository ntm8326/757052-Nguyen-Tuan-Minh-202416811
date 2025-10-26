package aims.Disc;

public class DigitalVideoDisc {
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String category, String title, float cost) {
		super();
		this.category = category;
		this.title = title;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String director, String category, String title, float cost) {
		super();
		this.director = director;
		this.category = category;
		this.title = title;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	 public String toString() {
	        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
	        }
	 public boolean isMatch(String title) {
	        return this.title.equalsIgnoreCase(title);
	        }
	 public static int getNbDigitalVideoDiscs() {
		 return nbDigitalVideoDiscs;
	 }
	 public static void setNbDigitalVideoDiscs(int nbDigitalVideoDiscs) {
		 DigitalVideoDisc.nbDigitalVideoDiscs = nbDigitalVideoDiscs;
	 }
	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
}