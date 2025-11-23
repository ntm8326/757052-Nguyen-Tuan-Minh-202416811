package hust.soict.dsai.aims.media.Comparator;

public class MediaComparatorByCostTitle implements java.util.Comparator<hust.soict.dsai.aims.media.Media> {
	@Override
    public int compare(hust.soict.dsai.aims.media.Media media1, hust.soict.dsai.aims.media.Media media2) {
        if (media1.getCost() != media2.getCost()) {
            return Float.compare(media1.getCost(), media2.getCost());
        } else {
            return media1.getTitle().compareTo(media2.getTitle());
        }
    }
}
