package com.adminservis.AdminServis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adminservis.AdminServis.model.TKorisnik;


//Kao prvi argument navodi ime Modela, kao drugi argument tip njegovog primarnog kljuca
public interface AdminServisRepository extends JpaRepository<TKorisnik, Long> {


    TKorisnik findById(long id);
}
