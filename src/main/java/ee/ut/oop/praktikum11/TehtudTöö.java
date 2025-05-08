package ee.ut.oop.praktikum11;

public class TehtudTöö {
    private Arvuti arvuti;
    private double hind;

    public TehtudTöö(Arvuti arvuti, double hind) {
        this.arvuti = arvuti;
        this.hind = hind;
    }

    public Arvuti getArvuti() {
        return arvuti;
    }

    public void setArvuti(Arvuti arvuti) {
        this.arvuti = arvuti;
    }

    public double getHind() {
        return hind;
    }

    public void setHind(double hind) {
        this.hind = hind;
    }
}