package space.bum.c6_ex1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@GetMapping("/test1")
	String test1() {
		return "test1";
	}

	@GetMapping("/test2")
	String test2() {
		return "test2";
	}
	
	@GetMapping("/test3")
	String test3() {
		return "test3";
	}
}
