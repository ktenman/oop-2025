package ee.ut.oop.praktikum4;

public class Tanstupaar {
	private String poisiNimi;
	private int poisiSynniAasta;
	private String tydrukuNimi;
	private int tydrukuSynniAasta;
	
	public Tanstupaar(String poisiNimi, int poisiSynniAasta, String tydrukuNimi, int tydrukuSynniAasta) {
		this.poisiNimi = poisiNimi;
		this.poisiSynniAasta = poisiSynniAasta;
		this.tydrukuNimi = tydrukuNimi;
		this.tydrukuSynniAasta = tydrukuSynniAasta;
	}
	
	public String getPoisiNimi() {
		return poisiNimi;
	}
	
	public void setPoisiNimi(String poisiNimi) {
		this.poisiNimi = poisiNimi;
	}
	
	public int getPoisiSynniAasta() {
		return poisiSynniAasta;
	}
	
	public void setPoisiSynniAasta(int poisiSynniAasta) {
		this.poisiSynniAasta = poisiSynniAasta;
	}
	
	public String getTydrukuNimi() {
		return tydrukuNimi;
	}
	
	public void setTydrukuNimi(String tydrukuNimi) {
		this.tydrukuNimi = tydrukuNimi;
	}
	
	public int getTydrukuSynniAasta() {
		return tydrukuSynniAasta;
	}
	
	public void setTydrukuSynniAasta(int tydrukuSynniAasta) {
		this.tydrukuSynniAasta = tydrukuSynniAasta;
	}
	
	public boolean onSyndinudSamalAastal() {
		return poisiSynniAasta == tydrukuSynniAasta;
	}
	
	public int vanemaPartneriVanus(int praeguneAasta) {
		return Math.max(praeguneAasta - poisiSynniAasta, praeguneAasta - tydrukuSynniAasta);
	}
	
	public String pereNimed() {
		return perkonnaNimi(poisiNimi) + " " + perkonnaNimi(tydrukuNimi);
	}
	
	private String perkonnaNimi(String nimi) {
		if (nimi == null) {
			return null;
		}
		if (!nimi.contains(" ")) {
			return nimi;
		}
		String[] s6ned = nimi.split(" ");
		return s6ned[s6ned.length - 1];
	}
	
	@Override
	public String toString() {
		return "Tanstupaar{ " + pereNimed() + " }";
	}
}
