package ee.ut.oop.praktikum5.imdb;

import java.util.Random;
import java.util.Scanner;

public class Peaklass {
	
	private static final String[] FILMI_PEALKIRJAD = {"The Shawshank Redemption", "The Godfather", "The Dark Knight", "Pulp Fiction", "Fight Club"};
	private static final Random RANDOM = new Random();
	
	/**
	 * Main meetod, mis küsib kasutajalt, kas soovitakse sisestada filmi pealkiri käsitsi või saada juhusliku filmi IMDb hinnang.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Kas soovite sisestada filmi pealkirja käsitsi (k) või saada juhusliku (j)? Kirjutage 'exit', et lõpetada");
			String sisend = scanner.nextLine();
			if ("exit".equals(sisend)) {
				break;
			} else if (sisend.equalsIgnoreCase("k")) {
				System.out.println("Sisestage filmi pealkiri:");
				String sisestatudFilmiPealkiri = scanner.nextLine();
				IMDbScraper scraper = new IMDbScraper(sisestatudFilmiPealkiri);
				System.out.println(sisestatudFilmiPealkiri + " IMDb hinnang: " + scraper.getImdbHinnang());
			} else if (sisend.equalsIgnoreCase("j")) {
				String suvalineFilm = FILMI_PEALKIRJAD[RANDOM.nextInt(FILMI_PEALKIRJAD.length)];
				IMDbScraper scraper = new IMDbScraper();
				scraper.setFilmiPealkiri(suvalineFilm);
				scraper.otsiReitingut();
				System.out.println("Juhuslikult valitud film: " + suvalineFilm);
				System.out.println("IMDb hinnang: " + scraper.getImdbHinnang());
			} else {
				System.out.println("Vigane sisend. Palun sisestage 'k', 'j' või 'exit'");
			}
		}
		scanner.close();
	}
}
