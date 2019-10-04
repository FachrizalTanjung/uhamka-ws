package com.uhamka.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoKegiatanMahasiswa;
import com.uhamka.app.service.KegiatanMahasiswaService;

@Controller
@RequestMapping("/kegiatan-mahasiswa")
public class KegiatanMahasiswaRest {

	@Autowired
	private KegiatanMahasiswaService kegiatanMahasiswaService;

	@RequestMapping(value = "get-all", method = RequestMethod.GET)
	public @ResponseBody List<VoKegiatanMahasiswa> getAllKegiatan() {
		DataTablesResponse<VoKegiatanMahasiswa> kgtn = kegiatanMahasiswaService.getAllKegiatanMhs();
		return kgtn.getData();
	}

}
