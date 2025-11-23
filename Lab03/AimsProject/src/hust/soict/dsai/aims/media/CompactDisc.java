package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
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
	public CompactDisc(String title, String category, String director, float cost, String artist) {
        setTitle(title);
        setCategory(category);
        setDirector(director);
        setCost(cost);
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void addTrack(Track track) {
		if (!tracks.contains(track) || tracks.isEmpty() || tracks == null) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists!");
        }
	}
	public void removeTrack(Track track) {
		if(tracks.size() <= 0) {
			System.out.println("The track has no item yet");
		}
		else {
			 if (tracks.contains(track)) {
		            tracks.remove(track);
		        } else {
		            System.out.println("Track not found!");
		        }
		}
	}
	public int getLength() {
		int totalLength = 0;
		for (Track track : tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	public void play(){
		for(Track track : tracks) {
			track.play();
		}
	}
	@Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + artist + " - " + getLength() + "mins: " + "$" + getCost();
    }
}
