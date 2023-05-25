package classes;

public class Rating implements interfaces.iRating {
    private double nota;
    private String mesaj;

    public Rating(double nota, String mesaj) {
        this.nota = nota;
        this.mesaj = mesaj;
    }

    @Override
    public double getNota() {
        return nota;
    }

    @Override
    public void setNota(int nota) throws Exception {
        if (nota < 0 || nota > 5) {
            throw new Exception("Ratingul trebuie sa fie intre 0 si 5");
        }
        this.nota = nota;
    }

    @Override
    public String getMesaj() {
        return mesaj;
    }

    @Override
    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }
}
