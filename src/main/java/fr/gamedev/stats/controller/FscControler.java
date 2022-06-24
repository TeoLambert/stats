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
    	FscRule rule = FscRule.fromString(ruleConfig);
		return pc.fsc(currentPoint, isFirstTime, basePoints, rule);
	}

}
