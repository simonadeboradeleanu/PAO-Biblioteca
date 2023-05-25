package interfaces;

import classes.Bibliotecar;
import classes.Carte;
import classes.Cititor;

import java.time.LocalDate;

public interface iImprumut {
    Cititor getCititor();

    void setCititor(Cititor cititor);

    void setCititor(iCititor iCititor);


    iCarte getCarte();

    void setCarte(Carte carte);

    void setCarte(iCarte iCarte);

    LocalDate getDataImprumut();

    void setDataImprumut(LocalDate dataImprumut);

    LocalDate getExpectedDataRestituire();

    void setExpectedDataRestituire(LocalDate expectedDataRestituire);

    LocalDate getActualDataRestituire();

    void setActualDataRestituire(LocalDate actualDataRestituire);

    iBibliotecar getBibliotecar();

    void setBibliotecar(Bibliotecar bibliotecar);

    void setBibliotecar(iBibliotecar iBibliotecar);
}
