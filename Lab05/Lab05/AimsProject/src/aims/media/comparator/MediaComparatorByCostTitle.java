package aims.media.comparator;

public class MediaComparatorByCostTitle implements java.util.Comparator<aims.media.Media> {
    @Override
    public int compare(aims.media.Media media1, aims.media.Media media2) {
        if (media1.getCost() != media2.getCost()) {
            return Float.compare(media1.getCost(), media2.getCost());
        } else {
            return media1.getTitle().compareTo(media2.getTitle());
        }
    }
    
}
