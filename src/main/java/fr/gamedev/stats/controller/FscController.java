package fr.gamedev.stats.controller;

import fr.gamedev.stats.PointCalculator;
import fr.gamedev.stats.fixedSizeCoeficient.FscRule;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FscController {

    static FscRule rule1 = FscRule.fromString( "[Accumulated Points : Fixed step coefficient plus firstTime bonus rounded up (accumulated points)] FSC[(100)(up)(accumulated_points-*)500-2|1000-1.5|2000-1|5000-0.75|10000-0.5|50000-0.25|i-0.01]");
    static FscRule rule2 = FscRule.fromString( "[Test2] FSC[(10000)(up)(accumulated_points-*)500-2|1000-1.5|2000-1|5000-0.75|10000-0.5|50000-0.25|i-0.01]");

    @RequestMapping("/stats/fsc")
    public int calculFsc(@RequestParam() int currentPoint, @RequestParam() boolean isFirstTime, @RequestParam() short nbPoints, @RequestParam() String ruleName) throws Exception {

        FscRule finalRule;

        if(ruleName.equals("rule1"))
            finalRule = rule1;
        else if(ruleName.equals("rule2"))
            finalRule = rule2;
        else
            throw new Exception("Rule name doesn't exist");

        return PointCalculator.getInstance().fsc(currentPoint, isFirstTime, nbPoints, finalRule);
    }
}
