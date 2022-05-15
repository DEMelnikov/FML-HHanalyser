package ru.demelnikov.fml.hhanalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GGReportParser {
    private final String _handSeparator = "Poker Hand #";
    String separator = File.separator;        
    //private final String _wayToFiles = "C:" + separator + "temp" + separator + "PKRHND";
    private final String _wayToFiles = separator+ "Users" + separator + "demelnikov" + separator + "Desktop"+ separator + "WIL";

    private final String _fileName =  "qqq.txt";
    //private final String _wayToParse = _wayToFiles+_fileName;

    private boolean _status = false;

    public boolean isFinished () {
        return _status;
    }

    public void UpdateDB(HandsDB handsDB) throws FileNotFoundException {
        ParseReport(handsDB);
    }

    private void ParseReport(HandsDB handsDB) throws FileNotFoundException {
        File file = new File(_wayToFiles, _fileName);
        //Path file = Path.of(_wayToFiles);
        Scanner scanner = new Scanner(file);
          
        Hand currentHand = new Hand();
    
        int counter = 0;
        int handsCounter =0;
        while (scanner.hasNextLine()) {
            
            String currentString = scanner.nextLine();          
    
            if (currentString!=null) {
                
                if (currentString.startsWith(_handSeparator)) {                
                    handsDB.AddHand(currentHand);
                    currentHand = new Hand();                    
                    handsCounter++;
                }    
                currentHand.AddRawString(currentString); 
                counter++;                
            }
        }

        System.out.println("Parsing done. Get " + counter + " strings");     
        System.out.println("Hands found: "+ handsCounter);
        scanner.close();
    }

    // private void ReadAllHands(HandsDB handsDB) {
        
    // }

    


}
