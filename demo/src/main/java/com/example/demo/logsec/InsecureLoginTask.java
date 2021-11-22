package com.example.demo.logsec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class InsecureLoginTask {
	//private static final Logger logger = LoggerFactory.getLogger(InsecureLoginTask.class); 
	
	@GetMapping("/insecurelogin/{username}/{password}")
    @ResponseBody
   
    public String completed(@PathVariable(name = "username") String username, @PathVariable(name = "password") String password) {
    	if (username.toString().equals("habib") && password.toString().equals("pass")) {
    		return "success";
    	}
        return "failed";
    }

	@GetMapping("/hi")
	public String hi()
	{
		return "hi";
	}
}
