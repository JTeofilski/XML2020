package com.xml.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xml.agent.model.Izvestaj;

@Repository
public interface IzvestajRepository extends JpaRepository<Izvestaj, Long>{

}
