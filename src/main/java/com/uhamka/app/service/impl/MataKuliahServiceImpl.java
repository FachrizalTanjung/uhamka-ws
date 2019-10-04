package com.uhamka.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhamka.app.dao.MataKuliahDao;
import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoMataKuliah;
import com.uhamka.app.model.MataKuliah;
import com.uhamka.app.service.MataKuliahService;

@Service
@Transactional(readOnly = true)
public class MataKuliahServiceImpl implements MataKuliahService {

	@Autowired
	private MataKuliahDao mataKuliahDao;

	@Override
	public DataTablesResponse<VoMataKuliah> getAllMataKuliah() {
		DataTablesResponse<VoMataKuliah> response = new DataTablesResponse<>();
		List<VoMataKuliah> listMhs = new ArrayList<>();
		List<MataKuliah> results = (List<MataKuliah>) mataKuliahDao.findAll();
		for (MataKuliah mk : results) {
			VoMataKuliah vo = new VoMataKuliah();

			vo.setIdMatkul(mk.getIdMatkul());
			vo.setJamNgajar(mk.getJamNgajar());
			vo.setNamaDosen(mk.getNamaDosen());
			vo.setMataKuliah(mk.getMataKuliah());
			vo.setRuanganNgajar(mk.getRuanganNgajar());
			vo.setHari(mk.getHari());

			listMhs.add(vo);
		}

		response.setData(listMhs);
		return response;
	}

}
