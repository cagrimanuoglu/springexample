package com.example.postgresqlAPI.demo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface kisiService {
	
	
	
	kisiDto save(kisiDto kDto);
	
	void delete(Long id);
	
	List<kisiDto> getAll();
	
	Page<kisiDto>getAll(Pageable pageable);
	

}
