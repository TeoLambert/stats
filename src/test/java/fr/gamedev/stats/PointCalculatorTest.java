package fr.gamedev.stats;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.gamedev.stats.fixedSizeCoeficient.FscRule;

import java.awt.*;

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
    
    
}