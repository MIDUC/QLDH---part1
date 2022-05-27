package com.example.demo.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbldiem")
public class DiemEntity implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ma_diem")
	private int ma_diem;

	@ManyToOne
	@JoinColumn(name = "ma_thanh_vien" )
	private ThanhVienEntity ma_thanh_vien;
	
	
	@Column(name = "diem_tk" , nullable=false)
	private float diem_tk;
	public DiemEntity() {
	}
	public DiemEntity(ThanhVienEntity ma_thanh_vien, float diem_tk) {
		super();
		this.ma_thanh_vien = ma_thanh_vien;
		this.diem_tk = diem_tk;
	}
	public ThanhVienEntity getMa_thanh_vien() {
		return ma_thanh_vien;
	}
	public void setMa_thanh_vien(ThanhVienEntity ma_thanh_vien) {
		this.ma_thanh_vien = ma_thanh_vien;
	}
	public float getDiem_tk() {
		return diem_tk;
	}
	public void setDiem_tk(float diem_tk) {
		this.diem_tk = diem_tk;
	}
	
	
}
