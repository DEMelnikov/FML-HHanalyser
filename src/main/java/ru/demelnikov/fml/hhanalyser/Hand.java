package ru.demelnikov.fml.hhanalyser;

import ru.demelnikov.fml.hhanalyser.Globals.*;
import java.util.ArrayList;
import java.util.HashMap;



public class Hand {
    private ArrayList<String> _rawData = new ArrayList<>();
    private ArrayList<Seat> _seats = new ArrayList<>();
    private HashMap<Integer,Seat> _seatsData = new HashMap();

    private String _digitSeparatorToRemove = ",";
    private String _handID = null;
    private String _tournamentID = null;
    private Integer _BBsize = 0;    
    private PoketCards _poketCards;
    private String _handCardsString;
    private int _totalSeats;
    private int _heroSeat = 0;
    private int _buttonSeat = 0;
    private double _heroStackInBB = 0;
    private boolean _isBounty = false;

    //TODO: send this block to GG_Globals:
    final String  SEATS_START_LINE = "Seat ";
    final String  SEATS_HERO_MARK = ": Hero ";

    final String PLAYER_NAME_START = ": ";
    final String PLAYER_NAME_END = " ";    
    // end TODO

    public Hand () {

    }

    public  Hand (String roomID, Integer bbSize, Double stack) {
        this._handID = roomID;
        this._BBsize = bbSize;
        this._heroStackInBB = stack;
    }

    public void AddRawString(String incomeString) {
        _rawData.add(incomeString);
    }

    public boolean IsNotEmpty() {
        if (_rawData.size()==0)
            return false;    
        
        return true;
    }

    public boolean IsBounty() {
        return _isBounty;
    }

    public int GetHandRawDataLenght() {
        return _rawData.size();
    }

    public int GetPlayersCount() {
        return _totalSeats;
    }

    public void DisplayRawData (int raws) {

        if (IsNotEmpty()) {
            if (raws >= _rawData.size()) {
                System.out.println("Запрошена некорректная строка");            
            }        
            else {
                if (raws == 0) {
                    DisplayAllRawData();
                }    
                else {
                    System.out.println(_rawData.get(raws));
                }
            }            
        }    
        else {
            System.out.println("Рука не содержит данных");
        }    
    }
    public void DisplayShortData() {
        System.out.println( "Tournament: " +_tournamentID);
        System.out.println( "Blinds: " + _BBsize/2 + "/" + _BBsize);
        System.out.printf ( "Hero Stack in BB:  %.1f %n", _heroStackInBB);
        System.out.println ( "--------------------------------------------");
    }

    public void DisplayAllData() {
        System.out.println( "Tournament: " +_tournamentID);
        System.out.println( "Hand: " +_handID);
        System.out.println( "Blinds: " + _BBsize/2 + "/" + _BBsize);
        System.out.println( "Players: " + _totalSeats);
        System.out.println( "Hero seat#: " + _heroSeat);
        System.out.println( "Hero Position: " + _seatsData.get(_heroSeat).get_position() );
        System.out.println( "Button on seat#: " + _buttonSeat);
        System.out.printf ( "Hero Stack in BB:  %.1f %n", _heroStackInBB);
        System.out.println( "Hero Hand " + _poketCards.GetCardsAsString_Long() + " or " + _poketCards.GetCardsAsString_Short());        
        System.out.println( "********************************");
        for (int i = 1; i <= 10; i++) {
            if (_seatsData.containsKey(i)) {
                System.out.println( "Seat " + i + " " + _seatsData.get(i).get_position() + " - " + _seatsData.get(i).get_name());
            }
        }
        System.out.println( "********************************");
    }

    public void GetData() {
        ReadHandID();
        ReadTournamentID();
        ReadBBSize();
        ReadHeroSeat();
        ReadButtonSeat();
        ReadHeroStack();
        ReadHeroPocketCards();
        ReadPositions();
        //---
    }

    public String getHandRoomID() {
        return _handID;
    }

    public Integer getBBSize() {
        return _BBsize;
    }

    public Double getHeroStack() {
        return _heroStackInBB;
    }
    
    private int GetToatalSeats() {
        return _totalSeats;
    }

    private int GetStringIndexByStart (String startString) {        
        //System.out.println(_rawData.indexOf(startString));        
        for (String string : _rawData) {
            if (string.startsWith(startString)) {
                return _rawData.indexOf(string);        
            }
        }
        
        return 0;
    }
    
    private boolean IsSeatNotEmpty(int seatNumber ) {
        //TODO добить
        return false;
    }
    
    private String GetSportsmanNameFromString (String string) {
        Integer index = string.indexOf(PLAYER_NAME_START) + PLAYER_NAME_START.length();
        string = string.substring(index);
        //System.out.println(string);

        return DMS.GetPieceString(string, 0, PLAYER_NAME_END);
    }

    // passed ...

