package com.uhamka.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoMatkul;
import com.uhamka.app.service.MatkulService;

@Controller
@RequestMapping("/matkul")
public class MatkulRest {

	@Autowired
	private MatkulService matkulService;

	@RequestMapping(value = "get-all", method = RequestMethod.GET)
	public @ResponseBody List<VoMatkul> getAllMatkul() {
		DataTablesResponse<VoMatkul> mk = matkulService.getAllMatkul();
		return mk.getData();
	}

}
