package fr.gamedev.stats.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.gamedev.stats.PointCalculator;
import fr.gamedev.stats.fixedSizeCoeficient.FscRule;

@RestController
public class FscControler {
	
	@RequestMapping("/stats/fsc")
	public int calculPointFsc(@RequestParam() int currentPoint, @RequestParam(defaultValue = "false") boolean isFirstTime, @RequestParam() short basePoints,@RequestParam() String ruleConfig) {
		PointCalculator pc = PointCalculator.getInstance();
		FscRule rule
		if(ruleConfig.contains("linear")){
			rule = FscRule.fromString("[linear with first Time bonus, rounded up (accumulated_points)] FSC[(500)(up)(accumulated_points-*)i-1]");
		}
		else if (ruleConfig.contains("repetition")) {
			rule = FscRule.fromString("[(repetition)] FSC[(5)(down)(repetition-*)10-1|50-0.75|100-0.5|i-0.001]");
		}
		else {
			rule = FscRule.fromString("[Fixed step coefficient plus firstTime bonus rounded up (accumulated points)] FSC[(100)(up)(accumulated_points-*)500-2|1000-1.5|2000-1|5000-0.75|10000-0.5|50000-0.25|i-0.01]");
		}
		return pc.fsc(currentPoint, isFirstTime, basePoints, rule);
	}

}
