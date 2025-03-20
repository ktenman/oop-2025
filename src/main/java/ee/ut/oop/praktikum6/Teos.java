package ee.ut.oop.praktikum6;

public abstract class Teos {
    private String teoseKirjeldus;
    private String teoseTähis;
    private String laenutajaNimi;
    private int päevadeArv;

    abstract boolean kasHoidlast();

    public Teos(String teoseKirjeldus,
                String teoseTähis,
                String laenutajaNimi,
                int päevadeArv
    ) {
        this.teoseKirjeldus = teoseKirjeldus;
        this.teoseTähis = teoseTähis;
        this.laenutajaNimi = laenutajaNimi;
        this.päevadeArv = päevadeArv;
    }

    public int laenutusAeg() {
        return switch (teoseTähis) {
            case "roheline" -> 1;
            case "puudub" -> 14;
            case "kollane" -> 30;
            case "sinine" -> 60;
            default -> 0;
        };
    }
}
