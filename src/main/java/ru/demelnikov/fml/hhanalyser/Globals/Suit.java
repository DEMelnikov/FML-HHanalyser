package ru.demelnikov.fml.hhanalyser.Globals;
public enum Suit {
    HEARTS("h"),
    DIAMONDS("d"),
    SPADES("s"),
    CLUBS("c");

    private final String _suit;
    

    Suit(String suit) {
        this._suit = suit;        
    }

    public String GetSuit () {
        return this._suit;
    }
}
