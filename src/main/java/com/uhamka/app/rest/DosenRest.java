package com.uhamka.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoDosen;
import com.uhamka.app.service.DosenService;

@Controller
@RequestMapping("/dosen")
public class DosenRest {

	@Autowired
	private DosenService dosenService;

	@RequestMapping(value = "get-all", method = RequestMethod.GET)
	public @ResponseBody List<VoDosen> getAllDosen() {
		DataTablesResponse<VoDosen> dsn = dosenService.getAllDosen();
		return dsn.getData();
	}

}
