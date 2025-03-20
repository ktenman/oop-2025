package ee.ut.oop.praktikum6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ViiviseHoiataja implements Kontrollija {
    private double lubatudViivis;
    private Set<String> hoiatavadLaenutajad = new HashSet<>();

    public ViiviseHoiataja(double lubatudViivis) {
        this.lubatudViivis = lubatudViivis;
    }

    @Override
    public void salvestaViivis(String laenutajaNimi, String teoseKirjeldus, double viivis) {
        if (viivis > lubatudViivis) {
            hoiatavadLaenutajad.add(laenutajaNimi);
        }
    }

    public List<String> getHoiatavadLaenutajad() {
        return new ArrayList<>(hoiatavadLaenutajad);
    }
}
