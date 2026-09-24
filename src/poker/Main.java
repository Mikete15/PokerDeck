package poker;

public class Main {

    public static void main(String[] args) {

        Deck deck = new Deck();

        System.out.println("----- SHUFFLE -----");
        deck.shuffle();

        System.out.println("\n----- HEAD -----");
        deck.head();

        System.out.println("\n----- PICK -----");
        deck.pick();

        System.out.println("\n----- HAND -----");
        deck.hand();
    }
}