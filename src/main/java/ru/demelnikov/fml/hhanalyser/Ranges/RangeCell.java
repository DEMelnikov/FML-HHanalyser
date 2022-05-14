package ru.demelnikov.fml.hhanalyser.Ranges;
public class RangeCell {
    
    private final String _key;
    //private String _action1;
    private final ActionCell _action1;
    
    //private String _key;
    public RangeCell (String key, ActionCell action1) {
        this._key = key;
        //System.out.println(action1);
        this._action1 = action1;
    }

    public String getKey() {
        return _key;
    }

    public String getAction1() {
        //System.out.print("Action: ");
        return _action1.GetAction().GetActionName();
    }
}
