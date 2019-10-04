package com.uhamka.app.service;

import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoDosen;

public interface DosenService {

	DataTablesResponse<VoDosen> getAllDosen();

}
