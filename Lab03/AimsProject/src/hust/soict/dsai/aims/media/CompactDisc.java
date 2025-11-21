package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class CompactDisc extends Disc {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	public CompactDisc(String title) {
		super();
		setTitle(title);
	}
	public CompactDisc(String category, String title, float cost) {
		super();
		setCategory(category);
		setTitle(title);
		setCost(cost);
	}
	public CompactDisc(String director, String category, String artist, String title, float cost) {
		super();
		setDirector(director);
		setCategory(category);
		this.artist = artist;
		setTitle(title);
		setCost(cost);
	}
	public CompactDisc(String title, String category, String director,String artist, int length, float cost) {
		super();
		setTitle(title);
		setCategory(category);
		setDirector(director);
		this.artist = artist;
		setLength(length);
		setCost(cost);
	}

}
