package fr.gamedev.stats.controller;

import fr.gamedev.stats.PointCalculator;
import fr.gamedev.stats.fixedSizeCoeficient.FscRule;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FscController {

    static FscRule rule1 = FscRule.fromString( "[Accumulated Points : Fixed step coefficient plus firstTime bonus rounded up (accumulated points)] FSC[(100)(up)(accumulated_points-*)500-2|1000-1.5|2000-1|5000-0.75|10000-0.5|50000-0.25|i-0.01]");
    static FscRule rule2 = FscRule.fromString( "[linear with first Time bonus, rounded up (accumulated_points)] FSC[(500)(up)(accumulated_points-*)i-1]");
    static FscRule rule3 = FscRule.fromString("[(repetition)] FSC[(5)(down)(repetition-*)10-1|50-0.75|100-0.5|i-0.001]");

    @RequestMapping("/stats/fsc")
    public int calculFsc(@RequestParam() int currentPoint, @RequestParam() boolean isFirstTime, @RequestParam() short nbPoints, @RequestParam() String ruleName) throws Exception {

        FscRule finalRule;

        switch (ruleName) {
            case "rule1":
                finalRule = rule1;
                break;
            case "rule2":
                finalRule = rule2;
                break;
            case "rule3":
                finalRule = rule3;
                break;
            default:
                throw new Exception("Rule name doesn't exist");
        }


        return PointCalculator.getInstance().fsc(currentPoint, isFirstTime, nbPoints, finalRule);
    }
}
