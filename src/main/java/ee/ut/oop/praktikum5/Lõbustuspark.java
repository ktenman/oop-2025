package ee.ut.oop.praktikum5;

public class Lõbustuspark {
    Vaateratas lõbustus;

    public Lõbustuspark(Vaateratas lõbustus) {
        this.lõbustus = lõbustus;
    }

    public void alustaSeiklust(Külastaja külastaja) {
        System.out.println("alustan seiklust");
        lõbustus.lõbusta(külastaja);
        külastaja.kõikKirjeldused().forEach(System.out::println);
    }
}
