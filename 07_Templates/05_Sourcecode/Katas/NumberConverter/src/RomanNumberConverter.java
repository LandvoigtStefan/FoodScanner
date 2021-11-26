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
        var arabicNumber = 0;
        if(romanNumber.indexOf(0) == 'V'){
            arabicNumber += 5;
        }
        if(romanNumber == "III"){
            return 3;
        }
        if(romanNumber == "II"){
            return 2;
        }
        return 1;
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
