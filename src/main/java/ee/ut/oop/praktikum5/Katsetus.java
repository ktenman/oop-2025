package ee.ut.oop.praktikum5;

import ee.ut.oop.praktikum5.imdb.Lõbustus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Katsetus {
    public static void main(String[] args) {
        Vaateratas vaateratas = new Vaateratas();
        Lasketiir lasketiir = new Lasketiir();
        LõbustavKloun lõbustavKloun = new LõbustavKloun(new Kloun("Kristen"));
//        List<Lõbustus> lõbustused = new ArrayList<>();
//        lõbustused.add(vaateratas);
//        lõbustused.add(lasketiir);
//        List<Lõbustus> lõbustused = Arrays.asList(vaateratas, lasketiir);
        List<Lõbustus> lõbustused = List.of(vaateratas, lasketiir, lõbustavKloun);
        Lõbustuspark lõbustuspark = new Lõbustuspark(lõbustused);
        Külastaja külastaja = new Külastaja();
        lõbustuspark.alustaSeiklust(külastaja);
    }
}
