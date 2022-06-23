package fr.gamedev.stats;

import fr.gamedev.stats.fixedSizeCoeficient.FscRule;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.BeforeClass;

import java.awt.*;

public class PointCalculatorTest extends TestCase {

    PointCalculator pc = PointCalculator.getInstance();

    @BeforeClass
    public void beforeClass(){

    }


    // CASE B du readme
     public void testAccumulatedFscFirstTime() {
         FscRule rule = FscRule.fromString("[Fixed step coefficient plus firstTime bonus rounded up (accumulated points)] FSC[(100)(up)(accumulated_points-*)500-2|1000-1.5|2000-1|5000-0.75|10000-0.5|50000-0.25|i-0.01]");
         int expected = 200;
         int result = this.pc.fsc(0, true, (short) 50, rule);
         Assert.assertEquals("Accumulated FSC case B : ", expected, result);
    }


    // Case A du README
    public void testAccumulatedFscNotFirstTime(){

        FscRule rule = FscRule.fromString("[Fixed step coefficient plus firstTime bonus rounded up (accumulated points)] FSC[(100)(up)(accumulated_points-*)500-2|1000-1.5|2000-1|5000-0.75|10000-0.5|50000-0.25|i-0.01]");
        int expected = 38;
        int result = this.pc.fsc(3518, false, (short) 50, rule);
        Assert.assertEquals("Accumulated FSC case A : ", expected, result);
    }


    public void testRepetitionFsc(){
    }


    public void testLinearFsc(){
    }
}