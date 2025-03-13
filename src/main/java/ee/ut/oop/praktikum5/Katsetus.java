package ee.ut.oop.praktikum5;

public class Katsetus {
    public static void main(String[] args) {
        Vaateratas vaateratas = new Vaateratas();
        Lõbustuspark lõbustuspark = new Lõbustuspark(vaateratas);
        Külastaja külastaja = new Külastaja();
        lõbustuspark.alustaSeiklust(külastaja);
    }
}
