package ru.demelnikov.fml.hhanalyser.Ranges;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import ru.demelnikov.fml.hhanalyser.Ranges.Readers.RangeReader_my;

@Component
public class RangesDB {
    
    private ArrayList<RangeTable> _rangesList = new ArrayList<>();

    public Integer DBSize() {
        return _rangesList.size();
    }

    public void ReadNewRange_my (String filename) {
        RangeReader_my reader = new RangeReader_my();
        _rangesList.add(reader.ReadNewRange(filename));
    }

    public void DisplayRangeDataByIndex (Integer index) {
        System.out.println("В запрошенном рэндже " + _rangesList.get(index).GetSize() + " строк." );        
        _rangesList.get(index).DisplayRangeData();
    }

    public RangeTable GetRangeByIndex (Integer index) {
        return _rangesList.get(index);
    }
}
