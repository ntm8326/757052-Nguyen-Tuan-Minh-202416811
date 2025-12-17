package aims.media;

import aims.exceptions.PlayerException;

public class DigitalVideoDisc extends Disc implements Play {

    @Override
    public String getAllInfo() {
        return "DVD - ID: " + this.id + " - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + "mins : " + "$" + getCost();
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
    }
}

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        setTitle(title);
        setCategory(category);
        setDirector(director);
        setLength(length);
        setCost(cost);
        nbMedia += 1;
        this.id = nbMedia;
    }

}