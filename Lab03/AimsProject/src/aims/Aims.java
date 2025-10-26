package aims;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class Aims {
	public static void showAvailableDiscs(Map<String, DigitalVideoDisc> dvdMap) {
	    System.out.println("Available DVDs:");
	    for (Map.Entry<String, DigitalVideoDisc> entry : dvdMap.entrySet()) {
	        System.out.println(entry.getKey() + " - " + entry.getValue().getTitle());
	    }
	}
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 24.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 18.50f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 21.99f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 17.99f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Avatar", "Sci-Fi", "James Cameron", 162, 22.99f);
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Gladiator", "Action", "Ridley Scott", 155, 20.00f);
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "Lana Wachowski", 136, 19.50f);
		DigitalVideoDisc dvd11 = new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 23.99f);
		DigitalVideoDisc dvd12 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 18.75f);
		DigitalVideoDisc dvd13 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 19.99f);
		DigitalVideoDisc dvd14 = new DigitalVideoDisc("Avengers: Endgame", "Action", "Anthony Russo", 181, 25.99f);
		DigitalVideoDisc dvd15 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 14.99f);
		DigitalVideoDisc dvd16 = new DigitalVideoDisc("Finding Nemo", "Animation", "Andrew Stanton", 100, 15.99f);
		DigitalVideoDisc dvd17 = new DigitalVideoDisc("Coco", "Animation", "Lee Unkrich", 105, 16.99f);
		DigitalVideoDisc dvd18 = new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 17.50f);
		DigitalVideoDisc dvd19 = new DigitalVideoDisc("Joker", "Drama", "Todd Phillips", 122, 20.99f);
		DigitalVideoDisc dvd20 = new DigitalVideoDisc("Parasite", "Thriller", "Bong Joon-ho", 132, 21.50f);
		DigitalVideoDisc dvd21 = new DigitalVideoDisc("La La Land", "Musical", "Damien Chazelle", 128, 18.99f);
		Map<String, DigitalVideoDisc> dvdMap = new HashMap<>();
		dvdMap.put("dvd1", dvd1);
		dvdMap.put("dvd2", dvd2);
		dvdMap.put("dvd3", dvd3);
		dvdMap.put("dvd4", dvd4);
		dvdMap.put("dvd5", dvd5);
		dvdMap.put("dvd6", dvd6);
		dvdMap.put("dvd7", dvd7);
		dvdMap.put("dvd8", dvd8);
		dvdMap.put("dvd9", dvd9);
		dvdMap.put("dvd10", dvd10);
		dvdMap.put("dvd11", dvd11);
		dvdMap.put("dvd12", dvd12);
		dvdMap.put("dvd13", dvd13);
		dvdMap.put("dvd14", dvd14);
		dvdMap.put("dvd15", dvd15);
		dvdMap.put("dvd16", dvd16);
		dvdMap.put("dvd17", dvd17);
		dvdMap.put("dvd18", dvd18);
		dvdMap.put("dvd19", dvd19);
		dvdMap.put("dvd20", dvd20);
		dvdMap.put("dvd21", dvd21);
		System.out.println("Please choose an option.");
		System.out.println("1 for ADD DISC");
		System.out.println("2 for REMOVE DISC");
		System.out.println("3 for TOTAL COST");
		System.out.println("4 for EXIT");
		Scanner sc = new Scanner(System.in);
	    int n;
		do {
			System.out.println("Please choose your option.");
			n = sc.nextInt();
			switch(n) {
			case 1:
				boolean hasDisc = false;
				sc.nextLine();
				showAvailableDiscs(dvdMap);
				do {
					System.out.println("Please choose dvd");
					String dvd = sc.nextLine().trim().toLowerCase();
					switch (dvd) {
					case "dvd1":
						anOrder.addDigitalVideoDisc(dvd1);
						hasDisc = true;
						break;
					case "dvd2":
						anOrder.addDigitalVideoDisc(dvd2);
						hasDisc = true;
						break;
					case "dvd3":
						anOrder.addDigitalVideoDisc(dvd3);
						hasDisc = true;
						break;
					case "dvd4":
						anOrder.addDigitalVideoDisc(dvd4);
						hasDisc = true;
						break;
					case "dvd5":
						anOrder.addDigitalVideoDisc(dvd5);
						hasDisc = true;
						break;
					case "dvd6":
						anOrder.addDigitalVideoDisc(dvd6);
						hasDisc = true;
						break;
					case "dvd7":
						anOrder.addDigitalVideoDisc(dvd7);
						hasDisc = true;
						break;
					case "dvd8":
						anOrder.addDigitalVideoDisc(dvd8);
						hasDisc = true;
						break;
					case "dvd9":
						anOrder.addDigitalVideoDisc(dvd9);
						hasDisc = true;
						break;
					case "dvd10":
						anOrder.addDigitalVideoDisc(dvd10);
						hasDisc = true;
						break;
					case "dvd11":
						anOrder.addDigitalVideoDisc(dvd11);
						hasDisc = true;
						break;
					case "dvd12":
						anOrder.addDigitalVideoDisc(dvd12);
						hasDisc = true;
						break;
					case "dvd13":
						anOrder.addDigitalVideoDisc(dvd13);
						hasDisc = true;
						break;
					case "dvd14":
						anOrder.addDigitalVideoDisc(dvd14);
						hasDisc = true;
						break;
					case "dvd15":
						anOrder.addDigitalVideoDisc(dvd15);
						hasDisc = true;
						break;
					case "dvd16":
						anOrder.addDigitalVideoDisc(dvd16);
						hasDisc = true;
						break;
					case "dvd17":
						anOrder.addDigitalVideoDisc(dvd17);
						hasDisc = true;
						break;
					case "dvd18":
						anOrder.addDigitalVideoDisc(dvd18);
						hasDisc = true;
						break;
					case "dvd19":
						anOrder.addDigitalVideoDisc(dvd19);
						hasDisc = true;
						break;
					case "dvd20":
						anOrder.addDigitalVideoDisc(dvd20);
						hasDisc = true;
						break;
					case "dvd21":
						anOrder.addDigitalVideoDisc(dvd21);
						hasDisc = true;
						break;
					default:
						System.out.println("Sorry, we don't have that disc, please choose again!");
						break;
						}
				}
				while(!hasDisc);
				break;
			case 2:
				sc.nextLine();
				System.out.println("Please choose dvd");
				String dvd = sc.nextLine().trim().toLowerCase();
				switch (dvd) {
				case "dvd1":
					anOrder.removeDigitalVideoDisc(dvd1);
					break;
				case "dvd2":
					anOrder.removeDigitalVideoDisc(dvd2);
					break;
				case "dvd3":
					anOrder.removeDigitalVideoDisc(dvd3);
					break;
				case "dvd4":
					anOrder.removeDigitalVideoDisc(dvd4);
					break;
				case "dvd5":
					anOrder.removeDigitalVideoDisc(dvd5);
					break;
				case "dvd6":
					anOrder.removeDigitalVideoDisc(dvd6);
					break;
				case "dvd7":
					anOrder.removeDigitalVideoDisc(dvd7);
					break;
				case "dvd8":
					anOrder.removeDigitalVideoDisc(dvd8);
					break;
				case "dvd9":
					anOrder.removeDigitalVideoDisc(dvd9);
					break;
				case "dvd10":
					anOrder.removeDigitalVideoDisc(dvd10);
					break;
				case "dvd11":
					anOrder.removeDigitalVideoDisc(dvd11);
					break;
				case "dvd12":
					anOrder.removeDigitalVideoDisc(dvd12);
					break;
				case "dvd13":
					anOrder.removeDigitalVideoDisc(dvd13);
					break;
				case "dvd14":
					anOrder.removeDigitalVideoDisc(dvd14);
					break;
				case "dvd15":
					anOrder.removeDigitalVideoDisc(dvd15);
					break;
				case "dvd16":
					anOrder.removeDigitalVideoDisc(dvd16);
					break;
				case "dvd17":
					anOrder.removeDigitalVideoDisc(dvd17);
					break;
				case "dvd18":
					anOrder.removeDigitalVideoDisc(dvd18);
					break;
				case "dvd19":
					anOrder.removeDigitalVideoDisc(dvd19);
					break;
				case "dvd20":
					anOrder.removeDigitalVideoDisc(dvd20);
					break;
				case "dvd21":
					anOrder.removeDigitalVideoDisc(dvd21);
					break;
					}
				break;
			case 3:
				System.out.println("Total Cost is: ");
		        System.out.println(anOrder.totalCost());
		        break;
			case 4:
				break;
			default:
				System.out.println("Please choose 1 of 4 given option!");
				break;
			}
		}		
		while(n != 4);
	}
}
