package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.entity.ThanhVienEntity;
import com.example.demo.repository.ThanhVienRepository;

@Controller
@RequestMapping("/thanhvien")
public class ThanhVienController {
	private final ThanhVienRepository repo;
	@Autowired
	private ThanhVienController(ThanhVienRepository repo) {
		this.repo = repo;
	}
	@GetMapping
	public String showThanhVien(Model model) {

		model.addAttribute("values", repo.getAllThanhVienEntities());
		return "thanhvien";
	}
	@GetMapping("/search")
	public String search(@Param("keyword") String keyword, Model model) {
		List<ThanhVienEntity> ttv = repo.getAllThanhVienEntities();
		List<ThanhVienEntity> result = new ArrayList<ThanhVienEntity>();
		for(ThanhVienEntity tv : ttv) {
			if(tv.getMa_sinh_vien().getTen().toLowerCase().contains(keyword.toLowerCase())) {
				result.add(tv);
			}
		}
		model.addAttribute("values", result);
		return "thanhvien";
	}
	
	@GetMapping("/dangkylop")
	public String showFormAddThanhVien(Model model) {
		model.addAttribute("thanhvien", new ThanhVienEntity());
		return "dangkylop";
	}
	
	@PostMapping("/dangkylop")
	public String addThanhVien(@Valid ThanhVienEntity sve, Model model) {
		// Save the taco design...
		// We'll do this in later
		if (repo.checkThanhVien(sve.getMa_sinh_vien().getMa_sinh_vien(), sve.getMa_lop().getMa_lop())==null)
		{
			repo.save(sve);
			return "redirect:/thanhvien";
		}
		else
		{
			model.addAttribute("mess", "Khong co ma lop hoac ma sinh vien nay");
			return "dangkylop";
		}
	}
	@GetMapping("/xoathanhvien/{ma_thanh_vien}")
    public String showFormDeleteThanhVien(@PathVariable(name="ma_thanh_vien") String ma_thanh_vien,Model model) {
        ThanhVienEntity sv = repo.findThanhVienEntityByID(ma_thanh_vien).get(0);
        model.addAttribute("thanhvien",sv);
        return "xoathanhvien";
    }
	@PostMapping("/xoathanhvien/{ma_thanh_vien}")
    public  String deleteThanhVien(@PathVariable(name="ma_thanh_vien") String ma_thanh_vien) {
        repo.deleteById(ma_thanh_vien);
        return "redirect:/thanhvien";
    }
	@GetMapping("/suathanhvien/{ma_thanh_vien}")
	public String showFormEditSinhVien(@PathVariable(name = "ma_thanh_vien") String ma_thanh_vien ,Model model) {
		ThanhVienEntity sve = repo.findThanhVienEntityByID(ma_thanh_vien).get(0);
		model.addAttribute("thanhvien", sve);
		return "suathanhvien";
	}
	
	@PostMapping("/suathanhvien/{ma_thanh_vien}")	
	public String editThanhVien(ThanhVienEntity sve) {
		
		// Save the taco design...
		// We'll do this in later
		repo.updateThanhVienEntity(sve.getMa_thanh_vien(), sve.getMa_lop(), sve.getMa_sinh_vien());
		return "redirect:/thanhvien";
	}

}
