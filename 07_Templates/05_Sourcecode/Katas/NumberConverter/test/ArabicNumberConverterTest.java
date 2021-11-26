import org.junit.Assert;
import org.junit.Test;

public class ArabicNumberConverterTest {
    @Test
    public void itShouldReturn1_GivenI(){
        Assert.assertEquals(1,RomanNumberConverter.toArabic("I"));
    }

    @Test
    public void itShouldReturn2_GivenII(){
        Assert.assertEquals(2,RomanNumberConverter.toArabic("II"));
    }

    @Test
    public void itShouldReturn3_GivenIII(){
        Assert.assertEquals(3,RomanNumberConverter.toArabic("III"));
    }

    @Test
    public void itShouldReturn5_GivenV(){
        Assert.assertEquals(5,RomanNumberConverter.toArabic("V"));
    }
<<<<<<< HEAD

    @Test
    public void itShouldReturnNumbersBetween6and8(){
        Assert.assertEquals(6,RomanNumberConverter.toArabic("VI"));
        Assert.assertEquals(7,RomanNumberConverter.toArabic("VII"));
        Assert.assertEquals(8,RomanNumberConverter.toArabic("VII"));
=======
    @Test
    public void itShouldReturn1794_GivenMDCCXCIV(){
        Assert.assertEquals(1794,RomanNumberConverter.toArabic("MDCCXCIV"));
    }
    @Test
    public void itShouldReturn1000_GivenM(){
        Assert.assertEquals(1000,RomanNumberConverter.toArabic("M"));
    }
    @Test
    public void itShouldReturn1978_GivenXIXDCCLXXXIV(){
        Assert.assertEquals(1978,RomanNumberConverter.toArabic("MCMLXXVIII"));
>>>>>>> ba5c893aa7d260309a8b2c22aaff3e5442439d30
    }
}
