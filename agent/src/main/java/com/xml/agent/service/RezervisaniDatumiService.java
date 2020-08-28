package com.xml.agent.service;

import java.util.List;

import com.xml.agent.model.RezervisaniDatumi;

public interface RezervisaniDatumiService {

	List<RezervisaniDatumi> findByOglasId(long id);
	
	void save (RezervisaniDatumi rd);
}
