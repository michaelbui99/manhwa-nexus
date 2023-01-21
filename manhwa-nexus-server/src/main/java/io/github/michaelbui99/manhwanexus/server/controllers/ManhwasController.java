package io.github.michaelbui99.manhwanexus.server.controllers;

import io.github.michaelbui99.manhwanexus.core.interfaces.service.ManhwaService;
import io.github.michaelbui99.manhwanexus.core.models.Manhwa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("manhwas")
public class ManhwasController {
    private final Logger logger = LoggerFactory.getLogger(ManhwasController.class);
    private final ManhwaService manhwaService;

    @Autowired
    public ManhwasController(ManhwaService manhwaService) {
        this.manhwaService = manhwaService;
    }

    @GetMapping
    public ResponseEntity<List<Manhwa>> getAll(){
        logger.info("received GET request for /manhwas");
        try {
            return ResponseEntity.ok(manhwaService.getAll());
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
