package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.GiangVienEntity;
import com.example.demo.repository.GiangVienRePository;

@Controller
@RequestMapping("/giangvien")

public class GiangVienController {
	private final GiangVienRePository repo;
	
	public GiangVienController(GiangVienRePository repo) {
		this.repo = repo;
	}
	@GetMapping
	public String showDesignForm(Model model) {
		List <GiangVienEntity> result= repo.getAllGiangVienEntities();
		model.addAttribute("values", result);
		return "giangvien";
	}
	@GetMapping("/search")
	public String search(@Param("keyword") String keyword, Model model) {
		List<GiangVienEntity> lnv = repo.getAllGiangVienEntities();
		List<GiangVienEntity> result = new ArrayList<GiangVienEntity>();
		for(GiangVienEntity nv : lnv) {
			if(nv.getTen().toLowerCase().contains(keyword.toLowerCase())) {
				result.add(nv);
			}
		}
		model.addAttribute("values", result);
		return "giangvien";
	}
	
	@GetMapping("/themgiangvien")
	public String showFormAddGiangVien(Model model) {
		model.addAttribute("giangvien", new GiangVienEntity());
		return "themgiangvien";
	}
	
	

	@PostMapping("/themgiangvien")
	public String addGiangVien(GiangVienEntity gve) {
		
		// Save the taco design...
		// We'll do this in later
		repo.insertGiangVienEntity(gve.getMa_giang_vien(), gve.getTen(), gve.getMa_khoa());
		return "redirect:/giangvien";
	}
	
	@GetMapping("/xoagiangvien/{ma_giang_vien}")
    public String showFormDeleteGiangVien(@PathVariable(name="ma_giang_vien") String ma_giang_vien,Model model) {
        GiangVienEntity gv = repo.findGiangVienEntityByID(ma_giang_vien).get(0);
        model.addAttribute("giangvien",gv);
        return "xoagiangvien";
    }
	@PostMapping("/xoagiangvien/{ma_giang_vien}")
    public  String deleteGiangVien(@PathVariable(name="ma_giang_vien") String ma_giang_vien) {
        repo.deleteById(ma_giang_vien);
        return "redirect:/giangvien";
    }
	
	@PostMapping("/suagiangvien/{ma_giang_vien}")	
	public String editGiangVien(GiangVienEntity gve) {
		
		// Save the taco design...
		// We'll do this in later
		repo.updateGiangVienEntity(gve.getMa_giang_vien(), gve.getTen(), gve.getMa_khoa());
		return "redirect:/giangvien";
	}
	
}
