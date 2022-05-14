package ru.demelnikov.fml.hhanalyser;

import java.util.ArrayList;

public class HandsDB {
    private ArrayList<Hand> _rawHands = new ArrayList<>();

    public void UpdateDB() {
        _rawHands.clear();
        //GGReportParser.
    }

    public void AddHand (Hand hand) {
        _rawHands.add(hand);
    }

    public int Size() {
        return _rawHands.size();
    }

    public Hand GetHand (int index) {
        return _rawHands.get(index);
    }

    public void ReadAllHands() {
        int counter = 0;
        for (Hand hand : _rawHands) {
            if (hand.IsNotEmpty()) {
                counter++;
                System.out.println(counter + " " + hand.IsNotEmpty());
                hand.GetData();
                hand.DisplayAllData();
                System.out.println("********************************");
            }
        }
    }

}
