package com.example.demo2.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo2.Entity.Student;
import com.example.demo2.Repository.StudentRepository;


@Controller
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		System.out.println("___________________Welcome Stared __________");
		return "Hello.jsp";
	}
	
	@RequestMapping("form")
	public String form() {
		System.out.println("______Form Called_____");
		return "Form";
	}
	
	
	@RequestMapping("add")
	public String add(Student student) {
		System.out.println("_____________Form Submitted_____________");
		System.out.println("-------Form Data : "+student.toString()+"--------");
		studentRepository.save(student);
		return "Form";
	}
	
	@RequestMapping("view")
	public List<Student> view() {
		 List<Student> student = studentRepository.findAll();
		 System.out.println("___________"+student+"_____________");
		return student;
	}
	
	@RequestMapping("viewById")
	public ModelAndView viewById(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("view");
		List<Student> student1 = studentRepository.findByAge(10); 
		System.out.println("________FInd By Age: "+student1+"________________");
		System.out.println("______Find By Greate than 105"+studentRepository.findByIdGreaterThan(105)+"___________");
		System.out.println("______Find by sorted name : "+studentRepository.findByAgeSortedName(10));
		Student student = studentRepository.findById(id).orElse(new Student());
		modelAndView.addObject(student);
		return modelAndView;
	}
	
	@RequestMapping("viewData")
	@ResponseBody
	public String viewData() {
		return studentRepository.findAll().toString();
	}
	
	@RequestMapping("viewDaa/10")
	@ResponseBody
	public String viewDataByIdyee() {
		return studentRepository.findById(101).toString();
	}
	
	@RequestMapping("viewData/{id}")
	@ResponseBody
	public String viewDataById(@PathVariable("id") int id) {
		System.out.println("__________CALL_________________");
		return studentRepository.findById(id).toString();
	}
	
	@RequestMapping("see")
	@ResponseBody
	public List<Student> show() {
		return studentRepository.findAll();
	}
	
	//Content Negotiation ________________
	// produces specify the response format and restrict by default json response
	//to use produces xml response 
	// add jackson-dataformat-xml dependencies
	@RequestMapping(path = "see/{id}", produces = {"application/xml"})
	@ResponseBody
	public Optional<Student> showById(@PathVariable("id") int id) {
		return studentRepository.findById(id);
	}



}
