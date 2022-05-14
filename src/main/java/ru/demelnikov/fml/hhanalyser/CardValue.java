package ru.demelnikov.fml.hhanalyser;
//TODO: remove to Globals

public enum CardValue {
    c2("2",1,12),
    c3("3",2,11),
    c4("4",3,10),
    c5("5",4,9),
    c6("6",5,8),
    c7("7",6,7),
    c8("8",7,6),
    c9("9",8,5),
    T("T",9,4),
    J("J",10,3),
    Q("Q",11,2),
    K("K",12,1),
    A("A",13,0);

    private String _value;
    private int _rank;
    private int _rangePosition;

    CardValue(String value, int rank, int rangePosition) {
        this._value = value;
        this._rank = rank;
        this._rangePosition = rangePosition;
    }

    public String GetValue () {
        return this._value;
    }

    public int GetRank () {
        return this._rank;
    }

    public int GetRangePosition () {
        return this._rangePosition;
    }
}
