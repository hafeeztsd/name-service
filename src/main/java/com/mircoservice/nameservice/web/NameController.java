package com.mircoservice.nameservice.web;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mircoservice.nameservice.config.Properties;

@RestController
public class NameController {

	@Autowired
	Properties properties;
	
	@RequestMapping(method = RequestMethod.GET, path = "/name")
	public String getName() {
		return properties.getNames().get(new Random().nextInt(properties.getNames().size() - 1));
	}
}
