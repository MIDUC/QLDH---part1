package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "thanhvien")
public class ThanhVienEntity {
	@Id
	@Column(name = "ma_thanh_vien" , nullable=false)
	private String ma_thanh_vien;
	
	@ManyToOne
	@JoinColumn(name = "ma_lop")
	private LopEntity ma_lop;
	
	@ManyToOne
	@JoinColumn(name = "ma_sinh_vien")
	private SinhVienEntity ma_sinh_vien;
	
	public ThanhVienEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public String getMa_thanh_vien() {
		return ma_thanh_vien;
	}

	public void setMa_thanh_vien(String ma_thanh_vien) {
		this.ma_thanh_vien = ma_thanh_vien;
	}

	public ThanhVienEntity(String ma_thanh_vien, LopEntity ma_lop, SinhVienEntity ma_sinh_vien) {
		super();
		this.ma_thanh_vien = ma_thanh_vien;
		this.ma_lop = ma_lop;
		this.ma_sinh_vien = ma_sinh_vien;
	}
	

	public LopEntity getMa_lop() {
		return ma_lop;
	}

	public void setMa_lop(LopEntity ma_lop) {
		this.ma_lop = ma_lop;
	}
	public SinhVienEntity getMa_sinh_vien() {
		return ma_sinh_vien;
	}
	public void setMa_sinh_vien(SinhVienEntity ma_sinh_vien) {
		this.ma_sinh_vien = ma_sinh_vien;
	}
	
	
	
}
