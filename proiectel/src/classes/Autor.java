package classes;

import java.util.ArrayList;
import java.util.List;

public class Autor extends Persoana implements interfaces.iAutor {
    private Sectiune specializare;
    private List<Rating> ratings = new ArrayList<>();

    public Autor(Integer id, String nume, String prenume, Sectiune specializare) {
        super(id, nume, prenume);
        this.specializare = specializare;
    }

    public static Autor getAutorById(List<Autor> autori, int id) {
        for (Autor autor : autori) {
            if (autor.getId() == id) {
                return autor;
            }
        }
        return null;
    }
    @Override
    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratings;
    }
    @Override
    public Sectiune getSpecializare() {
        return specializare;
    }

    @Override
    public void setSpecializare(Sectiune specializare) {
        this.specializare = specializare;
    }

}
