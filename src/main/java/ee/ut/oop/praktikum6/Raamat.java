package ee.ut.oop.praktikum6;

public class Raamat extends Teos{
    public Raamat(String teoseKirjeldus, String teoseTähis, String laenutajaNimi, int päevadeArv) {
        super(teoseKirjeldus, teoseTähis, laenutajaNimi, päevadeArv);
    }

    @Override
    boolean kasHoidlast() {
        return "kollane".equals(getTeoseTähis()) ||
                "sinine".equals(getTeoseTähis());
    }

    @Override
    public String toString() {
        return "Raamat: " + super.toString();
    }
}
