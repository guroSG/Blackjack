package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckFactory {

    public static Deck createDeck(Suit suit) {
        Deck deck = new Deck();
        List<Card> generatedDeck = new ArrayList<>();

        for (int i = 2; i <= 14; i++) {
            String cardType = Integer.toString(i);
            Card card = new Card(i, cardType, suit.name);
            System.out.println(i);
            generatedDeck.add(card);
        }

        for (Card c : generatedDeck) {
            if (c.getValue() == 11) {
                c.setValue(10);
                c.setCardType("Kn");
            }
            if (c.getValue() == 12) {
                c.setValue(10);
                c.setCardType("D");
            }
            if (c.getValue() == 13) {
                c.setValue(10);
                c.setCardType("K");
            }
            if (c.getValue() == 14) {
                c.setValue(11);
                c.setCardType("A");
            }
        }

        Collections.shuffle(generatedDeck);
        deck.setDeckOfCards(generatedDeck);

        return deck;
    }
}


