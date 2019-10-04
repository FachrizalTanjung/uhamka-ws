package com.uhamka.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoMahasiswa;
import com.uhamka.app.service.MahasiswaService;

@Controller
@RequestMapping("/mahasiswa")
public class MahasiswaRest {

	@Autowired
	private MahasiswaService mahasiswaService;

	@RequestMapping(value = "get-all", method = RequestMethod.GET)
	public @ResponseBody List<VoMahasiswa> getAllMahasiswa() {
		DataTablesResponse<VoMahasiswa> mhs = mahasiswaService.getAllMhs();
		return mhs.getData();
	}

}
