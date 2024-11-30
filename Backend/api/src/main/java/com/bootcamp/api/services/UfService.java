package com.bootcamp.api.services;

import com.bootcamp.api.dto.uf.UfDTO;
import com.bootcamp.api.entities.Uf;
import com.bootcamp.api.repositories.UfRepository;
import com.bootcamp.api.services.exceptions.InvalidTypeException;
import com.bootcamp.api.services.exceptions.SiglaUfAndNomeUfExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional(readOnly = true)
    public Page<UfDTO> findAll(Pageable pageable){
        Page<UfDTO> ufDTOS = ufRepository.findAll(pageable).map(this::convertUfToUfDTO);
        return ufDTOS;
    }

    private UfDTO convertUfToUfDTO(Uf uf){
        return new UfDTO(uf.getCodigoUF(),
                uf.getSigla(),
                uf.getNome(),
                String.valueOf(uf.getStatus()));
    }

    private Uf convertUfDTOToUf(UfDTO ufDTO){
        try{
            return new Uf(ufDTO.getCodigoUF(),
                    ufDTO.getSigla(),
                    ufDTO.getNome(),
                    Integer.parseInt(ufDTO.getStatus()));
        } catch (NumberFormatException e){
            throw new InvalidTypeException("O campo status possui dados inválidos.");
        }
    }

}
