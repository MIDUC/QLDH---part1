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

import com.example.demo.entity.MonHocEntity;
import com.example.demo.repository.MonHocRepository;

@Controller
@RequestMapping("/monhoc")
public class MonHocController {
	private final MonHocRepository repo;

	@Autowired
	public MonHocController(MonHocRepository repo) {
		this.repo = repo;
	}

	@GetMapping
	public String showMonhoc(Model model) {
		
		model.addAttribute("values", repo.getAllmonhocEntities());
		return "monhoc";
	}
	
	@GetMapping("/search")
	public String search(@Param("keyword") String keyword, Model model) {
		List<MonHocEntity> lnv = repo.getAllmonhocEntities();
		List<MonHocEntity> result = new ArrayList<MonHocEntity>();
		for(MonHocEntity nv : lnv) {
			if(nv.getTen().toLowerCase().contains(keyword.toLowerCase())) {
				result.add(nv);
			}
		}
		model.addAttribute("values", result);
		return "monhoc";
	}
	
	@GetMapping("/themmonhoc")
	public String showFormAddmonhoc(Model model) {
		model.addAttribute("monhoc", new MonHocEntity());
		return "themmonhoc";
	}
	
	
	@PostMapping("/themmonhoc")
	public String addmonhoc(MonHocEntity nve) {
		
		// Save the taco design...
		// We'll do this in later
		repo.insertmonhocEntity(nve.getMa_mon_hoc(), nve.getTen(), nve.getMa_khoa());
		return "redirect:/monhoc";
	}
	
	@GetMapping("/delete/{id}")
	public String deletemonhoc(@PathVariable(name = "id") String id) {
		repo.deletemonhocEntity(id);
		return "redirect:/monhoc";
	}
	
	@GetMapping("/edit/{id}")
	public String showFormEditmonhoc(@PathVariable(name = "id") String id ,Model model) {
		MonHocEntity nve = repo.findmonhocEntityByID(id).get(0);
		model.addAttribute("monhoc", nve);
		return "suamonhoc";
	}
	
	@PostMapping("/edit/{id}")	
	public String editmonhoc(MonHocEntity nve) {
		
		// Save the taco design...
		// We'll do this in later
		repo.updatemonhocEntity(nve.getMa_mon_hoc(), nve.getTen(), nve.getMa_khoa());
		return "redirect:/monhoc";
	}
}

