package com.bootcamp.api.controllers;

import com.bootcamp.api.dto.uf.UfDTO;
import com.bootcamp.api.services.UfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/uf")
public class UfController {

    @Autowired
    private UfService ufService;

    @PostMapping
    public ResponseEntity<UfDTO> insert(@RequestBody UfDTO ufDTO){
        ufDTO = ufService.insert(ufDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(ufDTO.getCodigoUF())
                .toUri();
        return ResponseEntity.created(location).body(ufDTO);
    }

}
