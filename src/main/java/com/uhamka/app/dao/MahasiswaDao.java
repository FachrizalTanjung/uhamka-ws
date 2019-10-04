package com.uhamka.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.uhamka.app.model.Mahasiswa;

public interface MahasiswaDao extends CrudRepository<Mahasiswa, Integer> {

}
