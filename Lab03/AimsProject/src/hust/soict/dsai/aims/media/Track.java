package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private int length;
	private String title;
	public int getLength() {
		return length;
	}
	public String getTitle() {
		return title;
	}
	public Track(String title, int length) {
		super();
		this.length = length;
		this.title = title;
	}
	public Track(String title) {
		super();
		this.title = title;
	}
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	@Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track other = (Track) obj;
            return this.title == other.title && this.length == other.length;
        }
        return false;
    }
}
