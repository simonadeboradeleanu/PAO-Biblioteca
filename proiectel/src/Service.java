import classes.*;
import interfaces.*;

import org.jetbrains.annotations.NotNull;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.*;

public class Service extends ServiceInitializare{

    public List<Autor> cautareAutoriDinSectiune(@NotNull List<Carte> carti, Sectiune sectiune) {
        AuditService.inregistrareActiune("cautare autori din sectiune");

        List<Autor> autori = new ArrayList<>();

        for (Carte Carte : carti) {
            if (Carte.getSectiune().equals(sectiune)) {
                autori.add(Carte.getAutor());
            }
        }
        System.out.println("Autorii ce au carti in sectiunea " + sectiune.getNume()+" sunt: ");
        StringBuilder sb = new StringBuilder();
        for (iAutor book : autori) {
            sb.append(book.getNume()).append(", ");
        }
        String result = sb.toString();
        if (!result.isEmpty()) {
            result = result.substring(0, result.length() - 2); // Remove the last ", "
        }
        System.out.println(result);


        return autori;
    }
/*    public static Service getInstance() {
        if (instance == null) {
            synchronized (Service.class) {
                if (instance == null) {
                    instance = new Service();
                }
            }
        }
        return instance;
    }*/
    private double calculateAverageRating(@NotNull iCarte iCarte) {
        int numarRatinguri = iCarte.getRatings().size();
        double sumaRatinguri = 0.0;
        for (Rating rating : iCarte.getRatings()) {
            sumaRatinguri += rating.getNota();
        }
        if (numarRatinguri > 0) {
            return sumaRatinguri / numarRatinguri;
        } else {
            return 0.0;
        }
    }
    public List<iCarte> getTopRatedBooks(int count) {
        AuditService.inregistrareActiune("cartile cu cele mai mari ratinguri");

        List<iCarte> topRatedBooks = new ArrayList<>(carti);
        topRatedBooks.sort(Comparator.comparingDouble(this::calculateAverageRating).reversed());
        if (count < topRatedBooks.size()) {
            topRatedBooks = topRatedBooks.subList(0, count);

        }
        System.out.println("Primele " + count + " carti cu cel mai mare rating sunt: ");
        StringBuilder sb = new StringBuilder();
        for (iCarte book : topRatedBooks) {
            sb.append(book.getTitlu()).append(", ");
        }
        String result = sb.toString();
        if (!result.isEmpty()) {
            result = result.substring(0, result.length() - 2); // Remove the last ", "
        }
        System.out.println(result);

        return topRatedBooks;
    }

    public List<iCarte> searchBooksByTitle(String title) {
        AuditService.inregistrareActiune("cartile care se potrivesc cu titlul");

        List<iCarte> matchingBooks = new ArrayList<>();
        for (iCarte carte : carti) {
            if (carte.getTitlu().toLowerCase().contains(title.toLowerCase())) {
                matchingBooks.add(carte);
            }
        }
        System.out.println("Cartile ce s-ar potrivi cu titlul *" + title + "* sunt: " );
        StringBuilder sb = new StringBuilder();
        for (iCarte book : matchingBooks) {
            sb.append(book.getTitlu()).append(", ");
        }
        String result = sb.toString();
        if (!result.isEmpty()) {
            result = result.substring(0, result.length() - 2); // Remove the last ", "
        }
        System.out.println(result);

        return matchingBooks;
    }

    public void addRating(@NotNull iCarte c, double nota, String mesaj) {
        AuditService.inregistrareActiune("rating adaugat pentru carte");

        Rating r = new Rating(nota, mesaj);
        c.addRating(r);
        System.out.println("Rating adaugat pentru cartea " + c.getTitlu());

    }
    public void addRating(@NotNull Autor a, double nota, String mesaj) {
        AuditService.inregistrareActiune("rating adaugat pentru autor");

        Rating r = new Rating(nota, mesaj);
        a.addRating(r);
        System.out.println("Rating adaugat pentru autorul " + a.getNume() + " "+ a.getPrenume());
    }

    public void initRating(){
        addRating(Objects.requireNonNull(Autor.getAutorById(autori, 3)), 5, "Lucian Blaga este autorul meu preferat");
        addRating(Objects.requireNonNull(iCarte.getCarteById(carti, 2)), 4.5, "O carte foarte buna despre dezvoltare personala.");
        addRating(Objects.requireNonNull(Autor.getAutorById(autori, 1)), 3.8, "Cea mai buna carte de istorie pe care am citit-o.");
        addRating(Objects.requireNonNull(iCarte.getCarteById(carti, 1)), 2.1, "Nu mi-a placut deloc aceasta carte de fictiune.");
        addRating(Objects.requireNonNull(Autor.getAutorById(autori, 2)), 4.9, "Scriitura autorului este uimitoare!");
        addRating(Objects.requireNonNull(iCarte.getCarteById(carti, 1)), 4.7, "Un thriller captivant, cu multe surprize si intrigi.");
        addRating(Objects.requireNonNull(Autor.getAutorById(autori, 4)), 3.5, "Poezia sa nu este pe gustul meu.");
        addRating(Objects.requireNonNull(iCarte.getCarteById(carti, 3)), 4.3, "Un roman emotionant si inspirator.");
        addRating(Objects.requireNonNull(Autor.getAutorById(autori, 1)), 4.6, "Am citit toate cartile autorului si aceasta este preferata mea.");
        addRating(Objects.requireNonNull(iCarte.getCarteById(carti, 2)), 3.2, "O carte interesanta despre filosofie, dar greu de inteles.");

    }

