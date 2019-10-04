package com.uhamka.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhamka.app.dao.DosenDao;
import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoDosen;
import com.uhamka.app.model.Dosen;
import com.uhamka.app.service.DosenService;

@Service
@Transactional(readOnly = true)
public class DosenServiceImpl implements DosenService {

	@Autowired
	private DosenDao dosenDao;

	@Override
	public DataTablesResponse<VoDosen> getAllDosen() {
		DataTablesResponse<VoDosen> response = new DataTablesResponse<>();
		List<VoDosen> listDsn = new ArrayList<>();
		List<Dosen> results = (List<Dosen>) dosenDao.findAll();
		for (Dosen dsn : results) {
			VoDosen vo = new VoDosen();

			vo.setNip(dsn.getNidn());
			vo.setNama(dsn.getNama());
			vo.setAlamat(dsn.getAlamat());
			vo.setNoHp(dsn.getNohp());

			listDsn.add(vo);
		}

		response.setData(listDsn);
		return response;
	}

}
