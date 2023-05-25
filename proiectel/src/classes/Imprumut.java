package classes;
import interfaces.*;
import java.time.LocalDate;


public class Imprumut {
    private Cititor cititor;
    private Carte carte;
    private LocalDate dataImprumut;
    private LocalDate expectedDataRestituire;
    private LocalDate actualDataRestituire = null;
    private Bibliotecar bibliotecar;

    public Imprumut(Cititor cititor, Carte carte, LocalDate dataImprumut, LocalDate expectedDataRestituire, LocalDate actualDataRestituire, Bibliotecar bibliotecar) {
        this.cititor = cititor;
        this.carte = carte;
        this.dataImprumut = dataImprumut;
        this.expectedDataRestituire = expectedDataRestituire;
        this.actualDataRestituire = actualDataRestituire;
        this.bibliotecar = bibliotecar;
    }

    public Cititor getCititor() {
        return cititor;
    }

    public void setCititor(Cititor cititor) {
        this.cititor = cititor;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public LocalDate getDataImprumut() {
        return dataImprumut;
    }

    public void setDataImprumut(LocalDate dataImprumut) {
        this.dataImprumut = dataImprumut;
    }

    public LocalDate getExpectedDataRestituire() {
        return expectedDataRestituire;
    }

    public void setExpectedDataRestituire(LocalDate expectedDataRestituire) {
        this.expectedDataRestituire = expectedDataRestituire;
    }

    public LocalDate getActualDataRestituire() {
        return actualDataRestituire;
    }

    public void setActualDataRestituire(LocalDate actualDataRestituire) {
        this.actualDataRestituire = actualDataRestituire;
    }

    public Bibliotecar getBibliotecar() {
        return bibliotecar;
    }

    public void setBibliotecar(Bibliotecar bibliotecar) {
        this.bibliotecar = bibliotecar;
    }
}
