package ru.demelnikov.fml.hhanalyser;

import ru.demelnikov.fml.hhanalyser.Globals.Suit;

public class Card {
    private CardValue _value;
    private Suit _suit;

    public Card (CardValue value, Suit suit) {
        this._value = value;
        this._suit = suit;
    }

    public String GetName(){
        return _value.GetValue() + _suit.GetSuit();
    }

    public String GetValue() {
        return _value.GetValue();
    }

    public String GetSuit(){
        return _suit.GetSuit();
    }

    public int GetRank() {
        return _value.GetRank();
    }
}
