package ru.demelnikov.fml.hhanalyser.Globals;

public final class EnumConverter {
    public static Actions StringToAction (String string) {
        switch (string) {
            case "4BA":
                return Actions.C4BA; 
            case "C3B":
                return Actions.C3B;                   
            case "OR":
                return Actions.OR;                
            case "F":            
                return Actions.F; 
                
            default:
                System.out.println("Ошибка конвертации String to Actions вEnumConverter на входе" + string);    
                return Actions.ERROR;                
        }
    }

    public static Position StringToPosition (String string) {          
        string = string.replaceAll("\"", "");
        switch (string) {
            case "BU":
                return Position.BUTTON; 
            case "SB":
                return Position.SB;                   
            case "BB":
                return Position.BB;                
            case "UTG":            
                return Position.UTG; 
            case "UTG+1":            
                return Position.UTG1; 
            case "UTG+2":            
                return Position.UTG2;                 
            case "MP":            
                return Position.MP; 
            case "HJ":            
                return Position.HJ; 
            case "CO":            
                return Position.CO; 
            default:
                System.out.println("Ошибка конвертации String to Position вEnumConverter на входе" + string);                    
                return Position.ERROR;
        }
    }    
}
