package com.pretraga.Pretraga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pretraga.Pretraga.model.RezervisaniDatumi;
import com.pretraga.Pretraga.repository.RezervisaniDatumiRepository;

@Service
public class RezervisaniDatumiServiceImpl implements RezervisaniDatumiService {

	@Autowired
	private RezervisaniDatumiRepository repository;
	
	
	@Override
	public void save(RezervisaniDatumi rezDatumi) {
		repository.save(rezDatumi);

	}

}
