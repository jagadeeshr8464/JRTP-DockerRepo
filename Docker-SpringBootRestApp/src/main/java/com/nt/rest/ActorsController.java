package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("actor-api")
public class ActorsController {

	@GetMapping("/find/{name}")
	public ResponseEntity<String>  Hello(@PathVariable String name){
		 return new ResponseEntity<String>("Gud mrng "+name, HttpStatus.OK);
	}
}
