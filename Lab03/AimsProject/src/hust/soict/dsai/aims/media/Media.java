package hust.soict.dsai.aims.media;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Comparator.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.media.Comparator.MediaComparatorByTitleCost;

public abstract class Media {
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByCostTitle();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByTitleCost();
	private int id;
	private String title;
	private String category;
	private float cost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public abstract String toString();
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Media) {
			Media other = (Media) obj;
	        return this.title == other.title;
	    }
		return false;
	}
	
}
