package com.uhamka.app.service;

import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoMataKuliah;

public interface MataKuliahService {
	
	DataTablesResponse<VoMataKuliah> getAllMataKuliah();

}
