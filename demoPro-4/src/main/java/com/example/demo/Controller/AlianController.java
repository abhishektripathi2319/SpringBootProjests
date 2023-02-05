package com.example.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.Alian;
import com.example.demo.dao.AlianRepository;



@Controller
public class AlianController {
	
	@Autowired
	AlianRepository alianRepository;
	
	
	
	@RequestMapping("/")
	@ResponseBody
	public String name() {
		System.out.println("___________________Alian Controller_______________________________");
		return "Hello Alian";
	}
	@RequestMapping("form")
	public String home() {
		System.out.println("___________________Alian Form Controller_______________________________");
		return "home.jsp";
	}
	    
	@RequestMapping("addAlian")
	public String addAlian(Alian alian) {
		System.out.println("________________________DATA RECEVIED : "+alian.toString()+"_________________________");
		alianRepository.save(alian);
		System.out.println("_____________________ALIAN POST CALLED ______________________________________");
		return "home.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