    public Map<iCititor, String> istoricCarte(iCarte iCarte) {
        AuditService.inregistrareActiune("istoric imprumuturi ptr carte");

        Map<iCititor, String> istoric = new HashMap<>();
        System.out.println("Cartea data ca parametru a mai fost imprumutata de: ");
        for (Imprumut iImprumut: imprumuturi) {
            if (iImprumut.getCarte().equals(iCarte)) {
                iCititor iCititor = iImprumut.getCititor();
                istoric.put(iCititor, iCititor.getTelefon());
                System.out.println(iCititor.getPrenume() + iCititor.getNume() + ", cu nr de telefon: " + iCititor.getTelefon() + "    ");
            }
        }
        return istoric;
    }

    public void mediaRating(@NotNull iCarte iCarte) {
        AuditService.inregistrareActiune("calculare media ratingurilor ptr carte");

        int numarRatinguri = iCarte.getRatings().size();
        double sumaRatinguri = 0.0;
        for (Rating rating : iCarte.getRatings()) {
            sumaRatinguri += rating.getNota();
        }
        double sol = 0.0;
        if (numarRatinguri > 0) {
            sol = sumaRatinguri / numarRatinguri;
        }
        System.out.println(iCarte.getTitlu() + " are media ratingurilor" + sol);
    }
    public double mediaRating(@NotNull Autor carte) {
        AuditService.inregistrareActiune("calculare media ratingurilor ptr autor");

        int numarRatinguri = carte.getRatings().size();
        double sumaRatinguri = 0.0;
        for (Rating rating : carte.getRatings()) {
            sumaRatinguri += rating.getNota();
        }
        if (numarRatinguri > 0) {
            return sumaRatinguri / numarRatinguri;
        } else {
            return 0.0;
        }
    }

    public boolean hasAuthorBooksWithHigherRating(Autor autor, double rat) {
        AuditService.inregistrareActiune("autorul are sau nu carti cu rating mai mare");

        for (Carte carte : carti) {
            if (carte.getAutor().equals(autor)) {
                for (Rating rating : carte.getRatings()) {
                    if (rating.getNota() > rat) {
                        System.out.println("Autorul " + autor.getNume() + " " + autor.getPrenume() + " are cel putin o carte cu rating mai mare de " + rat);
                        return true;
                    }
                }
            }
        }
        System.out.println("Autorul " + autor.getNume() + " " + autor.getPrenume() + "nu are nici macar o carte cu rating mai mare de " + rat);

        return false;
    }

    public List<iCarte> sortBooksByRating() {
        AuditService.inregistrareActiune("sorteaza cartile dupa rating");

        List<iCarte> sortedBooks = new ArrayList<>(carti);
        sortedBooks.sort(Comparator.comparingDouble(this::calculateAverageRating).reversed());
        System.out.println("Lista de carti a bibliotecii a fost sortata in functie de rating.");
        return sortedBooks;
    }

    public Autor getMostPopularAuthor() {
        AuditService.inregistrareActiune("cel mai iimprumutat autor");

        Map<Autor, Integer> authorBorrowCount = new HashMap<>();
        for (Imprumut imprumut : imprumuturi) {
            Autor author = imprumut.getCarte().getAutor();
            authorBorrowCount.put(author, authorBorrowCount.getOrDefault(author, 0) + 1);
        }
        Autor autor = Collections.max(authorBorrowCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Cel mai popular autor, ale carui carti au fost imprumutate de cele mai multe ori, este " + autor.getPrenume() + " " + autor.getNume());
        return Collections.max(authorBorrowCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public Cititor getReaderWithLongestDelay() {
        AuditService.inregistrareActiune("cititorul cu cea mai mare intarziere");

        Cititor reader = null;
        long longestDelay = 0;

        for (Imprumut imprumut : imprumuturi) {
            LocalDate expectedReturnDate = imprumut.getExpectedDataRestituire();
            LocalDate actualReturnDate = imprumut.getActualDataRestituire();

            if (actualReturnDate != null) {
                long delay = ChronoUnit.DAYS.between(expectedReturnDate, actualReturnDate);
                if (delay > longestDelay) {
                    longestDelay = delay;
                    reader = imprumut.getCititor();
                }
            }
        }
        if(reader == null)
        {
            System.out.println("Niciun cititor nu a avut intarziere.");
            return null;
        }
        System.out.println("Cititorul cu cea mai lunga intarziere este " + reader.getPrenume() + " " + reader.getNume());
        return reader;
    }











}