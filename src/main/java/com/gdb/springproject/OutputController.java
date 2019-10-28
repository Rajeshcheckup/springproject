package com.gdb.springproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutputController {
	
	@GetMapping("/outputtest")
	public String output() {
		return "V1.1.5: Manual Approval and Complete Deployment in all Pipeline- SARAVANA!!";
	}

}
