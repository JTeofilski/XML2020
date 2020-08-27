package com.pretraga.Pretraga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pretraga.Pretraga.model.RezervisaniDatumi;

@Repository
public interface RezervisaniDatumiRepository extends JpaRepository<RezervisaniDatumi, Long>{

}
