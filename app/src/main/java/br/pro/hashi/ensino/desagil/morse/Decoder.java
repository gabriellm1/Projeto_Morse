package br.pro.hashi.ensino.desagil.morse;

public class Decoder {


    public static String ToEng(String message){

        String[] mCodes={/*Stop*/ "*-*-*- ", /*quotation marks*/ "*-**-* ", /*comma*/ "--**-- ", /*question mark*/ "**--** ", /*parentheses*/"-*--*- ", "-*--*-", /*apostrophe*/ "*----* ", /*exclamation mark*/ "-*-*-- ", /*slash*/ "-**-* ", /*numbers*/ "*---- ", "**--- ", "***-- ", "****- ", "***** ", "-**** ", "--*** ", "---** ", "----* ", "----- ", /*Letters*/ "--** ", "-*-- ", "-**- ", "*--- ", "*--* ", "***- ", "*-- ", "**-* ", "**- ", "-*-* ", "-*** ", "**** ", "*-** ", "*** ", "*-* ", "-** ", "--*- ", "-*- ", "--* ", "*- ", "-* ", "--- ", "** ", "-- ", "- ", "* "};

        String[] chars={".", "\"", ",", "?", "(", ")", "'", "!", "/", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "z", "y", "x", "j", "p", "v", "w", "f", "u", "c", "b", "h", "l", "s", "r", "d", "q", "k", "g", "a", "n", "o", "i", "m", "t", "e"};


        for(int a=0; a<=44; a++){
            message=message.replace(mCodes[a], chars[a]);
        }
        return(message);
    }
}
