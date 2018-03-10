package com.mircoservice.nameservice.web;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

	private static final List<String> NAMES = Arrays.asList(new String[] { "Abdul Hafeez", "Abdul Sattar",
			"Muhammed Taha", "Muhammed Talha", "Muhammed Umer", "Muhammed Umair", "Muhammed Haris" });

	@RequestMapping(method = RequestMethod.GET, path = "/name")
	public String getName() {
		return NAMES.get(new Random().nextInt(NAMES.size() - 1));
	}
}
