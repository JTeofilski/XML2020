package com.xml.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xml.agent.model.Ocena;

@Repository
public interface OcenaRepository extends JpaRepository<Ocena, Long>{

}
