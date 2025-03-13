package ee.ut.oop.praktikum5.imdb;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class IMDbScraperTest {
	
	@Test
	void getImdbRating() {
		IMDbScraper scraper = new IMDbScraper("The Shawshank Redemption");
		
		Assertions.assertThat(scraper.getImdbHinnang()).isEqualTo("9.3/10");
	}
}
