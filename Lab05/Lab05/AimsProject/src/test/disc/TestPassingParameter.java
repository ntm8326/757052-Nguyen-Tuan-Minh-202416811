package test.disc;
import aims.media.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {

        DigitalVideoDisc d1 = new DigitalVideoDisc("Jungle Book", "Animation", "Jon Favreau", 105, 20.0f);
        DigitalVideoDisc d2 = new DigitalVideoDisc("Cinderella", "Animation", "Kenneth Branagh", 112, 18.0f);

        swap(d1, d2);
        System.out.println("jg title: " + d1.getTitle());
        System.out.println("cn title: " + d2.getTitle());

        changeTitle(d1, d2.getTitle());
        System.out.println("jg title: " + d1.getTitle());
        System.out.println("cn title: " + d2.getTitle());

    }

    public static void swap(DigitalVideoDisc d1, DigitalVideoDisc d2) {
        DigitalVideoDisc temp = d1;
        d1 = d2;
        d2 = temp;
    }
    public static void changeTitle(DigitalVideoDisc d, String title) {
        String oldTitle = d.getTitle();
        d.setTitle(title);
        d = new DigitalVideoDisc(oldTitle, "Animation", "Some Director", 100, 15.0f);
    }
}
