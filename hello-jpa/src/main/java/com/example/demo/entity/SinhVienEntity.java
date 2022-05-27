package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "sinhvien")
public class SinhVienEntity {

	@Id
	@Column(name = "ma_sinh_vien" , nullable=false)
	private String ma_sinh_vien;
	
	@Column(name = "ten" , nullable=false)
	private String ten;
	
	@ManyToOne  
	@JoinColumn(name = "ma_khoa")
	private KhoaEntity ma_khoa;
	
	@Column(name = "qq")
	private String qq;
	
	@Column(name = "nam_sinh")
	private int nam_sinh;
	
	public SinhVienEntity() {
		// TODO Auto-generated constructor stub
	}

	public SinhVienEntity(String ma_sinh_vien, String ten, KhoaEntity ma_khoa, String qq, int nam_sinh) {
		super();
		this.ma_sinh_vien = ma_sinh_vien;
		this.ten = ten;
		this.ma_khoa = ma_khoa;
		this.qq = qq;
		this.nam_sinh = nam_sinh;
	}



	public KhoaEntity getMa_khoa() {
		return ma_khoa;
	}



	public void setMa_khoa(KhoaEntity ma_khoa) {
		this.ma_khoa = ma_khoa;
	}



	public String getMa_sinh_vien() {
		return ma_sinh_vien;
	}

	public void setMa_sinh_vien(String ma_sinh_vien) {
		this.ma_sinh_vien = ma_sinh_vien;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public int getNam_sinh() {
		return nam_sinh;
	}

	public void setNam_sinh(int nam_sinh) {
		this.nam_sinh = nam_sinh;
	}
	
	
	
}
