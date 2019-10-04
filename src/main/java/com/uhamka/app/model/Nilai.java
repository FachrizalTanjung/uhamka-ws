package com.uhamka.app.model;
// Generated Sep 15, 2019 7:31:18 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Nilai generated by hbm2java
 */
@Entity
@Table(name = "nilai", catalog = "sistem_informasi")
public class Nilai implements java.io.Serializable {

	private NilaiId id;
	private Mahasiswa mahasiswa;
	private Matkul matkul;
	private Integer tugas;
	private Integer kuis;
	private Integer uts;
	private Integer uas;

	public Nilai() {
	}

	public Nilai(NilaiId id, Mahasiswa mahasiswa, Matkul matkul) {
		this.id = id;
		this.mahasiswa = mahasiswa;
		this.matkul = matkul;
	}

	public Nilai(NilaiId id, Mahasiswa mahasiswa, Matkul matkul, Integer tugas, Integer kuis, Integer uts,
			Integer uas) {
		this.id = id;
		this.mahasiswa = mahasiswa;
		this.matkul = matkul;
		this.tugas = tugas;
		this.kuis = kuis;
		this.uts = uts;
		this.uas = uas;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "nim", column = @Column(name = "Nim", nullable = false)),
			@AttributeOverride(name = "idMatkul", column = @Column(name = "ID_MATKUL", nullable = false, length = 15)) })
	public NilaiId getId() {
		return this.id;
	}

	public void setId(NilaiId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Nim", nullable = false, insertable = false, updatable = false)
	public Mahasiswa getMahasiswa() {
		return this.mahasiswa;
	}

	public void setMahasiswa(Mahasiswa mahasiswa) {
		this.mahasiswa = mahasiswa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MATKUL", nullable = false, insertable = false, updatable = false)
	public Matkul getMatkul() {
		return this.matkul;
	}

	public void setMatkul(Matkul matkul) {
		this.matkul = matkul;
	}

	@Column(name = "TUGAS")
	public Integer getTugas() {
		return this.tugas;
	}

	public void setTugas(Integer tugas) {
		this.tugas = tugas;
	}

	@Column(name = "KUIS")
	public Integer getKuis() {
		return this.kuis;
	}

	public void setKuis(Integer kuis) {
		this.kuis = kuis;
	}

	@Column(name = "UTS")
	public Integer getUts() {
		return this.uts;
	}

	public void setUts(Integer uts) {
		this.uts = uts;
	}

	@Column(name = "UAS")
	public Integer getUas() {
		return this.uas;
	}

	public void setUas(Integer uas) {
		this.uas = uas;
	}

}
