package interfaces;

import java.util.List;
import classes.*;

public interface iCarte {
    static Carte getCarteById(List<Carte> autori, int id) {
        for (Carte autor : autori) {
            if (autor.getId() == id) {
                return autor;
            }
        }
        return null;
    }

    void addRating(Rating rating);

    List<Rating> getRatings();

    int getId();

    void setId(int id);

    String getTitlu();

    void setTitlu(String titlu);

    Autor getAutor();

    void setAutor(Autor autor);

    Sectiune getSectiune();

    void setSectiune(Sectiune sectiune);

    int getnrpag();

    void setnrpag(int nrpag);

    boolean isDisponibilitate();

    void setDisponibilitate(boolean disponibilitate);

    @Override
    String toString();
}
