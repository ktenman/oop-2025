package ee.ut.oop.praktikum5;

import ee.ut.oop.praktikum5.imdb.Lõbustus;

import java.util.Random;

public class Lasketiir implements Lõbustus {

    private final Random random = new Random();

    @Override
    public void lõbusta(Külastaja külastaja) {
//        int genereeritudArv = (int) (Math.random() * 21);
        int genereeritudArv = random.nextInt(21);
        String kirjeldus = "tabasin lasketiirus " + genereeritudArv + " sihtmärki";
        külastaja.lisaKirjeldus(kirjeldus);
    }
}