    private void ReadHandID() {
        if (IsNotEmpty()==false) {
            return;
        }

        String currentString = _rawData.get(0);
        int tempIndex = currentString.indexOf("#");

        _handID = DMS.GetPieceString(currentString, tempIndex, ":");
    }

    private void ReadTournamentID() {
        String currentString = _rawData.get(0);
        String keyword = "Tournament #";

        int tempIndex = currentString.indexOf(keyword);
        _tournamentID = DMS.GetPieceString(currentString, tempIndex, ",");
    }

    private void ReadBBSize() {
        String keyword = "Level";

        String currentString = _rawData.get(0);
        int tempIndex = currentString.indexOf(keyword);
        String tempString = currentString.substring(tempIndex);
        tempIndex = tempString.indexOf("(");
        tempString = DMS.GetPieceString(tempString, tempIndex+1, ")");
        tempIndex = tempString.indexOf("/");
        tempString = tempString.substring(tempIndex+1);
        tempString = tempString.replaceAll(_digitSeparatorToRemove, "");

        try {
            _BBsize = Integer.parseInt(tempString);
        } catch (Exception e) {
            System.out.println("Не удается прочесть блаинды ");
        }
    }

    private void ReadHeroSeat() {
        int index = 2;
        int playersCounter = 0;
        String keyword = "Seat";
        String keywordHeroName = "Hero";
        String separator = ": ";
        String currentString = _rawData.get(index);

        while (currentString.startsWith(keyword, 0)) {
            playersCounter++;
            index++;

            if (_heroSeat == 0) {
                String tempString = currentString.substring(keyword.length());
                int tempIndex = tempString.indexOf(separator);
                tempString = tempString.substring(tempIndex+separator.length());

                if (tempString.startsWith(keywordHeroName, 0)) {
                    _heroSeat = Integer.parseInt(DMS.GetPieceString(currentString, keyword.length()+1, ":"));
                }
            }

            currentString = _rawData.get(index);
        }
        _totalSeats = playersCounter;
    }

    private void ReadButtonSeat() {
        String stringKeyword = "Table";
        String keyword = "Seat #";
        String currentString = _rawData.get(GetStringIndexByStart(stringKeyword));

        int tempIndex = currentString.indexOf(keyword);
        String tempString = currentString.substring(tempIndex+keyword.length());

        _buttonSeat = Integer.parseInt(DMS.GetPieceString(tempString, 0, " "));
    }

    private void ReadHeroStack() {
        if (_heroSeat !=0 && _BBsize!=0) {

            String keyword = SEATS_START_LINE + _heroSeat +SEATS_HERO_MARK + "(";

            String currentString = _rawData.get(GetStringIndexByStart(keyword));
            String tempString = currentString.substring(keyword.length());
            tempString = DMS.GetPieceString(tempString, 0, " ");
            tempString = tempString.replaceAll(_digitSeparatorToRemove, "");
            _heroStackInBB = Integer.parseInt(tempString)/(double)_BBsize;

        }
        else {
            System.out.println("No Hero Position or BBSize = 0");
        }
    }

    private void ReadHeroPocketCards() {
        String keyword = "Dealt to Hero [";
        String currentString = _rawData.get(GetStringIndexByStart(keyword));
        _handCardsString = DMS.GetPieceString(currentString, keyword.length(), "]");
        _poketCards = new PoketCards(_handCardsString);
    }

    private void ReadPositions() {
        int indexLineStart = GetStringIndexByStart(SEATS_START_LINE);
        int indexLineFinish = indexLineStart + _totalSeats;
        int indexButton = GetStringIndexByStart(SEATS_START_LINE + _buttonSeat+": ");
        int currentIndex = indexButton;
        int counter = 0;

        if (_totalSeats >= Globals.MIN_SEATS_To_ANALYSE && _totalSeats <= Globals.MAX_SEATS_To_ANALYSE) {
            for (int i = 0; i < _totalSeats; i++) {
//              System.out.println("++++++++++++++");
                String tempString = _rawData.get(currentIndex).substring(SEATS_START_LINE.length());
                Integer currentSeatNumber = Integer.parseInt(DMS.GetPieceString(tempString, 0, ":"));
                _seatsData.put(currentSeatNumber,
                    new Seat(Globals.xPositionsMap.get(_totalSeats)[counter],
                     currentSeatNumber,
                     GetSportsmanNameFromString(_rawData.get(currentIndex))));

//                System.out.println(currentSeatNumber + " Seat: " +
//                    _seatsData.get(currentSeatNumber).get_position()+ " Name: " + GetSportsmanNameFromString(_rawData.get(currentIndex)));

                currentIndex++;
                counter++;
                if (currentIndex == indexLineFinish) {
                    currentIndex = indexLineStart;
                }
            }
        }
        else {
//            System.out.println("+++++++++++++++++++++++++++++++++");
//            System.out.println("Seats number out of Analyse range");
//            System.out.println("+++++++++++++++++++++++++++++++++");
        }
    }

    private void DisplayAllRawData() {
        for (String string : _rawData) {
            System.out.println(string );
        }
    }
}
