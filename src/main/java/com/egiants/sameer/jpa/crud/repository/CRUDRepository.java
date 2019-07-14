package com.egiants.sameer.jpa.crud.repository;

import com.egiants.sameer.jpa.crud.entity.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRUDRepository extends JpaRepository<Website, Integer> {

}
