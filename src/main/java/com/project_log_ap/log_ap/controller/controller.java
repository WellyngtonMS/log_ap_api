package com.project_log_ap.log_ap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project_log_ap.log_ap.constraints.ApiMapping;
import com.project_log_ap.log_ap.entity.ProcessoEntity;
import com.project_log_ap.log_ap.services.ProcessoService;

@RestController
@RequestMapping(value = ApiMapping.ROOT)
public class controller {

    @Autowired(required = false)
    private ProcessoService processoService;
    
    @PostMapping(value = "/processo")
    public ResponseEntity<ProcessoEntity> processar(@RequestBody ProcessoEntity entity) {
        this.processoService.processar(entity);
        return ResponseEntity.ok().body(entity);
    }
}
