package com.xml.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xml.agent.model.RezervisaniDatumi;

@Repository
public interface RezervisaniDatumiRepository extends JpaRepository<RezervisaniDatumi, Long>{

	List<RezervisaniDatumi> findByOglasIdentifikacioniBroj(Long id);
}
