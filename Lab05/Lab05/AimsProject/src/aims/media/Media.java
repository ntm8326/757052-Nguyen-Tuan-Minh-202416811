package aims.media;
import java.util.Comparator;
import aims.media.comparator.MediaComparatorByTitleCost;
import aims.exceptions.PlayerException;
import aims.media.comparator.MediaComparatorByCostTitle;

public abstract class Media {

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public static int nbMedia = 0;

    public int id;

    private String title;

    private String category;

    private float cost;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public abstract String getAllInfo();

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public abstract void play() throws PlayerException;
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (!(obj instanceof Media)) {
            return false;
        }

        Media otherMedia = (Media) obj;
        try {
            if (this.getTitle().equals(otherMedia.getTitle())) {
                return true;
            }
        } catch (NullPointerException e) {
            return false;
        }
        
        return false;
    }
}
