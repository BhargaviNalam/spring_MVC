package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.user;
import com.example.demo.service.userservice;

@Controller
@RequestMapping("/users")
public class usercontroller {
	@Autowired
	private userservice service;
	@GetMapping
	public String getallusers(Model m) {
		m.addAttribute("user",service.getallusers());
		return "users";
	}
	
	@GetMapping("/add")
	public String adduser(Model m) {
		m.addAttribute("user",new user());
		return "add_user";
	}
	
	@GetMapping("/login")
	public String login(Model m) {
		m.addAttribute("user",new user());
		return "login";
	}
	
	@PostMapping("/save")
	public String saveuser(@ModelAttribute("user") user u) {
		service.saveuser(u);
		return "redirect:/users";
	}
	
	@PostMapping("/update/{id}")
	public String updateuser(@PathVariable("id")long id,@ModelAttribute("user")user u) {
		u.setId(id);
		service.saveuser(u);
		return "redirect:/users";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteuser(@PathVariable("id") long id) {
		service.deleteuser(id);
		return "redirect:/users";
	} 
	
	@GetMapping("/edituser/{id}")
	public String edituser(@PathVariable("id") long id,Model m) {
		m.addAttribute("user",service.getbyid(id));
		return "edituser";
	}
	
	

}
