package test.media;
import aims.media.Media;
import aims.media.Track;
import aims.media.DigitalVideoDisc;
import aims.media.Book;
import aims.media.CompactDisc;
import java.util.ArrayList;
import java.util.List;

public class TestPolymorphism {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<Media>();
        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Various Artists", 15.99f, "Taylor Swift");
        DigitalVideoDisc dvd = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 19.99f);
        Book book = new Book("The Great Gatsby", "Fiction", 10.99f);
        book.addAuthor("F. Scott Fitzgerald");
        book.addAuthor("Ernest Hemingway");
        Track track1 = new Track("Track 1", 4);
        Track track2 = new Track("Track 2", 5);
        cd.addTrack(track1);
        cd.addTrack(track2);
        mediaList.add(cd);
        mediaList.add(dvd);
        mediaList.add(book);

        for (Media m : mediaList) {
            System.out.println(m.toString());
        }
    }
}
