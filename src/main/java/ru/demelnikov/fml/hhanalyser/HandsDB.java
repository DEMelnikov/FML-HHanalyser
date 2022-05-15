package ru.demelnikov.fml.hhanalyser;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class HandsDB {
    private ArrayList<Hand> _rawHands = new ArrayList<>();
    private List<Hand> _handsDB = new ArrayList<>();

    //TODO: Remove this block
    private static final String URL = "jdbc:postgresql://localhost:5433/FML-TestDB1";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "$PSGpsg35";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e)  {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void index() {
        List<Hand> handsFromDB = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL  = "SELECT * FROM Hand";
            ResultSet resultSet = statement.executeQuery(SQL);

            Integer tempCounter = 0;
            while (resultSet.next()) {
                String handID = resultSet.getString("roomid");
                Integer bbsize = resultSet.getInt("bbsize");
                Double stack = resultSet.getDouble("heroStack");

                handsFromDB.add(new Hand(handID,bbsize,stack));
                handsFromDB.get(tempCounter).DisplayShortData();
                tempCounter++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO HAND (id,roomid,bbSize,heroStack) values (1,?,?,?)");

            preparedStatement.setString(1,hand.getHandRoomID());
            preparedStatement.setInt(2,hand.getBBSize());
            preparedStatement.setDouble(3,hand.getHeroStack());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

       // System.out.println("Hand " + hand.getHandRoomID() + " added to DB");
    }

}
