package com.uhamka.app.service;

import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.VoKegiatanMahasiswa;

public interface KegiatanMahasiswaService {
	
	DataTablesResponse<VoKegiatanMahasiswa> getAllKegiatanMhs();

}
