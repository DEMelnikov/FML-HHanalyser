package ru.demelnikov.fml.hhanalyser.Ranges.Readers;
//import Ranges.*;

import ru.demelnikov.fml.hhanalyser.Ranges.RangeTable;

public interface RangeReader {
    public RangeTable ReadNewRange(String filepath);
}
