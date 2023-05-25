package classes;

import interfaces.iCititor;

import java.util.Date;

public class Cititor extends Persoana implements iCititor {


    private String telefon;
    private Date dataInregistrare;

    public Cititor(Integer id, String nume, String prenume, String telefon, Date dataInregistrare) {
        super(id, nume, prenume);
        this.telefon = telefon;
        this.dataInregistrare = new Date();
    }
    @Override
    public String getTelefon() {
        return telefon;
    }

    @Override
    public Date getDataInregistrare() {
        return this.dataInregistrare;
    }

}
