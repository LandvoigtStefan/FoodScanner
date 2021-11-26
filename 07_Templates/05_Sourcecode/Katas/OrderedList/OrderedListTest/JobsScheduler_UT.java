import jdk.jfr.StackTrace;
import org.junit.Assert;
import org.junit.Test;

public class JobsScheduler_UT {
    @Test
    public void shouldReturnA_GivenA(){
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("A");
        //act
        sut.sort();
        //assert
        Assert.assertEquals("A",sut.getList());
    }

    @Test
    public void itShouldReturnAB_GivenAB(){
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("A");
        sut.registerJob("B");
        //act
        sut.sort();
        //assert
        Assert.assertEquals("AB",sut.getList());
    }

    @Test
    public void itShouldReturnABC_GivenABC(){
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("A");
        sut.registerJob("B");
        sut.registerJob("C");
        //act
        sut.sort();
        //assert
        Assert.assertEquals("ABC",sut.getList());
    }

    @Test
    public void itShouldReturnAB_GivenBDependsOnA(){
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("B","A");
        //act
        sut.sort();
        //assert
        Assert.assertEquals("AB",sut.getList());
    }

    @Test
    public void itShouldReturnABC_GivenC_DependsOnB_AndB_DependsOn_A(){
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("B","A");
        sut.registerJob("C","B");
        //act
        sut.sort();
        //assert
        Assert.assertEquals("ABC",sut.getList());
    }

    @Test
    public void itShouldReturnAB_GivenABB(){
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("A");
        sut.registerJob("B");
        sut.registerJob("B");
        //act
        sut.sort();
        //assert
        Assert.assertEquals("AB",sut.getList());
    }

    @Test
    public void itShouldReturnABC_GivenB_DependsOnA_AndC_DependsOn_B(){
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("C","B");
        sut.registerJob("B","A");
        //act
        sut.sort();
        //assert
        Assert.assertEquals("ABC",sut.getList());
    }

    @Test
    public void itShouldReturnBA_GivenBA(){
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("B");
        sut.registerJob("A");
        //act
        sut.sort();
        //assert
        Assert.assertEquals("BA",sut.getList());
    }

}

