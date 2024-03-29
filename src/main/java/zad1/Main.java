package zad1;

public class Main {

    public static void main(String[] args) {

        /*
        Zadanie 01:
        Stworz serwis dla figur geometrycznych.
        Kazda Figura moze miec policzone pole i obwod
        Mamy 3 implementacje (Kwadrat(bok), Kolo(promien), Prostokat(dl, szer))
        Stworz Seriws dla Figur w ktorym bedziemy mieli mozliwosc
        - znalezienia figury z najwiekszym polem (arg metody; lista figur)
        - znalezienie figury z najwiekszym obwodem (typu X) arg metody: lista figur i szukany typ.
        - export listy figur to JSON *void, argument to lista figur oraz sciezka gdzie zapisac
        - import listy figur z JSON  zwraca List<Shape> i jako argument pobiera sciezke do pliku

        nastepnie napisz testy jednostkowe, gdzie trzeba uzyj mockowania (o ile trzeba)
        przygotuj tez raport jacocco z pokryciem kodu testami.

        json z lista figur ma wygladac np tak:
        [{"type": "circle", "radius": 1.5}, {"type": "rectangle", "width": 15, "height": 20}]

       Uwaga:
       Figury maja byc cacheowalne a ich samoistne tworzenie powinno byc zablokowane.
       Jedyny sposob stworzenia figury to przez metody fabryczne z jakiejs klasy shapeFactory ktora jednoczesnie operuje na cache'u
       ma to wyglada np tak:
       Square sq1 = shapeFactory.createSquare(10); // nie ma jeszcze kwadratu o boku 10 wiec tworzy nowa instancje
       Square sq2 = shapeFactory.createSquare(10); // jest juz kwadrat o boku 10, wiec sq2 powinno byc ta sama referencja co sq1 (czyli sq1 == sq2) powinno dac true.


      nalezy napisac testy jednostkowe shapeFactory i ich metoda fabrycznych sprawdzajac asercje interakcji z jakims cachem ktory ma w srodku i sprawdzic czy on faktycznie dziala.*/

    }

}
