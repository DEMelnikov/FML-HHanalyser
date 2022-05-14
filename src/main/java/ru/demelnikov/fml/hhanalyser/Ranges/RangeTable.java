package ru.demelnikov.fml.hhanalyser.Ranges;

import ru.demelnikov.fml.hhanalyser.Globals.Position;
import java.util.HashMap;

public class RangeTable {
    
    private Integer _minBB;
    private Integer _maxBB;
    private String _name;
    private Integer _tableSize;
    private String _author;
    private String _source;
    private String _type;
    private Position _position;
    
    public Integer get_minBB() {
        return _minBB;
    }
    
    public Integer get_maxBB() {
        return _maxBB;
    }
    
    public String get_name() {
        return _name;
    }

    public Integer get_tableSize() {
        return _tableSize;
    }

    public String get_author() {
        return _author;
    }

    public String get_source() {
        return _source;
    }

    public String get_type() {
        return _type;
    }

    public Position get_position() {
        return _position;
    }

    private HashMap<String,RangeCell> _rangeTable = new HashMap<String,RangeCell>();

    public RangeTable (Integer minBB, Integer maxBB, Integer tableSize, String name, Position position) {
        this._minBB = minBB;
        this._maxBB = maxBB;
        this._tableSize = tableSize;
        this._name = name;
        this._position = position;
        System.out.println("Создана новая RangeTable " + name);
        
        //System.out.println("Range table added " + _rangeTable.size() + " cells");        
        
    }

    public boolean CheckKey (String key) {
        return _rangeTable.containsKey(key);
    }

    public void AddNewCell (String key,  RangeCell range) {
        _rangeTable.put(key,range);
    }

    public Integer GetSize() {
        return _rangeTable.size();
    }

    public RangeCell GetRangeCellBykey (String key) {
        return _rangeTable.get(key);
    }

    public void DisplayRangeData() {
        System.out.println("Range name: " + _name + " players");
        System.out.println("Min stack: " + _minBB + "BB");
        System.out.println("Max stack: " + _maxBB + "BB");
        System.out.println("Table Size: " + _tableSize);
        System.out.println("For position: " + _position.GetPositionName());

        _rangeTable.forEach((k, v) -> {
            System.out.format(" key: %s, value: %s;", k, v.getAction1());
        });
    }

    




}
