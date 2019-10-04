package com.uhamka.app.rest;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.DtoResponse;
import com.uhamka.app.dto.VoNilai;
import com.uhamka.app.service.NilaiService;

@Controller
@RequestMapping("/nilai")
public class NilaiRest {

	@Autowired
	private NilaiService nilaiService;

	@RequestMapping(value = "insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public @ResponseBody DtoResponse getLogin(@RequestBody VoNilai vo) {
		return nilaiService.insert(vo);
	}

	@RequestMapping(value = "get-all", method = RequestMethod.GET)
	public @ResponseBody List<VoNilai> getAllNilai() {
		DataTablesResponse<VoNilai> bs = nilaiService.getAllNilai();
		return bs.getData();
	}

}
