package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.SinhVienEntity;
import com.example.demo.repository.SinhVienRePository;

@Controller
@RequestMapping("/sinhvien")
public class SinhVienController {
	private final SinhVienRePository repo;

	@Autowired
	public SinhVienController(SinhVienRePository repo) {
		this.repo = repo;
	}
	@GetMapping
	public String showSinhVien(Model model) {
		
		model.addAttribute("values", repo.getAllSinhVienEntities());
		return "sinhvien";
	}
	@GetMapping("/search")
	public String search(@Param("keyword") String keyword, Model model) {
		List<SinhVienEntity> lnv = repo.getAllSinhVienEntities();
		List<SinhVienEntity> result = new ArrayList<SinhVienEntity>();
		for(SinhVienEntity nv : lnv) {
			if(nv.getTen().toLowerCase().contains(keyword.toLowerCase())) {
				result.add(nv);
			}
		}
		model.addAttribute("values", result);
		return "sinhvien";
	}
	@GetMapping("/themsinhvien")
	public String showFormAddSinhVien(Model model) {
		model.addAttribute("sinhvien", new SinhVienEntity());
		return "themsinhvien";
	}
	
	@PostMapping("/themsinhvien")
	public String addSinhVien(SinhVienEntity sve) {
		
		// Save the taco design...
		// We'll do this in later
		repo.insertSinhVienEntity(sve.getMa_sinh_vien(), sve.getTen(), sve.getMa_khoa(),sve.getQq(),sve.getNam_sinh());
		return "redirect:/sinhvien";
	}
	
	
	@GetMapping("/xoasinhvien/{ma_sinh_vien}")
    public String showFormDeleteSinhVien(@PathVariable(name="ma_sinh_vien") String ma_sinh_vien,Model model) {
        SinhVienEntity sv = repo.findSinhVienEntityByID(ma_sinh_vien).get(0);
        model.addAttribute("sinhvien",sv);
        return "xoasinhvien";
    }
	@PostMapping("/xoasinhvien/{ma_sinh_vien}")
    public  String deleteSinhVien(@PathVariable(name="ma_sinh_vien") String ma_sinh_vien) {
        repo.deleteById(ma_sinh_vien);
        return "redirect:/sinhvien";
    }
	@GetMapping("/suasinhvien/{ma_sinh_vien}")
	public String showFormEditSinhVien(@PathVariable(name = "ma_sinh_vien") String ma_sinh_vien ,Model model) {
		SinhVienEntity sve = repo.findSinhVienEntityByID(ma_sinh_vien).get(0);
		model.addAttribute("sinhvien", sve);
		return "suasinhvien";
	}
	
	@PostMapping("/suasinhvien/{ma_sinh_vien}")	
	public String editSinhVien(SinhVienEntity sve) {
		
		// Save the taco design...
		// We'll do this in later
		repo.updateSinhVienEntity(sve.getMa_sinh_vien(), sve.getTen(), sve.getMa_khoa(),sve.getQq(),sve.getNam_sinh());
		return "redirect:/sinhvien";
	}
}

