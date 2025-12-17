package aims.media;

import java.util.List;

import aims.exceptions.PlayerException;

public class CompactDisc extends Disc implements Play {
    
    private String artist;

    private List<Track> tracks = new java.util.ArrayList<Track>();
    
    public String getArtist() {
        return artist;
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public List<Track> getTracks() {
        return tracks;
    }
    
    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String getAllInfo() {
        return "CD - ID: " + this.id + " - " + getTitle() + " - " + getCategory() + " - " + artist + " - " + getLength() + "mins: " + "$" + getCost();
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track) || tracks.isEmpty() || tracks == null) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists!");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track not found!");
        }
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            java.util.Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
    
    public CompactDisc(String title, String category, String director, float cost, String artist) {
        setTitle(title);
        setCategory(category);
        setDirector(director);
        setCost(cost);
        this.artist = artist;
        nbMedia += 1;
        this.id = nbMedia;
    }
}