package aims.media;

import aims.exceptions.PlayerException;

public class Track implements Play {
    private String title;

    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track other = (Track) obj;
            return this.title == other.title && this.length == other.length;
        }
        return false;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
}
