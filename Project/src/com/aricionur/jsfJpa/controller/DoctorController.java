package com.aricionur.jsfJpa.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.aricionur.jsfJpa.dao.*;
import com.aricionur.jsfJpa.entity.*;

@ManagedBean
@SessionScoped
public class DoctorController {
	
	
	Doctor doctorAdd;
	List<Doctor> doctorList;
	
	@PostConstruct
	public void init() {
		DAO dao = new DAO();
		this.doctorAdd = new Doctor();
		this.doctorList = dao.getAllDoctors();
	}
	
	public String save(){
		DAO dao = new DAO();
		System.out.println("\n--------------------\n");
		System.out.println(doctorAdd.getName() + " kullanýcýsý kaydediliyor..");
		dao.insert(doctorAdd);
		
		
		doctorList = dao.getAllDoctors();
		return "doctorView.xhtml?faces-redirect=true";
		
		
	}
	
	public void setAddDoctor(Doctor addDoctor) {
		this.doctorAdd = addDoctor;
	}
	public Doctor getAddDoctor() {
		return doctorAdd;
	}
	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}
	public List<Doctor> getDoctorList() {
		return doctorList;
	}
}
