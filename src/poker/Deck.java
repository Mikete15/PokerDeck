package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck;
    private ArrayList<Card> cartasRetiradas;

    public Deck() {
        deck = new ArrayList<>();
        cartasRetiradas = new ArrayList<>();
        inicializarDeck();
    }

    private void inicializarDeck() {

        String[] palos = {
                "Tréboles",
                "Corazones",
                "Picas",
                "Diamantes"
        };

        String[] valores = {
                "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "A", "J", "Q", "K"
        };

        for (String palo : palos) {

            String color;

            if (palo.equals("Corazones") || palo.equals("Diamantes")) {
                color = "Rojo";
            } else {
                color = "Negro";
            }

            for (String valor : valores) {
                deck.add(new Card(palo, color, valor));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {

        if (deck.isEmpty()) {
            System.out.println("El Deck está vacío.");
            return;
        }

        Card carta = deck.remove(0);
        cartasRetiradas.add(carta);

        System.out.println(carta);
        System.out.println("Quedan " + deck.size() + " cartas en deck");
    }

    public void pick() {

        if (deck.isEmpty()) {
            System.out.println("El Deck está vacío.");
            return;
        }

        Random random = new Random();
        int posicion = random.nextInt(deck.size());

        Card carta = deck.remove(posicion);
        cartasRetiradas.add(carta);

        System.out.println(carta);
        System.out.println("Quedan " + deck.size() + " cartas en deck");
    }

    public Card[] hand() {

        if (deck.size() < 5) {
            System.out.println("No hay suficientes cartas para formar una mano.");
            return new Card[0];
        }

        Card[] mano = new Card[5];

        for (int i = 0; i < 5; i++) {
            Card carta = deck.remove(0);
            cartasRetiradas.add(carta);
            mano[i] = carta;

            System.out.println(carta);
        }

        System.out.println("Quedan " + deck.size() + " cartas en deck");

        return mano;
    }
}