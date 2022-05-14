package ru.demelnikov.fml.hhanalyser;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.HashSet;
import ru.demelnikov.fml.hhanalyser.Ranges.*;
import ru.demelnikov.fml.hhanalyser.Globals.*;

public class App {    
    public static final HashSet<String> etalonPoketCombos = new HashSet<>();
    
    //public static <InputStream> void main(String[] args) throws Exception {
    public  void tempName () throws FileNotFoundException {
        GGReportParser ggReportParser = new GGReportParser();
        RangesDB rangesDB = new RangesDB();        
                
        HandsDB handsDB = new HandsDB();

        ggReportParser.UpdateDB(handsDB);                
       
        System.out.println("********************************");
        System.out.println("Всего рук: " + handsDB.Size());
        System.out.println("--------------------------------");
        int q = 1;
        System.out.println("Рука "+ q  + " длиной в " + handsDB.GetHand(q).GetHandRawDataLenght());
        System.out.println("--------------------------------");

        //handsDB.GetHand(q).DisplayRawData(0);
        handsDB.GetHand(q).GetData();
        handsDB.GetHand(q).DisplayAllData();
        //handsDB.ReadAllHands();
        //handsDB.GetHand(q).getData();


        String separator = File.separator;        
        String _wayToFiles = "C:" + separator + "temp" + separator + "PKRHND" + separator;
        String _fileName =  "CO20-40_8max.txt";

        
        //RangeTable rangeTableEtalone = new RangeTable(_wayToFiles+_fileName);
        //System.out.println("Check key AQs " + rangeTableEtalone.CheckKey("AQs"));

        System.out.println("Размер BD рэнджей: " + rangesDB.DBSize());
        rangesDB.ReadNewRange_my(_wayToFiles+_fileName);
        System.out.println("Размер BD рэнджей: " + rangesDB.DBSize());        
        
        String testHand = "93o";
        rangesDB.GetRangeByIndex(0).CheckKey("testHand");
        System.out.println("Check key " + testHand + " " + rangesDB.GetRangeByIndex(0).CheckKey(testHand));
        
        //System.out.println(Actions.valueOf("F").GetRank());
        //System.out.println(rangesDB.GetRangeByIndex(0).GetRangeCellBykey(testHand).getAction1());

        rangesDB.DisplayRangeDataByIndex(0);
        
        // public boolean CheckKey (String key) {
        //     return _rangeTable.containsKey(key);
        // }
        
        //rangeTableEtalone.DisplayRange();

        

            // InputStream stream = (InputStream) System.in;
            // Scanner console = new Scanner((Readable) stream);
            
        // while (true) {
        //     // String line = console.nextLine();
        //     // System.out.println(line);
        // }

        // System.out.println("********************************");
        // System.out.println("Всего строк: " + counter);
        // System.out.println("Всего рук в массиве: " + rawHands.size());
        // System.out.println("--------------------------------");
        // int q = 1;
        // System.out.println("Рука "+ q  + " длиной в " + rawHands.get(q).GetHandRawDataLenght());
        // System.out.println("********************************");
        
        // System.out.println("Рука наполнена? " + rawHands.get(0).IsNotEmpty());
        // rawHands.get(0).DisplayRawData(1);
        // System.out.println("********************************");
        // rawHands.get(1).getData();
        // System.out.println("********************************");

        // 
    }
    // TO DO: 

    // private void FillEtalon(String etalon) throws IOException {
        
    //     String separator = File.separator;    
    //     String _wayToFiles = "C:" + separator + "temp" + separator + "PKRHND" + separator;
    //     String _fileName =  "range.txt";
    //     RangeTable rangeTable = new RangeTable(_wayToFiles+_fileName);
    //         for (String cell : rangeTable ) {
                
    //         }
    //     etalonPoketCombos = new RangeTable(_wayToFiles+_fileName);
    // }

}
