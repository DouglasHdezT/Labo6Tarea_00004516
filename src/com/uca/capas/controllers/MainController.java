package com.uca.capas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDao;
import com.uca.capas.domain.Student;

@Controller
public class MainController {
	
	@Autowired
	private StudentDao studentDao;

	@RequestMapping("/")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		
		List<Student> students = null;
		try {
		 students = studentDao.findAll();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("students",students);
		mav.setViewName("main");
		
		return mav;
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public ModelAndView result(@RequestParam Integer id) {
		ModelAndView mav =  new ModelAndView();
		
		Student student =  new Student();
		try {
			student = studentDao.findOne(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(student == null) {
			mav.addObject("message", "Estudiante no encontrado");
		}else {
			mav.addObject("message", "Estudiante encontrado");
		}
		
		mav.addObject("student", student);
		
		mav.setViewName("result");
		
		return mav;
	}
	
}
