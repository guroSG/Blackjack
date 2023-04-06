package model;

public enum Suit {

    HJÄRTER("♥"),
    KLÖVER("♣"),
    SPADER("♠"),
    RUTER("♦");

    public final String name;

    Suit(String n){
        name = n;
    }
}

