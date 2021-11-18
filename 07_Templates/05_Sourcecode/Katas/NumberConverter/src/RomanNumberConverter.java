import java.util.HashMap;
import java.util.Map;

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
        Map<Character,Integer> numbersMap = new HashMap<>();
        numbersMap.put('I',1);
        numbersMap.put('V',5);
        numbersMap.put('X',10);
        numbersMap.put('L',50);
        numbersMap.put('C',100);
        numbersMap.put('D',500);
        numbersMap.put('M',1000);

        int result=0;

        for(int i=0;i<romanNumber.length();i++)
        {
            char ch = romanNumber.charAt(i);
            if(i>0 && numbersMap.get(ch) > numbersMap.get(romanNumber.charAt(i-1)))
            {
                result += numbersMap.get(ch) - 2*numbersMap.get(romanNumber.charAt(i-1));
            }
            else
                result += numbersMap.get(ch);
        }
        return result;
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
