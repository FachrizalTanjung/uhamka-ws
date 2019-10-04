package com.uhamka.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhamka.app.dao.MahasiswaDao;
import com.uhamka.app.dao.MatkulDao;
import com.uhamka.app.dao.NilaiDao;
import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.DtoResponse;
import com.uhamka.app.dto.VoNilai;
import com.uhamka.app.model.Nilai;
import com.uhamka.app.model.NilaiId;
import com.uhamka.app.service.NilaiService;
import com.uhamka.app.util.ResponseUtil;

@Service
@Transactional(readOnly = true)
public class NilaiServiceImpl implements NilaiService {

	@Autowired
	private NilaiDao nilaiDao;
	@Autowired
	private MahasiswaDao mahasiswaDao;
	@Autowired
	private MatkulDao matkulDao;

	@Override
	@Transactional(readOnly = false)
	public DtoResponse insert(VoNilai vo) {
		NilaiId nilaiId = new NilaiId();
		nilaiId.setNim(vo.getNim());
		nilaiId.setIdMatkul(vo.getIdMatkul());
		Nilai nilai = new Nilai();
		nilai.setId(nilaiId);
		nilai.setMahasiswa(mahasiswaDao.findOne(vo.getNim()));
		nilai.setMatkul(matkulDao.findOne(vo.getIdMatkul()));
		nilai.setTugas(vo.getTugas());
		nilai.setKuis(vo.getKuis());
		nilai.setUts(vo.getUts());
		nilai.setUas(vo.getUas());
		nilaiDao.save(nilai);
		return ResponseUtil.response(1, "Data berhasil disimpan");
	}

	@Override
	public DataTablesResponse<VoNilai> getAllNilai() {
		DataTablesResponse<VoNilai> response = new DataTablesResponse<>();
		List<VoNilai> listNi = new ArrayList<>();
		List<Nilai> results = (List<Nilai>) nilaiDao.findAll();
		for (Nilai ni : results) {
			VoNilai vo = new VoNilai();

			vo.setNim(ni.getMahasiswa().getNim());
			vo.setIdMatkul(ni.getMatkul().getIdMatkul());
			vo.setTugas(ni.getTugas());
			vo.setKuis(ni.getKuis());
			vo.setUts(ni.getUts());
			vo.setUas(ni.getUas());
			listNi.add(vo);
		}

		response.setData(listNi	);
		return response;
	}

}
