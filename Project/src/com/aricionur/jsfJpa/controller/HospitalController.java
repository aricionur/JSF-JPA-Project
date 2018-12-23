package com.aricionur.jsfJpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.aricionur.jsfJpa.dao.*;
import com.aricionur.jsfJpa.entity.*;

@ManagedBean
@SessionScoped
public class HospitalController {
	
	DAO dao;
	Hospital hospitalAdd;
//	Hospital currentHospital;
	List<Hospital> hospitalList;
	
	
	
	@PostConstruct
	public void init() {
		dao = new DAO();
		this.hospitalAdd = new Hospital();//burada hospital ve hospital_patient tablolarýný JPA oluþturacak
//		this.hospitalAdd.setId(UUID.randomUUID().toString());  // artýk genereted value ile artacak
//		this.currentHospital = dao.getSingleHospitalById(this.hospitalAdd.getId());
		this.hospitalList = dao.getAllHospitals();
		
	}
	

	public String save(){
		System.out.println("\n\n--------------------------------\n\n");
		System.out.println(hospitalAdd.getName() + "is saving...");
		
		dao.insert(hospitalAdd);
		hospitalAdd= new Hospital();
		
		this.hospitalList = dao.getAllHospitals();
		return "hospitalView.xhtml?faces-redirect=true";
		
		
	}

	public Hospital getHospitalAdd() {
		return hospitalAdd;
	}

	public void setHospitalAdd(Hospital hospitalAdd) {
		this.hospitalAdd = hospitalAdd;
	}

	public void setHospitalList(List<Hospital> hospitalList) {
		this.hospitalList = hospitalList;
	}
	public List<Hospital> getHospitalList() {
		return hospitalList;
	}
	

}
