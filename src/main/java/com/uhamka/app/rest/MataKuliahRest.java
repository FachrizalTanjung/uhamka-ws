package com.uhamka.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoMataKuliah;
import com.uhamka.app.service.MataKuliahService;

@Controller
@RequestMapping("/mata-kuliah")
public class MataKuliahRest {

	@Autowired
	private MataKuliahService mataKuliahService;

	@RequestMapping(value = "get-all", method = RequestMethod.GET)
	public @ResponseBody List<VoMataKuliah> getAllMataKuliah() {
		DataTablesResponse<VoMataKuliah> mk = mataKuliahService.getAllMataKuliah();
		return mk.getData();
	}

}
