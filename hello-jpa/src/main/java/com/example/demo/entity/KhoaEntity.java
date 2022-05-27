package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khoa")
public class KhoaEntity {
	
	@Id
	@Column(name="ma_khoa", nullable=false)
	private String ma_khoa;
	
	@Column(name="ten_khoa", nullable=false)
	private String ten_khoa;
	public KhoaEntity() {
		
	}
	public KhoaEntity(String ma_khoa , String ten_khoa) {
		this.ma_khoa = ma_khoa;
		this.ten_khoa = ten_khoa;
	}
	public String getMa_khoa() {
		return ma_khoa;
	}
	public String getTen_khoa() {
		return ten_khoa;
	}
	public void setMa_khoa(String ma_khoa) {
		this.ma_khoa = ma_khoa;
	}
	public void setTen_khoa(String ten_khoa) {
		this.ten_khoa = ten_khoa;
	}
}
