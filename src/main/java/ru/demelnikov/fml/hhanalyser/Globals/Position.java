package ru.demelnikov.fml.hhanalyser.Globals;
public enum Position {
    
    BUTTON("BU"),
    SB("SB"),
    BB("BB"),
    UTG("UTG"),
    UTG1("UTG+1"),
    UTG2("UTG+2"),
    MP("MP"),
    HJ("HJ"),
    CO("CO"),
    ERROR("ERROR");

    private final String _position;

    Position(String position) {
        this._position = position;        
    }

    public String GetPositionName () {
        return this._position;
    }
}



