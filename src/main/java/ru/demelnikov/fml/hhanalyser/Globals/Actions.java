package ru.demelnikov.fml.hhanalyser.Globals;

public enum Actions {
    C4BA("4bet + All in", 3), 
    C3B ("OR + Call 3bet", 2), 
    OR("Open Raise", 1),
    F("Fold", 0),
    ERROR("ERROR",-1);

    private final String _action;
    private final Integer _rank;
    //private String _code; 

     Actions(String action, Integer rank) {
        this._action = action;
        this._rank = rank;
        //this._code = code;
    }

    public String GetActionName () {
        return this._action;
    }

    public Integer GetRank() {
        return this._rank;
    }

    // public Integer GetCode() {
    //     return this._rank;
    // }
}