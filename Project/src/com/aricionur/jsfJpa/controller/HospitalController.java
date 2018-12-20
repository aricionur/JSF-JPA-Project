package com.aricionur.jsfJpa.controller;

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
	Hospital currentHospital;
	
	
	@PostConstruct
	public void init() {
		dao = new DAO();
		this.hospitalAdd = new Hospital();//burada hospital ve hospital_patient tablolarýný JPA oluþturacak
		this.hospitalAdd.setId(UUID.randomUUID().toString());
		this.currentHospital = dao.getSingleHospitalById(this.hospitalAdd.getId());
		
	}
	
	public String save(){
		System.out.println("\n--------------------\n");
		System.out.println(hospitalAdd.getName() + "is saving...");
		
		dao.insert(hospitalAdd);
		this.currentHospital = dao.getSingleHospitalById(this.hospitalAdd.getId());
		return "hospitalView.xhtml?faces-redirect=true";
		
		
	}

	public Hospital getHospitalAdd() {
		return hospitalAdd;
	}

	public void setHospitalAdd(Hospital hospitalAdd) {
		this.hospitalAdd = hospitalAdd;
	}

	public Hospital getCurrentHospital() {
		return currentHospital;
	}

	public void setCurrentHospital(Hospital currentHospital) {
		this.currentHospital = currentHospital;
	}
	
	
	
}
