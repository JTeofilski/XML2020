package com.xml.agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.agent.model.RezervisaniDatumi;
import com.xml.agent.repository.RezervisaniDatumiRepository;

@Service
public class RezervisaniDatumiServiceImpl implements RezervisaniDatumiService {

	@Autowired
	private RezervisaniDatumiRepository repository;
	
	@Override
	public List<RezervisaniDatumi> findByOglasId(long id) {
		
		return repository.findByOglasIdentifikacioniBroj(id);
	}

	@Override
	public void save(RezervisaniDatumi rd) {
		repository.save(rd);
		
	}

}
