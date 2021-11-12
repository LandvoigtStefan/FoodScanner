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

    enum Numeral{
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
