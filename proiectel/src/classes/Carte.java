package classes;

import classes.Autor;
import classes.Rating;
import classes.Sectiune;
import interfaces.iCarte;

import java.util.ArrayList;
import java.util.List;

public class Carte implements iCarte {
    private int id;
    private String titlu;
    private Autor autor;
    private Sectiune sectiune;
    private Integer nrpag;
    private boolean disponibilitate;
    private List<Rating> ratings = new ArrayList<>();

    @Override
    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratings;
    }

    public Carte(int id, String titlu, Autor autor, Sectiune sectiune, int nrpag, boolean disponibilitate) {
        this.id = id;
        this.titlu = titlu;
        this.autor = autor;
        this.sectiune = sectiune;
        this.nrpag = nrpag;
        this.disponibilitate = disponibilitate;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTitlu() {
        return titlu;
    }

    @Override
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    @Override
    public Autor getAutor() {
        return autor;
    }

    @Override
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public Sectiune getSectiune() {
        return sectiune;
    }

    @Override
    public void setSectiune(Sectiune sectiune) {
        this.sectiune = sectiune;
    }

    @Override
    public int getnrpag() {
        return nrpag;
    }

    @Override
    public void setnrpag(int nrpag) {
        this.nrpag = nrpag;
    }

    @Override
    public boolean isDisponibilitate() {
        return disponibilitate;
    }

    @Override
    public void setDisponibilitate(boolean disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

    @Override
    public String toString() {
        return "classes.Carte{" +
                "id=" + id +
                ", titlu='" + titlu + '\'' +
                ", autor=" + autor +
                ", sectiune=" + sectiune +
                ", nr de pagini=" + nrpag +
                ", disponibilitate=" + disponibilitate +
                '}';
    }
}
