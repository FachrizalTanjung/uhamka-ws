package com.uhamka.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhamka.app.dao.MatkulDao;
import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoMatkul;
import com.uhamka.app.model.Matkul;
import com.uhamka.app.service.MatkulService;

@Service
@Transactional(readOnly = true)
public class MatkulServiceImpl implements MatkulService {

	@Autowired
	private MatkulDao matkulDao;

	@Override
	public DataTablesResponse<VoMatkul> getAllMatkul() {
		DataTablesResponse<VoMatkul> response = new DataTablesResponse<>();
		List<VoMatkul> listMk = new ArrayList<>();
		List<Matkul> results = (List<Matkul>) matkulDao.findAll();
		for (Matkul mk : results) {
			VoMatkul vo = new VoMatkul();

			vo.setIdMatkul(mk.getIdMatkul());
			vo.setNamaMatkul(mk.getNamaMatkul());

			listMk.add(vo);
		}

		response.setData(listMk);
		return response;
	}

}
