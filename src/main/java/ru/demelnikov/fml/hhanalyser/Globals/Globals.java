package ru.demelnikov.fml.hhanalyser.Globals;
//import java.util.ArrayList;
import java.util.HashMap;

public class Globals {
    
    //ArrayList<ArrayList<Position>> PositionsDB = new ArrayList<>();

    // final Position[] positions5max = new Position[] {Position.BUTTON, Position.SB, Position.BB, Position.CO, Position.HJ };
    // final Position[] positions6max = new Position[] {Position.BUTTON, Position.SB, Position.BB, Position.MP, Position.CO, Position.HJ };
    // final Position[] positions7max = new Position[] {Position.BUTTON, Position.SB, Position.BB, Position.UTG, Position.MP, Position.CO, Position.HJ };
    // final Position[] positions8max = new Position[] {Position.BUTTON, Position.SB, Position.BB, Position.UTG, Position.UTG1, Position.MP, Position.CO, Position.HJ };
    public static int MIN_SEATS_To_ANALYSE = 5;
    public static int MAX_SEATS_To_ANALYSE = 10;

    public static final HashMap<Integer,Position[]> xPositionsMap;// = new HashMap<>() {
    static {
        xPositionsMap = new HashMap<>();
        xPositionsMap.put(5, new Position[] {Position.BUTTON, Position.SB, Position.BB, Position.HJ, Position.CO });
        xPositionsMap.put(6, new Position[] {Position.BUTTON, Position.SB, Position.BB, Position.MP, Position.HJ, Position.CO });
        xPositionsMap.put(7, new Position[] {Position.BUTTON, Position.SB, Position.BB, Position.UTG, Position.MP, Position.HJ, Position.CO });
        xPositionsMap.put(8, new Position[] {Position.BUTTON, Position.SB, Position.BB, Position.UTG, Position.UTG1, Position.MP, Position.HJ, Position.CO });
        xPositionsMap.put(9, new Position[] {Position.BUTTON, Position.SB, Position.BB, Position.UTG, Position.UTG1, Position.UTG2, Position.MP, Position.HJ, Position.CO });
        xPositionsMap.put(10,new Position[] {Position.BUTTON, Position.SB, Position.BB, Position.UTG, Position.UTG1, Position.UTG2, Position.MP, Position.MP, Position.HJ, Position.CO });
    }
    
    public Globals() {

    }

}
