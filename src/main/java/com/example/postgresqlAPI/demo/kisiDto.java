package com.example.postgresqlAPI.demo;

import java.util.List;

import lombok.Data;

@Data
public class kisiDto {
	
	
	private Long id;
	
	private String adi;
	
	private String soyadi;
	
	private List<String> adresler;
	

}
