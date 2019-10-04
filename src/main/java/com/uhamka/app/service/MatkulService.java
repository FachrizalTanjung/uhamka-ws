package com.uhamka.app.service;

import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoMatkul;

public interface MatkulService {

	DataTablesResponse<VoMatkul> getAllMatkul();

}
