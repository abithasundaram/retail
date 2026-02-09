package com.project.retail.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/retail")
public class RetailController {
	
@Value("${message}")	
String message;

@GetMapping("/welcome")
public String getMessage() {
	return message;
}

@GetMapping("/systemdate")
public String getDate() {
	LocalDateTime now = LocalDateTime.now();
	String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	return date;
	
}
}
