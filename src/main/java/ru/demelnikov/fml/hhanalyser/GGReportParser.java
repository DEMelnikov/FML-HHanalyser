package ru.demelnikov.fml.hhanalyser;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Component("ggReportParser")
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
        SplitReportToRawHands(handsDB);
        handsDB.ReadDataFromAllRawHands();
    }

    private void SplitReportToRawHands(HandsDB handsDB) throws FileNotFoundException {
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
                    handsDB.AddRawHand(currentHand);
                    currentHand = new Hand();                    
                    handsCounter++;
                }    
                currentHand.AddRawString(currentString); 
                counter++;                
            }
        }

        System.out.println("Parsing done. Get " + counter + " strings");     
        System.out.println("Raw hands found : "+ handsCounter);
        System.out.println("Чтение файла закончено");
        scanner.close();
    }
}
