package ee.ut.oop.praktikum4;

public class Taara {
	private String joogiNimi;
	private char pakendiT2his;
	
	public Taara(String joogiNimi, char pakendiT2his) {
		this.joogiNimi = joogiNimi;
		this.pakendiT2his = pakendiT2his;
	}
	
	public String getJoogiNimi() {
		return joogiNimi;
	}
	
	public void setJoogiNimi(String joogiNimi) {
		this.joogiNimi = joogiNimi;
	}
	
	public char getPakendiT2his() {
		return pakendiT2his;
	}
	
	public void setPakendiT2his(char pakendiT2his) {
		this.pakendiT2his = pakendiT2his;
	}
}
