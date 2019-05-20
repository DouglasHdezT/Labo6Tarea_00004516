package com.uca.capas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping("/student")
	public ModelAndView insertStudentView(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("add_edit_layout");
		
		Student student = null;
		
		if(id == 0) {
			mav.addObject("message", "Nuevo estudiante");
			student =  new Student();
		}else {
			try {
				mav.addObject("message", "Estudiante encontrado ");
				student = studentDao.findOne(id);
			} catch (Exception e) {
				e.printStackTrace();
				
				mav.addObject("message", "Estudiante no encontrado");
				student = new Student();
			}
		}
		
		mav.addObject("student", student);
		
		return mav;
		
	}
	
	@RequestMapping(value = "/studentInsert", method = RequestMethod.POST)
	public ModelAndView insertStudent(@ModelAttribute Student student) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("result");
		
		try {
			mav.addObject("message", "Agregado correctamente");
			if (student.getcStudent() == null) studentDao.save(student,1);
			else studentDao.save(student,0);
			
		} catch (Exception e) {
			mav.addObject("message", "No se pudo agregar");
		}
		
		mav.addObject("student", student);
		
		return mav;
	}
	
	@RequestMapping("/deletestudent")
	public ModelAndView deleteStudent(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("result");
		
		Student student = null;
		
		if(id == 0) {
			student =  new Student();
		}else {
			try {
				student = studentDao.findOne(id);
			} catch (Exception e) {
				e.printStackTrace();
				student = new Student();
			}
		}
		
		mav.addObject("student", student);
		
		try {
			mav.addObject("message", "Registro eliminado");
			studentDao.delete(student);
		} catch (Exception e) {
			mav.addObject("message", "Registro no eliminado");
		}
		
		return mav;
	}
}
