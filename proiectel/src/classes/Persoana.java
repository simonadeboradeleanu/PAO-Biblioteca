package classes;

import interfaces.iPersoana;

public class Persoana implements iPersoana {
    private Integer id;
    private String nume;
    private String prenume;

    public Persoana(Integer id, String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String getNume() {
        return nume;
    }

    @Override
    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String getPrenume() {
        return prenume;
    }

    @Override
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

}
