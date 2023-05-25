package classes;

import java.util.List;

public class Sectiune implements interfaces.iSectiune {
    private int id;
    private String nume;

    public Sectiune(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }
    public static Sectiune getSectiuneById(List<Sectiune> sectiuni, int id) {
        for (Sectiune sectiune : sectiuni) {
            if (sectiune.getId() == id) {
                return sectiune;
            }
        }
        return null;
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
    public String getNume() {
        return nume;
    }

    @Override
    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "classes.Sectiune{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                '}';
    }
}
