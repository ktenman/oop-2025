package ee.ut.oop.praktikum5;

import com.codeborne.selenide.Configuration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class KVScraperTest {
	
	KVScraper kvScraper = new KVScraper("Tallinn");
	
	@Test
	void name() {
		
		
		for (int i = 0; i < 100; i++) {
			int köögiSulgemisaeg = (int) (19 + Math.random() * 21);
			
			System.out.println(köögiSulgemisaeg);
		}
	}
	
	@Test
	void arvutaKeskmineHind() {
		Configuration.headless = true;
		Configuration.browser = "firefox";
		
		Assertions.assertThat(kvScraper.arvutaKeskmineHind())
				.isGreaterThan(200_000)
				.isLessThan(400_000);
	}
	
	@Test
	void hind() {
		Assertions.assertThat(kvScraper.hind("125 000 €\n4 562 €/m²\nKuumakse 610 €")).isEqualTo(125_000);
	}
	
}
