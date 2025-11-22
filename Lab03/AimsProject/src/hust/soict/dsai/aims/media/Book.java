package hust.soict.dsai.aims.media;
import java.lang.Object;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media {
	private static int id;
	private List<String> authors = new ArrayList<String>();
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public Book(int Id, String title, String category, float cost) {
		super();
		setId(Id);
		setTitle(title);
		setCategory(category);
		setCost(cost);
	}
	public void addAuthor(String author) {
		boolean exist = false;
		for(String name : authors) {
			if (name.equals(author)) {
				exist = true;
				break;
			}
		}
		if(exist) {
			System.out.println("The author's name is already existed!");
		}
		else {
			authors.add(author);
		}
	}
	public void removeAuthor(String author) {
		if( authors.size() == 0){
			System.out.println("The author list has had no name yet");
		}
		else {
			boolean found = false;
			for(String name : authors) {
				if (name.equals(author)) {
					authors.remove(author);
					found = true;
					break;
				}
			}
			if(!found) {
				System.out.println("Author's name has not been in the list yet!");
			}
		}
	}
	@Override 
	public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - " + String.join(",", authors) +  ": " + getCost() + " $";
        }
}
