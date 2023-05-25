package classes;

public class Bibliotecar extends Persoana implements interfaces.iBibliotecar {
    private double salariu;

    public Bibliotecar(Integer id, String nume, String prenume, double salariu) {
        super(id, nume, prenume);
        this.salariu = salariu;
    }

    @Override
    public double getSalariu() {
        return salariu;
    }

    @Override
    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }
}
