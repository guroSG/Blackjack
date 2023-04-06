package model;

public class Card {
    private int value;
    private String cardType;
    private String suit;
    public int getValue() {
        return value;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Card(int value, String cardType, String suit) {
        this.value = value;
        this.suit = suit;
        this.cardType = cardType;
    }
}
