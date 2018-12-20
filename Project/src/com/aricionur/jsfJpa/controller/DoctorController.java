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
	
	DAO dao;
	Doctor doctorAdd;
	List<Doctor> doctorList;
	
	@PostConstruct
	public void init() {
		dao = new DAO();
		this.doctorAdd = new Doctor();
		this.doctorList = dao.getAllDoctors();
	}
	
	public String save(){
		System.out.println("\n-----------running doctor save---------\n");
		System.out.println(doctorAdd.getName() + " kullanýcýsý kaydediliyor..");
//		dao = new DAO();
		dao.insert(doctorAdd);
		// to refresh docorAdd object otherwise doing update onto last data written to database with same id number
		// hibernate does not create new id number for persist so enitity manager is doing 
		doctorAdd = new Doctor();
		
		
		doctorList = dao.getAllDoctors();
		return "doctorView.xhtml?faces-redirect=true";
		
		
	}

	public Doctor getDoctorAdd() {
		return doctorAdd;
	}

	public void setDoctorAdd(Doctor doctorAdd) {
		this.doctorAdd = doctorAdd;
	}

	public List<Doctor> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}
	
	
}
