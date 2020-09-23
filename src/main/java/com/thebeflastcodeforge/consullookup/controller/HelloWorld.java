package com.thebeflastcodeforge.consullookup.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



 
@RestController
public class HelloWorld {
     
	private final Logger logger = LoggerFactory.getLogger(HelloWorld.class);
	
    @Autowired
    HelloWorldDelegate helloWorldDelegate;
 
    @RequestMapping(value = "/helloWorldMaster", method = RequestMethod.GET)
    public String getHelloWorldMaster() 
    {
    	logger.debug("/helloWorldMaster called");
        return helloWorldDelegate.callHelloServiceAndGetData();
    }
}
