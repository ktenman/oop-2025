package ee.ut.oop.praktikum6;

public abstract class Teos implements Comparable<Teos>{
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

    public double päevaneViivis() {
        return switch (teoseTähis) {
            case "roheline" -> 2;
            case "puudub" -> 0.15;
            case "kollane", "sinine" -> 0.05;
            default -> 0;
        };
    }

    public void arvutaViivis(Kontrollija kontrollija) {
        if (päevadeArv > laenutusAeg()) {
            double viivis = (päevadeArv - laenutusAeg()) * päevaneViivis();
            kontrollija.salvestaViivis(laenutajaNimi, teoseKirjeldus, viivis);
        }
    }

    @Override
    public String toString() {
        return "Teos{" +
                "teoseKirjeldus='" + teoseKirjeldus + '\'' +
                ", teoseTähis='" + teoseTähis + '\'' +
                ", laenutajaNimi='" + laenutajaNimi + '\'' +
                ", päevadeArv=" + päevadeArv + '\'' +
                ", kas tellitud hoidlast? " + (kasHoidlast() ? "jah" : "ei") +
                '}';
    }

    @Override
    public int compareTo(Teos teineTeos) {
        return this.teoseKirjeldus.compareTo(teineTeos.teoseKirjeldus);
    }

    public String getTeoseKirjeldus() {
        return teoseKirjeldus;
    }

    public String getTeoseTähis() {
        return teoseTähis;
    }

    public String getLaenutajaNimi() {
        return laenutajaNimi;
    }

    public int getPäevadeArv() {
        return päevadeArv;
    }
}
