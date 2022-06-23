package fr.gamedev.stats;

import fr.gamedev.stats.fixedSizeCoeficient.FscRule;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.gamedev.stats.fixedSizeCoeficient.FscRule;

public class PointCalculatorTest extends TestCase {

    PointCalculator pc;

    @Test
    public void testLinearFscFirstTime(){
    	 pc = PointCalculator.getInstance();
    	int dataSource = 0;
    	FscRule rules = FscRule.fromString("[linear with first Time bonus, rounded up (accumulated_points)] FSC[(500)(up)(accumulated_points-*)i-1]");
    	assertEquals(510, pc.fsc(dataSource, true, (short) 10, rules));
    }

    @Test
    public void testLinearFscFirstTimeWithValue(){
    	 pc = PointCalculator.getInstance();
    	int dataSource = 1000;
    	FscRule rules = FscRule.fromString("[linear with first Time bonus, rounded up (accumulated_points)] FSC[(500)(up)(accumulated_points-*)i-1]");
    	assertEquals(510, pc.fsc(dataSource, true, (short) 10, rules));
    }

    @Test
    public void testLinearFscWithValue(){
    	 pc = PointCalculator.getInstance();
    	int dataSource = 1000000;
    	FscRule rules = FscRule.fromString("[linear with first Time bonus, rounded up (accumulated_points)] FSC[(500)(up)(accumulated_points-*)i-1]");
    	assertEquals(10, pc.fsc(dataSource, false, (short) 10, rules));
    }


    public void testRepetitionFscFistTime(){
        pc = PointCalculator.getInstance();
        FscRule rule = FscRule.fromString("[(repetition)] FSC[(5)(down)(repetition-*)10-1|50-0.75|100-0.5|i-0.001]");

        int expect_rst = 55;
        int result = pc.fsc(0, true, (short)50, rule);
        assertEquals(expect_rst, result);
    }

    public void testRepetitionFscSecondTime(){
        pc = PointCalculator.getInstance();
        FscRule rule = FscRule.fromString("[(repetition)] FSC[(5)(down)(repetition-*)10-1|50-0.75|100-0.5|i-0.001]");

        int expect_rst = 50;
        int result = pc.fsc(1, false, (short)50, rule);
        assertEquals(expect_rst, result);
    }

    public void testRepetitionFscHundredTime(){
        pc = PointCalculator.getInstance();
        FscRule rule = FscRule.fromString("[(repetition)] FSC[(5)(down)(repetition-*)10-1|50-0.75|100-0.5|i-0.001]");

        int expect_rst = 25;
        int result = pc.fsc(99, false, (short)50, rule);
        assertEquals(expect_rst, result);
    }

    public void testRepetitionFscTwoHundredFiftyTime(){
        pc = PointCalculator.getInstance();
        FscRule rule = FscRule.fromString("[(repetition)] FSC[(5)(down)(repetition-*)10-1|50-0.75|100-0.5|i-0.001]");

        int expect_rst = 0;
        int result = pc.fsc(249, false, (short)50, rule);
        assertEquals(expect_rst, result);
    }

    public void testLinearFsc(){
    }
}