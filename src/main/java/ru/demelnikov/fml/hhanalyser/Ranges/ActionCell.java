package ru.demelnikov.fml.hhanalyser.Ranges;


import ru.demelnikov.fml.hhanalyser.Globals.*;

public class ActionCell {
    private Actions _action;
    private double _rate;

    public ActionCell (Actions action, double rate) {
        this._action = action;
        this._rate = rate;
    }

    public ActionCell (String action, double rate) {        
        this._rate = rate;
        this._action = EnumConverter.StringToAction(action);                
    }

    public Actions GetAction() {
        return _action;   
    }

    public double GetRate () {
        return _rate;
    }   
}
