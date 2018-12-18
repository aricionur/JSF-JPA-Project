package com.aricionur.jsfJpa.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.aricionur.jsfJpa.dao.*;
import com.aricionur.jsfJpa.entity.*;


@ManagedBean
@SessionScoped
public class PatientController {
	
	Patient patientAdd;
	List<Patient> patientList;
	
	@PostConstruct
	public void init() {
		DAO dao = new DAO();
		this.patientAdd = new Patient();
		this.patientList = dao.getAllPatients();
	}
	
	public String save(){
		DAO dao = new DAO();
		System.out.println("\n--------------------\n");
		System.out.println(patientAdd.getName() + " hastasi kaydediliyor..");
		dao.insert(patientAdd);
		
		
		patientList = dao.getAllPatients();
		return "patientView.xhtml?faces-redirect=true";
		
		
	}

	public Patient getPatientAdd() {
		return patientAdd;
	}

	public void setPatientAdd(Patient patientAdd) {
		this.patientAdd = patientAdd;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}
	
	
	
}
