package com.uhamka.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uhamka.app.dto.VoLogin;
import com.uhamka.app.service.LoginService;

@Controller
@RequestMapping
public class LoginRest {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public @ResponseBody VoLogin getLogin(@RequestParam String id) {
		VoLogin res = loginService.getLoginByID(id);
		return res;
	}

}
