package ee.ut.oop.praktikum5;

import ee.ut.oop.praktikum5.imdb.Lõbustus;

public class VanuseKontrollija implements Lõbustus {

    private int nõutudVanus;
    private Lõbustus delegaat;

    public VanuseKontrollija(int nõutudVanus, Lõbustus delegaat) {
        this.nõutudVanus = nõutudVanus;
        this.delegaat = delegaat;
    }

    @Override
    public void lõbusta(Külastaja külastaja) {
        if (külastaja.getVanus() >= this.nõutudVanus) {
            delegaat.lõbusta(külastaja);
        } else {
            külastaja.lisaKirjeldus("külastaja ei läbinud vanusekontrolli");
        }
    }
}
