package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "lop")
public class LopEntity {
	@Id
	@Column(name="ma_lop", nullable=false)
	private String ma_lop;
	
	@ManyToOne
	@JoinColumn(name = "ma_mon_hoc" )
	private MonHocEntity ma_mon_hoc;
	
	@ManyToOne
	@JoinColumn(name = "ma_giang_vien")
	private GiangVienEntity ma_giang_vien;
	
	@Column(name="si_so", nullable=false)
	private int si_so;
	
	public LopEntity() {
		// TODO Auto-generated constructor stub
	}

	

	public LopEntity(String ma_lop, MonHocEntity ma_mon_hoc, GiangVienEntity ma_giang_vien, int si_so) {
		super();
		this.ma_lop = ma_lop;
		this.ma_mon_hoc = ma_mon_hoc;
		this.ma_giang_vien = ma_giang_vien;
		this.si_so = si_so;
	}



	public String getMa_lop() {
		return ma_lop;
	}



	public void setMa_lop(String ma_lop) {
		this.ma_lop = ma_lop;
	}



	public MonHocEntity getMa_mon_hoc() {
		return ma_mon_hoc;
	}



	public void setMa_mon_hoc(MonHocEntity ma_mon_hoc) {
		this.ma_mon_hoc = ma_mon_hoc;
	}



	public GiangVienEntity getMa_giang_vien() {
		return ma_giang_vien;
	}



	public void setMa_giang_vien(GiangVienEntity ma_giang_vien) {
		this.ma_giang_vien = ma_giang_vien;
	}



	public int getSi_so() {
		return si_so;
	}



	public void setSi_so(int si_so) {
		this.si_so = si_so;
	}



	
}
