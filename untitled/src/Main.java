import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int intValue =3;
        System.out.println(intValue);
        short shortValue = 4;
        System.out.println(shortValue);
        long longValue = 5;
        System.out.println(longValue);
        byte byteValue=4;
        System.out.println(byteValue);
        double doubleValue = 4.5;
        System.out.println(doubleValue);
        float floatValue =5.5f;
        System.out.println(floatValue);
        boolean booleanValue = false;
        System.out.println(booleanValue);
        char charValue = 'c';
        System.out.println(charValue);


        Integer integerValue = 5;
        Integer integerValue2 = 6;
        int result = integerValue.compareTo(integerValue2);
        System.out.println(result);
        //integerValue
        Short shortValue2 = 6;
        Long longValue2 = 5L;
        Byte byteValue2 = 6;
        Double doubleValue2 = 5.6d;

        String stringValue = "salut";
        System.out.println(stringValue);

        //primitiva -> wrapper classs = boxing
        //wrapper class -> clasa primitiva = unboxing

        int a =5;
        Integer b = a;

        //Integer c = 6;
        //int d = c;

        char c = 'a';
        while (c <= 'z'){
            System.out.println(c);
            c++;
        };

        do {
            System.out.println(c);
            c++;
        } while (c <= 'z');

        switch (c){
            case 'a' -> System.out.println("we have a");
            case 'b' -> System.out.println("we have b");
            default -> System.out.println("we have another");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti o valoare de la tastatura: ");


    }
}