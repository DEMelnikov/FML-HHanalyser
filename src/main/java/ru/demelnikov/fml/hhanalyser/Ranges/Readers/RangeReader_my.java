package ru.demelnikov.fml.hhanalyser.Ranges.Readers;
import ru.demelnikov.fml.hhanalyser.Globals.*;
//import ru.demelnikov.fml.hhanalyser.Globals.Position;
import ru.demelnikov.fml.hhanalyser.Ranges.ActionCell;
import ru.demelnikov.fml.hhanalyser.Ranges.RangeCell;
import ru.demelnikov.fml.hhanalyser.Ranges.RangeTable;

import java.io.File;
import java.util.Scanner;



public class RangeReader_my implements RangeReader{

    @Override
    public RangeTable ReadNewRange(String filepath) {

        try {
            File file = new File(filepath);
            Scanner scanner = new Scanner(file);
            
            Integer minBB =0;
            Integer maxBB =0;
            Integer tableSize =0;
            try {
                minBB = Integer.parseInt(scanner.nextLine());
                maxBB = Integer.parseInt(scanner.nextLine());                 
                tableSize =  Integer.parseInt(scanner.nextLine());                 
            } catch (Exception e) {
                System.out.println("parse min/max/table Size NOT passed ");    
            }
            
            String rangeName = scanner.nextLine();      
             
            Position position = EnumConverter.StringToPosition(scanner.nextLine());
            

            RangeTable rangetable = new RangeTable(minBB,maxBB,tableSize,rangeName,position);

            Integer count =0;
            while (scanner.hasNextLine()) {
                count++;
                //scanner.
                String currentString = scanner.nextLine();            
                //System.out.println(count + " - " + currentString);
        
                if (currentString!=null) {                    
                    String toKey = DMS.GetPieceString(currentString, 1, "@");                    
                    String toAction1 = currentString.substring(currentString.indexOf("@")+1, currentString.length()-1).trim();//DMS.GetPieceString(currentString, , );
                    //System.out.println("to key " + toKey + " read action " + toAction1);
                    
                    //TODO - change RATE
                    rangetable.AddNewCell(toKey, new RangeCell(toKey, new ActionCell(toAction1, 100)));
                }
            }
            scanner.close();
            return rangetable;

        } catch (Exception e) {            
            System.out.println("Exeption " + e.getLocalizedMessage());
            return new RangeTable(0,0,0,"error",Position.ERROR);
        }

        //
    }    
}
