package ee.ut.oop.praktikum6;

public class SuurimaViiviseLeidja implements Kontrollija {

    private String laenutajaNimi;
    private String teoseKirjeldus;
    private double suurimViivis = 0;

    @Override
    public void salvestaViivis(
            String laenutajaNimi,
            String teoseKirjeldus,
            double viivis
    ) {
        if (viivis > suurimViivis) {
            this.laenutajaNimi = laenutajaNimi;
            this.teoseKirjeldus = teoseKirjeldus;
            suurimViivis = viivis;
        }
    }

    public void saadaHoiatus() {
        System.out.println("Kõige suurema viivisega laenutaja nimi on "
                + laenutajaNimi);
        System.out.println("Tema poolt laenutatud teose kirjeldus os "
                + teoseKirjeldus);
    }
}
