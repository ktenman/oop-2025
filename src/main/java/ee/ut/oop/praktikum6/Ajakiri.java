package ee.ut.oop.praktikum6;

public class Ajakiri extends Teos {
    public Ajakiri(String teoseKirjeldus, String teoseTähis, String laenutajaNimi, int päevadeArv) {
        super(teoseKirjeldus, teoseTähis, laenutajaNimi, päevadeArv);
    }

    @Override
    boolean kasHoidlast() {
        // Kodu ja aed/2013,10
        // [Kodu ja aed] [2013,10]
        // [2013] [10]
        String aasta = getTeoseKirjeldus().split("/")[1].split(",")[0];
        return Integer.parseInt(aasta) <= 2000;
    }

    @Override
    public String toString() {
        return "Ajakiri: " + super.toString();
    }
}
