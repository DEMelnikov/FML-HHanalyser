package ru.demelnikov.fml.hhanalyser;

import ru.demelnikov.fml.hhanalyser.Globals.*;

public class Seat {
    private Position _position;
    private Integer _stackSize;    
    private String _name;
    private Integer _seatNumber;

    public Seat (Position position, Integer seatNumber, String name, Integer stack ) {
        this._position = position;
        this._seatNumber = seatNumber;
        this._name = name;
        this._stackSize = stack;
    }

    public Seat (Position position, Integer seatNumber, String name ) {
        this._position = position;
        this._seatNumber = seatNumber;
        this._name = name;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public Position get_position() {
        return _position;
    }

    public void set_position(Position _position) {
        this._position = _position;
    }

    public Integer get_stackSize() {
        return _stackSize;
    }

    public void set_stackSize(Integer _stackSize) {
        this._stackSize = _stackSize;
    }
    
    public Integer getSeatNumber() {
        return _seatNumber;
    }
    
}
