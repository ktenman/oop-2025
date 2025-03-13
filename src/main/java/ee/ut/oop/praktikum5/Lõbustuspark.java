package ee.ut.oop.praktikum5;

import ee.ut.oop.praktikum5.imdb.Lõbustus;

import java.util.List;

public class Lõbustuspark {
    private List<Lõbustus> lõbustused;

    public Lõbustuspark(List<Lõbustus> lõbustused) {
        this.lõbustused = lõbustused;
    }

    public void alustaSeiklust(Külastaja külastaja) {
        System.out.println("alustan seiklust");
        for (Lõbustus lõbustus : lõbustused) {
            lõbustus.lõbusta(külastaja);
        }
        külastaja.kõikKirjeldused().forEach(System.out::println);
    }
}
