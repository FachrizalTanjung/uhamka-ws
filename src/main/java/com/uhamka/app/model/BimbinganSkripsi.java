package com.uhamka.app.model;
// Generated Sep 15, 2019 7:31:18 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * BimbinganSkripsi generated by hbm2java
 */
@Entity
@Table(name = "bimbingan_skripsi", catalog = "sistem_informasi")
public class BimbinganSkripsi implements java.io.Serializable {

	private int nim;
	private Dosen dosen;
	private Mahasiswa mahasiswa;
	private String judul;
	private String tanggal;
	private String keterangan;

	public BimbinganSkripsi() {
	}

	public BimbinganSkripsi(Dosen dosen, Mahasiswa mahasiswa, String judul, String tanggal, String keterangan) {
		this.dosen = dosen;
		this.mahasiswa = mahasiswa;
		this.judul = judul;
		this.tanggal = tanggal;
		this.keterangan = keterangan;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "mahasiswa"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "Nim", unique = true, nullable = false)
	public int getNim() {
		return this.nim;
	}

	public void setNim(int nim) {
		this.nim = nim;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NIDN", nullable = false)
	public Dosen getDosen() {
		return this.dosen;
	}

	public void setDosen(Dosen dosen) {
		this.dosen = dosen;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Mahasiswa getMahasiswa() {
		return this.mahasiswa;
	}

	public void setMahasiswa(Mahasiswa mahasiswa) {
		this.mahasiswa = mahasiswa;
	}

	@Column(name = "Judul", nullable = false, length = 100)
	public String getJudul() {
		return this.judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	@Column(name = "Tanggal", nullable = false, length = 20)
	public String getTanggal() {
		return this.tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	@Column(name = "Keterangan", nullable = false, length = 100)
	public String getKeterangan() {
		return this.keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

}
