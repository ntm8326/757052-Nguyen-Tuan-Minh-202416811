package aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public String getAllInfo() {
        return "Book - ID: " + this.id + " - " + getTitle() + " - " + getCategory() + " - " + String.join(", ", authors) + ": " + "$" + getCost();
    }
    
    public Book(String title, String category, float cost) {
        super();
        setTitle(title);
        setCategory(category);
        setCost(cost);
        nbMedia += 1;
        this.id = nbMedia;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Author already exists!");
        }
    }

    public void play() {
        System.out.println("Cannot play a book: " + getTitle());
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author not found!");
        }
    }
}
