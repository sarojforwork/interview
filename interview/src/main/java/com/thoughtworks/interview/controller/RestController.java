package com.thoughtworks.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.thoughtworks.interview.service.ChallengeService;

@Controller
public class RestController {
	
	@Autowired
	ChallengeService challengeService;
	
    @GetMapping("/challenge")
    @ResponseBody
    public String challenge(@RequestParam(name="stage")Integer stage) {
    	try {
        	challengeService.executeStage(stage);		
		} catch (IllegalArgumentException e) {
			return e.getMessage();
		}
		return "Executed Succcessfully!";    	
    }
    
    @GetMapping("/input")
    @ResponseBody
    public String input() {
		return "Executed Succcessfully!";    	
    }
}
