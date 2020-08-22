package com.adminservis.AdminServis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adminservis.AdminServis.model.Administrator;


//Kao prvi argument navodi ime Modela, kao drugi argument tip njegovog primarnog kljuca
public interface AdminServisRepository extends JpaRepository<Administrator, Long> {


}
