package ru.demelnikov.fml.hhanalyser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class HandsDB {
    private ArrayList<Hand> _rawHands = new ArrayList<>();
    private List<Hand> _handsDB = new ArrayList<>();

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HandsDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Hand>  GetAllHandsFromDB() {
        List<Hand> handsFromDB = new ArrayList<>();
        return jdbcTemplate.query("SELECT * FROM Hand", new HandsMapper());
    }

    public void UpdateDB() {
        _rawHands.clear();
        //GGReportParser.
    }

    public void AddRawHand(Hand hand) {
        _rawHands.add(hand);
    }

    public int Size() {
        return _rawHands.size();
    }

    public Hand GetHand (int index) {
        return _rawHands.get(index);
    }

//    public Hand GetHandByIndex (Integer index) {
//        //return ha
//    }

    public void ReadDataFromAllRawHands() {
        System.out.println("Starting read hands data");
        int counter = 0;
        for (Hand hand : _rawHands) {
            if (hand.IsNotEmpty()) {
                counter++;
                //System.out.println(counter + " " + hand.IsNotEmpty());
                hand.GetData();
                saveHandToDB(hand);
                //hand.DisplayAllData();
                //System.out.println("********************************");
            }
        }
        System.out.println("Received and updated data from " + counter + " hands");

    }

    private void saveHandToDB (Hand hand) {

        jdbcTemplate.update("INSERT INTO HAND (id,roomid,bbSize,heroStack) values (1,?,?,?);",
                hand.getHandRoomID(),
                hand.getBBSize(),
                hand.getHeroStack());
       // System.out.println("Hand " + hand.getHandRoomID() + " added to DB");
    }

}
