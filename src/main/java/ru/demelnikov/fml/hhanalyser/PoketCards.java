package ru.demelnikov.fml.hhanalyser;

import ru.demelnikov.fml.hhanalyser.Globals.Suit;

public class PoketCards {
    private Card _card1;
    private Card _card2;

    public PoketCards(Card card1, Card card2) {
        this._card1 = card1;
        this._card2 = card2;
    }

    public PoketCards (String cardsString) {
        
        cardsString = cardsString.toUpperCase();

        Card cardA = new Card(ConvertCharToCardClass(cardsString.charAt(0)), ConvertCharToCardSuit(cardsString.charAt(1)));
        Card cardB = new Card(ConvertCharToCardClass(cardsString.charAt(3)), ConvertCharToCardSuit(cardsString.charAt(4)));

        if (cardA.GetRank()>cardB.GetRank()) {
            this._card1 = cardA;
            this._card2 = cardB;
        }
        else {
            this._card1 = cardB;
            this._card2 = cardA;
        }
        
    }

    public String GetCardsAsString_Long() {
        return "["+_card1.GetName() + " " + _card2.GetName() + "]";
    }

    public String GetCardsAsString_Short() {
        String suitChar = "o";
        if (_card1.GetSuit()==_card2.GetSuit()) {
            suitChar = "s";
            
        }
        return "["+_card1.GetValue() + _card2.GetValue() + suitChar + "]";
    }

    private Suit ConvertCharToCardSuit (char cardSymbol)  {
        Suit suit = Suit.SPADES;
        // TODO: try / catch        

        switch (cardSymbol) {
            case 'H':
                suit = Suit.HEARTS;
                break;
            case 'D':
                suit = Suit.DIAMONDS;
                break;
            case 'C':
                suit = Suit.CLUBS;
                break;
            case 'S':
                suit = Suit.SPADES;
                break;
            default:
                break;
        }
        return suit;
    }
        
    private CardValue ConvertCharToCardClass (char cardSymbol)  {
        
        CardValue cardValue = CardValue.c2;

        switch (cardSymbol) {
            case '2':
                cardValue = CardValue.c2;                
                break;
            case '3':
                cardValue = CardValue.c3; 
                break;
            case '4':
                cardValue = CardValue.c4; 
                break;
            case '5':
                cardValue = CardValue.c5; 
                break;
            case '6':
                cardValue = CardValue.c6; 
                break;
            case '7':
                cardValue = CardValue.c7; 
                break;
            case '8':
                cardValue = CardValue.c8; 
                break;
            case '9':
                cardValue = CardValue.c9; 
                break;
            case 'T':
                cardValue = CardValue.T; 
                break;
            case 'J':
                cardValue = CardValue.J;                
                break;
            case 'Q':
                cardValue = CardValue.Q; 
                break;
            case 'K':
                cardValue = CardValue.K; 
                break;
            case 'A':
                cardValue = CardValue.A; 
                break;
            default:            
                cardValue = CardValue.c2;             
                break;
        }
        
        return cardValue;
    }
}
