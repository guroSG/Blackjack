package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlackjackModel {
    public static Deck startGame(){
        Deck heartDeck = DeckFactory.createDeck(Suit.HJÄRTER);
        Deck spadeDeck = DeckFactory.createDeck(Suit.SPADER);
        Deck clubDeck = DeckFactory.createDeck(Suit.KLÖVER);
        Deck diamondDeck = DeckFactory.createDeck(Suit.RUTER);
        List<Card> tempDeck = new ArrayList<>();
        tempDeck.addAll(heartDeck.getDeckOfCards());
        tempDeck.addAll(spadeDeck.getDeckOfCards());
        tempDeck.addAll(clubDeck.getDeckOfCards());
        tempDeck.addAll(diamondDeck.getDeckOfCards());
        Collections.shuffle(tempDeck);
        Deck deck = new Deck();
        deck.setDeckOfCards(tempDeck);
        return deck;
    }

}
