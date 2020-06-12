package com.example.postgresqlAPI.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class kisiController {

	private final kisiService kservice;


	@PostMapping
	public ResponseEntity<kisiDto> kaydet(@RequestBody kisiDto dto) {
		return ResponseEntity.ok(kservice.save(dto));
	}
	@GetMapping
	public ResponseEntity<List<kisiDto>> listele()
	{
		return ResponseEntity.ok(kservice.getAll());
	}
	
	
}
