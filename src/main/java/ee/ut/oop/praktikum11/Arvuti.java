package ee.ut.oop.praktikum11;

import java.time.LocalDateTime;

public class Arvuti {
    private String tootja;
    private boolean kiirtöö;
    private LocalDateTime registreerimisAeg;

    public Arvuti(String tootja, boolean kiirtöö, LocalDateTime registreerimisAeg) {
        this.tootja = tootja;
        this.kiirtöö = kiirtöö;
        this.registreerimisAeg = registreerimisAeg;
    }

    public String getTootja() {
        return tootja;
    }

    public boolean onKiirtöö() {
        return kiirtöö;
    }

    public LocalDateTime getRegistreerimisAeg() {
        return registreerimisAeg;
    }

    public double arvutaArveSumma(double baashind) {
        return baashind;
    }
}
