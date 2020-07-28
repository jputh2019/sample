package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Juliet on 7/9/20.
 */


@RestController
@RequestMapping("/")
public class CityController {

	@RequestMapping("/connected")
	public String getCityRoute(@RequestParam String origin, @RequestParam String destination) throws IOException {

		System.out.println("Hello, Spring Boot App!");
		File file = ResourceUtils.getFile("classpath:city.txt");

		// File is found
		System.out.println("File Found" + file.exists());

		// Read File Content
		// String content = new String(Files.readAllBytes(file.toPath());
		// System.out.println("content "+content);
		String status = "no";
		final List<String> readAllLines = Files.readAllLines(file.toPath());
		for (String s : readAllLines) {
			if (s != null) {
				String source = s.split(",")[0];
				String dest = s.split(",")[1];
				System.out.println("Source "+source);
				System.out.println("dest "+dest);
				if (origin.equalsIgnoreCase(source) && destination.equalsIgnoreCase(dest)) {
					status = "yes";
					break;
				}
				
			}
		}
		return "Origin : " + origin + "  Destination : " + destination + "||" + status;
	}

}
