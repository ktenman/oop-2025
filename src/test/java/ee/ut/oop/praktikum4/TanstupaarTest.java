package ee.ut.oop.praktikum4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TanstupaarTest {
	
	@Test
	void pereNimed() {
		Tanstupaar tanstupaar = new Tanstupaar("Nils Jaagup Kask", 2001, "Ann-Marleen Tamm", 1995);
		
		assertThat(tanstupaar.pereNimed()).isEqualTo("Kask Tamm");
		assertThat(tanstupaar.vanemaPartneriVanus(2024)).isEqualTo(29);
	}
}
