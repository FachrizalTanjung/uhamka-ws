package com.uhamka.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoBimbinganSkripsi;
import com.uhamka.app.service.BimbinganService;

@Controller
@RequestMapping("/bimbingan")
public class BimbinganRest {

	@Autowired
	private BimbinganService bimbinganService;

	@RequestMapping(value = "get-all", method = RequestMethod.GET)
	public @ResponseBody List<VoBimbinganSkripsi> getAllBimbingan() {
		DataTablesResponse<VoBimbinganSkripsi> bs = bimbinganService.getAllBimbingan();
		return bs.getData();
	}

}
