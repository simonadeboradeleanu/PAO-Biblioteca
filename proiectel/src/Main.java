
import classes.*;
import interfaces.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Service unu = Service.getInstance();
        //initializare valori
        unu.initSect();
        unu.initAut();
        unu.initCarti();
        unu.initCit();
        unu.initBibl();
        unu.initImp();
        unu.initRating();

        System.out.println();
        System.out.println();
        System.out.println("       Cele 10 metode ");
        System.out.println();

        //Căutarea tuturor autorilor care au publicat cărți într-o anumită sectiune.
        unu.cautareAutoriDinSectiune(unu.carti, Sectiune.getSectiuneById(unu.sectiuni, 1)); //beletristica
        System.out.println();

        //adauga rating ptr autor sau carte -> depinde de parametru
        unu.addRating(Objects.requireNonNull(Autor.getAutorById(unu.autori, 3)), 5, "Lucian Blaga este autorul meu preferat");
        System.out.println();

        //returneaza un map cu cititorii ce au luat cartea in trecut si nr lor de telefon
        unu.istoricCarte(iCarte.getCarteById(unu.carti, 2));
        System.out.println();

        //calc media ratingurilor ptr autor sau carte -> depinde de parametru
        unu.mediaRating(iCarte.getCarteById(unu.carti, 2));
        System.out.println();

        //iau primele x cele mai apreciate carti
        unu.getTopRatedBooks(3);
        System.out.println();

        unu.searchBooksByTitle("lu");
        System.out.println();

        unu.hasAuthorBooksWithHigherRating(Autor.getAutorById(unu.autori, 3), 3);
        System.out.println();

        unu.sortBooksByRating();
        System.out.println();

        unu.getMostPopularAuthor();
        System.out.println();

        unu.getReaderWithLongestDelay();
        System.out.println();

        AuditService.inchideAudit();



    }
}
