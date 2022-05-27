package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "monhoc")
public class MonHocEntity {
	@Id
	@Column(name = "ma_mon_hoc" , nullable=false)
	private String ma_mon_hoc;
	
	@Column(name = "ten", nullable=false)
	private String ten;
	
	@ManyToOne
	@JoinColumn(name = "ma_khoa" )
	private KhoaEntity ma_khoa;
	
	public MonHocEntity() {

	}

	public MonHocEntity(String ma_mon_hoc, String ten ,KhoaEntity ma_khoa) {
		this.ma_mon_hoc = ma_mon_hoc;
		this.ten = ten;
		this.ma_khoa = ma_khoa;
	}

	public String getMa_mon_hoc() {
		return ma_mon_hoc;
	}

	public void setMa_mon_hoc(String ma_mon_hoc) {
		this.ma_mon_hoc = ma_mon_hoc;
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
