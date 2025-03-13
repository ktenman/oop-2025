package ee.ut.oop.praktikum5;

import java.util.ArrayList;
import java.util.List;

public class Külastaja {
    private List<String> külastuseKirjeldused;

    public Külastaja() {
        this.külastuseKirjeldused = new ArrayList<>();
    }

    public void lisaKirjeldus(String sõne) {
        külastuseKirjeldused.add(sõne);
    }

    public List<String> kõikKirjeldused() {
        return this.külastuseKirjeldused;
    }


}
