package com.bootcamp.api.repositories;

import com.bootcamp.api.entities.Uf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UfRepository extends JpaRepository<Uf, Long> {
}
