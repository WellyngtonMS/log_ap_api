package com.project_log_ap.log_ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project_log_ap.log_ap.entity.ProcessoEntity;
import com.project_log_ap.log_ap.services.ProcessoService;

@Repository
public interface ProcessoRepository extends JpaRepository<ProcessoEntity, Long> {

    default JpaRepository<ProcessoEntity, Long> getRepository(ProcessoService processoService) {
    	return this;
    }

}
