import java.time.LocalDate;
import java.util.*;
import classes.*;
import interfaces.*;

public class ServiceInitializare {
    public List<Autor> autori = new ArrayList<>();
    List<Sectiune> sectiuni = new ArrayList<>();
    public List<Carte> getCarti() {
        return carti;
    }
    public List<Carte> carti = new ArrayList<>();

    List<Cititor> cititori = new ArrayList<>();
    List<Bibliotecar> bibliotecari = new ArrayList<>();
    List<Imprumut> imprumuturi = new ArrayList<>();



    public void initSect() {
        sectiuni.add(new Sectiune(1, "Beletristica"));
        sectiuni.add(new Sectiune(2, "Stiinte"));
        sectiuni.add(new Sectiune(3, "Filosofie"));
        sectiuni.add(new Sectiune(4, "Istorie"));
        sectiuni.add(new Sectiune(5, "Matematica"));
    }
    public void initAut() {
        autori.add(new Autor(1, "Creanga", "Ion", Sectiune.getSectiuneById(sectiuni, 1)));
        autori.add(new Autor(2, "Eminescu", "Mihai", Sectiune.getSectiuneById(sectiuni, 1)));
        autori.add(new Autor(3, "Blaga", "Lucian", Sectiune.getSectiuneById(sectiuni, 3)));
        autori.add(new Autor(4, "Barbu", "Ion", Sectiune.getSectiuneById(sectiuni, 5)));
        autori.add(new Autor(5, "Eliade", "Mircea", Sectiune.getSectiuneById(sectiuni, 4)));
        autori.add(new Autor(6, "Preda", "Marin", Sectiune.getSectiuneById(sectiuni, 1)));
        autori.add(new Autor(7, "Ionesco", "Eugene", Sectiune.getSectiuneById(sectiuni, 1)));
        autori.add(new Autor(8, "Cioran", "Emil", Sectiune.getSectiuneById(sectiuni, 3)));
    }
    public void initCarti() {
        carti.add(new Carte(1, "Amintiri din copilarie", Autor.getAutorById(autori, 1), Sectiune.getSectiuneById(sectiuni, 1), 300, true));
        carti.add(new Carte(2, "Luceafarul", Autor.getAutorById(autori, 2), Sectiune.getSectiuneById(sectiuni, 1), 150, true));
        carti.add(new Carte(3, "Poemele luminii", Autor.getAutorById(autori, 3), Sectiune.getSectiuneById(sectiuni, 3), 250, true));
        carti.add(new Carte(4, "Ghita", Autor.getAutorById(autori, 5), Sectiune.getSectiuneById(sectiuni, 4), 400, true));
        carti.add(new Carte(5, "Caligula", Autor.getAutorById(autori, 6), Sectiune.getSectiuneById(sectiuni, 1), 200, true));
        carti.add(new Carte(6, "Schițe", Autor.getAutorById(autori, 1), Sectiune.getSectiuneById(sectiuni, 1), 120, true));
    }
    public void initCit() {
        cititori.add(new Cititor(1, "Popescu", "Ana", "0712345678", new Date()));
        cititori.add(new Cititor(2, "Ionescu", "Mihai", "0723456789", new Date()));
        cititori.add(new Cititor(3, "Popa", "Andrei", "0734567890", new Date()));
        cititori.add(new Cititor(4, "Dumitru", "Maria", "0745678901", new Date()));
        cititori.add(new Cititor(5, "Stan", "Alexandru", "0756789012", new Date()));
        cititori.add(new Cititor(6, "Gheorghe", "Elena", "0767890123", new Date()));
        cititori.add(new Cititor(7, "Florescu", "George", "0778901234", new Date()));
    }
    public void initBibl(){
        bibliotecari.add(new Bibliotecar(1, "Popescu", "Ion", 3000));
        bibliotecari.add(new Bibliotecar(2, "Ionescu", "Maria", 2500.5));
        bibliotecari.add(new Bibliotecar(3, "Popa", "Alex", 2800.0));
        bibliotecari.add(new Bibliotecar(4, "Georgescu", "Mihai", 3200.0));
        bibliotecari.add(new Bibliotecar(5, "Dumitru", "Andrei", 2900.75));


    }
    public void initImp(){
        imprumuturi.add(new Imprumut(cititori.get(0), carti.get(0), LocalDate.of(2022, 3, 8), LocalDate.of(2022, 4, 8), LocalDate.of(2022, 4, 5), bibliotecari.get(0)));
        imprumuturi.add(new Imprumut(cititori.get(1), carti.get(1), LocalDate.of(2022, 2, 28), LocalDate.of(2022, 3, 28), null, bibliotecari.get(1)));
        imprumuturi.add(new Imprumut(cititori.get(2), carti.get(2), LocalDate.of(2022, 1, 1), LocalDate.of(2022, 2, 1), LocalDate.of(2022, 1, 15), bibliotecari.get(2)));
        imprumuturi.add(new Imprumut(cititori.get(3), carti.get(3), LocalDate.of(2022, 2, 14), LocalDate.of(2022, 3, 14), null, bibliotecari.get(0)));
        imprumuturi.add(new Imprumut(cititori.get(4), carti.get(4), LocalDate.of(2022, 2, 1), LocalDate.of(2022, 3, 1), LocalDate.of(2022, 2, 26), bibliotecari.get(1)));
        imprumuturi.add(new Imprumut(cititori.get(0), carti.get(5), LocalDate.of(2022, 2, 10), LocalDate.of(2022, 3, 10), LocalDate.of(2022, 3, 5), bibliotecari.get(2)));
        imprumuturi.add(new Imprumut(cititori.get(4), carti.get(2), LocalDate.of(2022, 1, 10), LocalDate.of(2022, 3, 10), LocalDate.of(2022, 3, 11), bibliotecari.get(2)));


    }


}






