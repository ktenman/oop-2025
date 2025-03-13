package ee.ut.oop.praktikum5;

import java.util.ArrayList;
import java.util.List;

public class Külastaja {
    private List<String> külastuseKirjeldused;
    private int vanus;

    public int getVanus() {
        return vanus;
    }

    public Külastaja(int vanus) {
        this.külastuseKirjeldused = new ArrayList<>();
        this.vanus = vanus;
    }

    public void lisaKirjeldus(String sõne) {
        külastuseKirjeldused.add(sõne);
    }

    public List<String> kõikKirjeldused() {
        return this.külastuseKirjeldused;
    }


}
