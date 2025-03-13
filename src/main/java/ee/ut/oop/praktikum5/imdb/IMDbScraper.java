package ee.ut.oop.praktikum5.imdb;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * IMDbScraper on klass, mis võimaldab otsida IMDb-st filmi reitingut.
 * Klassi konstruktor võtab argumendiks filmi pealkirja ja otsib sellele vastavat IMDb reitingut.
 */
public class IMDbScraper {
	
	private static final String URL = "https://www.imdb.com";
	private static final String OTSINGU_URL = URL + "/find?q=";
	private String filmiPealkiri;
	private String imdbHinnang;
	
	public IMDbScraper(String filmiPealkiri) {
		this.filmiPealkiri = filmiPealkiri;
		otsiReitingut();
	}
	
	public IMDbScraper() {
	}
	
	public String getImdbHinnang() {
		return imdbHinnang;
	}
	
	public void setFilmiPealkiri(String filmiPealkiri) {
		this.filmiPealkiri = filmiPealkiri;
	}
	
	private String otsiFilmiUrl() {
		try {
			Document document = Jsoup.connect(OTSINGU_URL + filmiPealkiri).get();
			Element element = document.selectFirst("li a");
			if (element == null) {
				throw new RuntimeException("Filmi URL-i ei leitud filmile: " + filmiPealkiri);
			}
			return URL + element.attr("href");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Otsib filmi IMDb reitingut.
	 */
	public void otsiReitingut() {
		if (filmiPealkiri == null || filmiPealkiri.isEmpty()) {
			throw new IllegalArgumentException("Filmi pealkiri ei tohi olla tühi");
		}
		try {
			String otsitudFilmiUrl = otsiFilmiUrl();
			Document document = Jsoup.connect(otsitudFilmiUrl).get();
			Element element = document.selectFirst("[data-testid=\"hero-rating-bar__aggregate-rating__score\"]");
			if (element == null) {
				throw new RuntimeException("IMDb rating ei leitud filmile: " + filmiPealkiri);
			}
			this.imdbHinnang = element.text();
		} catch (IOException e) {
			throw new RuntimeException("IMDb ratingu leidmine ebaõnnestus", e);
		}
	}
	
}
