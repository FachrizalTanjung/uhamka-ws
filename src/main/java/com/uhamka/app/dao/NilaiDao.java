package com.uhamka.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.uhamka.app.model.Nilai;
import com.uhamka.app.model.NilaiId;

public interface NilaiDao extends CrudRepository<Nilai, NilaiId> {

}
