package ee.ut.oop.praktikum5;

import ee.ut.oop.praktikum5.imdb.Lõbustus;

public class LõbustavKloun implements Lõbustus {
    private Kloun kloun;

    public LõbustavKloun(Kloun kloun) {
        this.kloun = kloun;
    }

    @Override
    public void lõbusta(Külastaja külastaja) {
        kloun.esine(külastaja);
    }
}
