package com.uhamka.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhamka.app.dao.MahasiswaDao;
import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoMahasiswa;
import com.uhamka.app.model.Mahasiswa;
import com.uhamka.app.service.MahasiswaService;

@Service
@Transactional(readOnly = true)
public class MahasiswaServiceImpl implements MahasiswaService {

	@Autowired
	private MahasiswaDao mahasiswaDao;

	@Override
	public DataTablesResponse<VoMahasiswa> getAllMhs() {
		DataTablesResponse<VoMahasiswa> response = new DataTablesResponse<>();
		List<VoMahasiswa> listMhs = new ArrayList<>();
		List<Mahasiswa> results = (List<Mahasiswa>) mahasiswaDao.findAll();
		for (Mahasiswa mhs : results) {
			VoMahasiswa vo = new VoMahasiswa();

			vo.setNim(String.valueOf(mhs.getNim()));
			vo.setNama(mhs.getNama());
			vo.setTempatTglLahir(mhs.getTempatTanggalLahir());
			vo.setAlamat(mhs.getAlamat());
			vo.setAngkatan(mhs.getAngkatan());

			listMhs.add(vo);
		}
	
		response.setData(listMhs);
		return response;
	}

}
