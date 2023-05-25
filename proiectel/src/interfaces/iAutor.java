package interfaces;

import classes.Autor;
import classes.Rating;
import classes.Sectiune;

import java.util.List;

public interface iAutor extends iPersoana {
    static Autor getAutorById(List<Autor> autori, int id) {
        for (Autor autor : autori) {
            if (autor.getId() == id) {
                return autor;
            }
        }
        return null;
    }

    @Override
    default Integer getId() {
        return null;
    }

    @Override
    default void setId(Integer id) {

    }

    @Override
    default String getNume() {
        return null;
    }

    @Override
    default void setNume(String nume) {

    }

    @Override
    default String getPrenume() {
        return null;
    }

    @Override
    default void setPrenume(String prenume) {

    }

    void addRating(Rating rating);

    List<Rating> getRatings();

    Sectiune getSpecializare();

    void setSpecializare(Sectiune specializare);
}
