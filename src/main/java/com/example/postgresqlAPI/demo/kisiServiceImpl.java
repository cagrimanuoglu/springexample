package com.example.postgresqlAPI.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class kisiServiceImpl implements kisiService {
	
	
	private final kisiRepostory kRepo;
	private final adresRepostory aRepo;
	
	

	@Override
	@Transactional
	public kisiDto save(kisiDto kDto) {
		
		kisi k=new kisi();
		
		k.setAdi(kDto.getAdi());
		k.setSoyadi(kDto.getSoyadi());
		
		final kisi kDb=kRepo.save(k);
		
		List<adres> liste=new ArrayList<>();
		kDto.getAdresler().forEach(item -> {
			
			adres a=new adres();
			a.setAdres(item);
			a.setAdresTip(adres.AdresTip.Diğer);
			a.setAktif(true);
			a.setK(kDb);
			liste.add(a);
		});
		
		aRepo.saveAll(liste);
		
		kDto.setId(kDb.getId());
		
		return kDto;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<kisiDto> getAll() {
		
		
		List<kisi> kisiler=kRepo.findAll();
		List<kisiDto> kdtos=new ArrayList<>();
		
		kisiler.forEach(it->{
			
			kisiDto kdto=new kisiDto();
			kdto.setId(it.getId());
			kdto.setAdi(it.getAdi());
			kdto.setSoyadi(it.getSoyadi());
			kdto.setAdresler(it.getAdresleri().stream().map(adres::getAdres).collect(Collectors.toList()));
			
			kdtos.add(kdto);
		});
		
		
		return kdtos;
	}

	@Override
	public Page<kisiDto> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
