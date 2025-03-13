package ee.ut.oop.praktikum5;

import ee.ut.oop.praktikum5.imdb.Lõbustus;

public class Vaateratas implements Lõbustus {

    @Override
    public void lõbusta(Külastaja külastaja) {
        külastaja.lisaKirjeldus("külastasin vaateratast");
    }
}
