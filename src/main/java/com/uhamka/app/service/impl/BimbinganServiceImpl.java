package com.uhamka.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhamka.app.dao.BimbinganDao;
import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoBimbinganSkripsi;
import com.uhamka.app.model.BimbinganSkripsi;
import com.uhamka.app.service.BimbinganService;

@Service
@Transactional(readOnly = true)
public class BimbinganServiceImpl implements BimbinganService {

	@Autowired
	private BimbinganDao bimbinganDao;

	@Override
	public DataTablesResponse<VoBimbinganSkripsi> getAllBimbingan() {
		DataTablesResponse<VoBimbinganSkripsi> response = new DataTablesResponse<>();
		List<VoBimbinganSkripsi> listBs = new ArrayList<>();
		List<BimbinganSkripsi> results = (List<BimbinganSkripsi>) bimbinganDao.findAll();
		for (BimbinganSkripsi bs : results) {
			VoBimbinganSkripsi vo = new VoBimbinganSkripsi();

			vo.setNama(bs.getMahasiswa().getNama());
			vo.setNim(String.valueOf(bs.getNim()));
			vo.setJudul(bs.getJudul());
			vo.setPembimbing(bs.getDosen().getNama());
			vo.setTanggal(bs.getTanggal());
			vo.setKeterangan(bs.getKeterangan());

			listBs.add(vo);
		}

		response.setData(listBs);
		return response;
	}

}
