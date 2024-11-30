package com.bootcamp.api.services;

import com.bootcamp.api.dto.uf.UfDTO;
import com.bootcamp.api.entities.Uf;
import com.bootcamp.api.repositories.UfRepository;
import com.bootcamp.api.services.exceptions.SiglaUfAndNomeUfExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UfService {

    @Autowired
    private UfRepository ufRepository;

    @Transactional
    public UfDTO insert(UfDTO ufDTO){
        try{
            Uf uf = ufRepository.save(convertUfDTOToUf(ufDTO));
            return convertUfToUfDTO(uf);
        } catch (DataIntegrityViolationException e) {
            throw new SiglaUfAndNomeUfExistsException("Erro de integridade referencial. Este estado já possui cadastro no banco de dados.");
        }

    }

    private UfDTO convertUfToUfDTO(Uf uf){
        return new UfDTO(uf.getCodigoUF(), uf.getSigla(), uf.getNome(), uf.getStatus());
    }

    private Uf convertUfDTOToUf(UfDTO ufDTO){
        return new Uf(ufDTO.getCodigoUF(), ufDTO.getSigla(), ufDTO.getNome(), ufDTO.getStatus());
    }

}
