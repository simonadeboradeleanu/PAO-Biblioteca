package interfaces;

import classes.Sectiune;

import java.util.List;

public interface iSectiune {
    static Sectiune getSectiuneById(List<Sectiune> sectiuni, int id) {
        for (Sectiune sectiune : sectiuni) {
            if (sectiune.getId() == id) {
                return sectiune;
            }
        }
        return null;
    }

    int getId();

    void setId(int id);

    String getNume();

    void setNume(String nume);

    @Override
    String toString();
}
