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
        VanuseKontrollija vanuseKontrollija = new VanuseKontrollija(15, lasketiir);
//        List<Lõbustus> lõbustused = new ArrayList<>();
//        lõbustused.add(vaateratas);
//        lõbustused.add(lasketiir);
//        List<Lõbustus> lõbustused = Arrays.asList(vaateratas, lasketiir);
        List<Lõbustus> lõbustused = List.of(vaateratas, lõbustavKloun, vanuseKontrollija);
        Lõbustuspark lõbustuspark = new Lõbustuspark(lõbustused);
        Külastaja külastaja = new Külastaja(16);
        lõbustuspark.alustaSeiklust(külastaja);

        Külastaja külastaja2 = new Külastaja(14);

        lõbustuspark.alustaSeiklust(külastaja2);
    }
}
