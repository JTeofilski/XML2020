package com.adminservis.AdminServis.service;

import java.util.List;

import com.adminservis.AdminServis.model.TipMenjaca;
import com.adminservis.AdminServis.model.TipMenjaca;

public interface MenjacService {

    TipMenjaca findOne(Long id);
	
	TipMenjaca delete(Long id);
	
	TipMenjaca save(TipMenjaca menjac);
	
	List<TipMenjaca> findAll();
}
