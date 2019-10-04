package com.uhamka.app.service;

import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoMahasiswa;

public interface MahasiswaService {
	
	DataTablesResponse<VoMahasiswa> getAllMhs();

}
