package ru.demelnikov.fml.hhanalyser.Globals;

public final class DMS {
    public static String GetPieceString(String base, int startIndex, String maskString) {
        
        String tempString = base.substring(startIndex);
        int endIndex = tempString.indexOf(maskString);
        // System.out.println("промежуточная часть: " + tempString);
        // System.out.println("конец строки " + endIndex);
        String result = tempString.substring(0, endIndex).trim();

        return result;

    }

    // public static String PrepareDigit (String base) {
    //     return "";
    // }
}
