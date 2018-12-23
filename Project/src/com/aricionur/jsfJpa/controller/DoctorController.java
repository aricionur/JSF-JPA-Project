package com.aricionur.jsfJpa.controller;

import java.util.ArrayList;
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
	
	String selectedHospitalName;
	List<String> hospitalNameList = new ArrayList<>();
	Hospital selectedHospital;
	List<Hospital> hospitalList;
	
	@PostConstruct
	public void init() {
		dao = new DAO();
		this.doctorAdd = new Doctor();
		this.doctorList = dao.getAllDoctors();
		this.hospitalList = dao.getAllHospitals();
		createHospitalNameList();
	}
	
	public void createHospitalNameList() {

		for (Hospital hospital : this.hospitalList) {
			this.hospitalNameList.add(hospital.getName());
		}
	}
	
	public String save(){
		System.out.println("\n-----------running doctor save---------\n");
		System.out.println(doctorAdd.getName() + " kullanýcýsý kaydediliyor..");

		
		dao.insert(doctorAdd);
		setHospitalPatientList();
		// to refresh docorAdd object otherwise doing update onto last data written to database with same id number
		// hibernate does not create new id number for persist so enitity manager is doing 
		doctorAdd = new Doctor();		
		
		doctorList = dao.getAllDoctors();
		return "doctorView.xhtml?faces-redirect=true";
		
		
	}

	public void setHospitalPatientList() {
		for (Hospital eachHospital : getHospitalList()) {
			if (getSelectedHospitalName().equals(eachHospital.getName())) {
				System.out.println("\n\n selected hospital is : " + eachHospital.getName());

				List<Doctor> tempDoctorList = eachHospital.getDoctorList();
				tempDoctorList.add(doctorAdd);
				eachHospital.setDoctorList(tempDoctorList);
				dao.insert(eachHospital);
			}
		}

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
	
	public void setHospitalList(List<Hospital> hospitalList) {
		this.hospitalList = hospitalList;
	}
	public List<Hospital> getHospitalList() {
		return hospitalList;
	}
	public void setHospitalNameList(List<String> hospitalNameList) {
		this.hospitalNameList = hospitalNameList;
	}
	public List<String> getHospitalNameList() {
		return hospitalNameList;
	}
	public void setSelectedHospital(Hospital selectedHospital) {
		this.selectedHospital = selectedHospital;
	}
	public Hospital getSelectedHospital() {
		return selectedHospital;
	}
	public void setSelectedHospitalName(String selectedHospitalName) {
		this.selectedHospitalName = selectedHospitalName;
	}
	public String getSelectedHospitalName() {
		return selectedHospitalName;
	}
		
}
