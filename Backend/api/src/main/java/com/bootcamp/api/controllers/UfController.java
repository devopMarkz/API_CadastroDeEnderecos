package com.bootcamp.api.controllers;

import com.bootcamp.api.dto.uf.UfDTO;
import com.bootcamp.api.services.UfService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<UfDTO> insert(@Valid @RequestBody UfDTO ufDTO){
        ufDTO = ufService.insert(ufDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(ufDTO.getCodigoUF())
                .toUri();
        return ResponseEntity.created(location).body(ufDTO);
    }

    @GetMapping
    public ResponseEntity<Page<UfDTO>> findAll(@PageableDefault(page = 0, size = 10) Pageable pageable){
        return ResponseEntity.ok(ufService.findAll(pageable));
    }

}
