package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "giangvien")
public class GiangVienEntity {
	@Id
	@Column(name = "ma_giang_vien" , nullable=false)
	private String ma_giang_vien;
	
	@Column(name = "ten" , nullable=false)
	private String ten;
	
	@ManyToOne
	@JoinColumn(name = "ma_khoa")
	private KhoaEntity ma_khoa;
	
	public GiangVienEntity() {
		// TODO Auto-generated constructor stub
	}
	public GiangVienEntity(String ma_giang_vien , String ten , KhoaEntity ma_khoa) {
		this.ma_giang_vien = ma_giang_vien;
		this.ten = ten;
		this.ma_khoa = ma_khoa;
	}
	public String getMa_giang_vien() {
		return ma_giang_vien;
	}
	public void setMa_giang_vien(String ma_giang_vien) {
		this.ma_giang_vien = ma_giang_vien;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public KhoaEntity getMa_khoa() {
		return ma_khoa;
	}
	public void setMa_khoa(KhoaEntity ma_khoa) {
		this.ma_khoa = ma_khoa;
	}
	
	
}
