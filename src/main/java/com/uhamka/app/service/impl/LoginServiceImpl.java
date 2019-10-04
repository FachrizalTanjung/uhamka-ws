package com.uhamka.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhamka.app.dao.DosenDao;
import com.uhamka.app.dao.MahasiswaDao;
import com.uhamka.app.dto.VoLogin;
import com.uhamka.app.model.Dosen;
import com.uhamka.app.model.Mahasiswa;
import com.uhamka.app.service.LoginService;

@Service
@Transactional(readOnly = true)
public class LoginServiceImpl implements LoginService {

	@Autowired
	private DosenDao dosenDao;
	@Autowired
	private MahasiswaDao mahasiswaDao;

	@Override
	public VoLogin getLoginByID(String id) {
		VoLogin res = new VoLogin();
		Mahasiswa mhs = mahasiswaDao.findOne(Integer.valueOf(id));
		if (mhs != null) {
			res.setId(String.valueOf(mhs.getNim()));
			res.setNama(mhs.getNama());
			res.setType("MHS");
		} else {
			Dosen dsn = dosenDao.findOne(id);
			if (dsn != null) {
				res.setId(dsn.getNidn());
				res.setNama(dsn.getNama());
				res.setType("DSN");
			} else {
				return null;
			}
		}
		return res;
	}

}
