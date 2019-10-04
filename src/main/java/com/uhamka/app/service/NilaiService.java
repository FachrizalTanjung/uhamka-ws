package com.uhamka.app.service;

import com.uhamka.app.dto.DataTablesResponse;
import com.uhamka.app.dto.DtoResponse;
import com.uhamka.app.dto.VoNilai;

public interface NilaiService {

	DtoResponse insert(VoNilai vo);

	DataTablesResponse<VoNilai> getAllNilai();

}
