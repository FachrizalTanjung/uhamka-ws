package com.uhamka.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhamka.app.dao.KegiatanMahasiswaDao;
import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoKegiatanMahasiswa;
import com.uhamka.app.model.KegiatanMahasiswa;
import com.uhamka.app.service.KegiatanMahasiswaService;

@Service
@Transactional(readOnly = true)
public class KegiatanMahasiswaServiceImpl implements KegiatanMahasiswaService {

	@Autowired
	private KegiatanMahasiswaDao kegiatanMahasiswaDao;

	@Override
	public DataTablesResponse<VoKegiatanMahasiswa> getAllKegiatanMhs() {
		DataTablesResponse<VoKegiatanMahasiswa> response = new DataTablesResponse<>();
		List<VoKegiatanMahasiswa> listKgtn = new ArrayList<>();
		List<KegiatanMahasiswa> results = (List<KegiatanMahasiswa>) kegiatanMahasiswaDao.findAll();
		for (KegiatanMahasiswa kgtn : results) {
			VoKegiatanMahasiswa vo = new VoKegiatanMahasiswa();

			vo.setJenis(kgtn.getJenisKegiatan());
			vo.setDesc(kgtn.getDeskripsi());
			vo.setType(kgtn.getTipeEvent());

			listKgtn.add(vo);
		}

		response.setData(listKgtn);
		return response;
	}

}
