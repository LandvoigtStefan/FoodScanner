public class RomanNumberConverter {
    public RomanNumberConverter(){

    }
    public static String toRoman(int number){
        var romanNumber = "";
        for(var numeral : Numeral.values()){
            while(number >= numeral.mArabic){
                romanNumber += numeral.mRoman;
                number -= numeral.mArabic;
            }
        }

        return romanNumber;
    }

    public static int toArabic(String romanNumber){
        int number;
        return 0;
    }

    enum Numeral{
        ONETHUUSAND(1000,"M"),
        NINEHUNDRED(900, "CM"),
        FIVEHUNDRED(500, "D"),
        FOURHUNDRED(400, "CD"),
        ONEHUNDRED(100, "C"),
        NINETY(90, "XC"),
        FIFTY(50, "L"),
        FORTY(40, "XL"),
        TEN(10,"X"),
        NINE(9,"IX"),
        FIVE(5,"V"),
        FOUR(4,"IV"),
        ONE(1,"I");

        private final int mArabic;
        private final String mRoman;

        Numeral(int arabic, String roman) {
            mArabic = arabic;
            mRoman = roman;
        }
    }
}
