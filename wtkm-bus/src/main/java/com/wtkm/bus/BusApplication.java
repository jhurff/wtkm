package com.wtkm.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class BusApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "WTKM Bus and API version 3 of system";
	}

}

