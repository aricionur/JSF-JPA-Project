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
public class PatientController {

	DAO dao;
	Patient patientAdd;
	List<Patient> patientList;

	String selectedHospitalName;
	List<String> hospitalNameList = new ArrayList<>();
	Hospital selectedHospital;
	List<Hospital> hospitalList;

	@PostConstruct
	public void init() {
		dao = new DAO();
		this.patientAdd = new Patient();
		this.patientList = dao.getAllPatients();
		this.hospitalList = dao.getAllHospitals();
		createHospitalNameList();
	}

	public void createHospitalNameList() {

		for (Hospital hospital : this.hospitalList) {
			this.hospitalNameList.add(hospital.getName());
		}
	}

	public String save() {
		System.out.println("\n------running patient save--------------\n");
		System.out.println(patientAdd.getName() + " hastasi kaydediliyor..");

		

		dao.insert(patientAdd);
		setHospitalPatientList();
		
		patientAdd = new Patient();

		patientList = dao.getAllPatients();
		///// debugging code
		System.out.println("\n\n----------------------------------\n\n");
		System.out.println("SelectOneMenu den set edilen hospital name : " + getSelectedHospitalName());

		return "patientView.xhtml?faces-redirect=true";

	}

	public void setHospitalPatientList() {
		for (Hospital eachHospital : getHospitalList()) {
			if (getSelectedHospitalName().equals(eachHospital.getName())) {
				System.out.println("\n\n selected hospital is : " + eachHospital.getName());

				List<Patient> tempPatientList = eachHospital.getPatientList();
				tempPatientList.add(patientAdd);
				eachHospital.setPatientList(tempPatientList);
				dao.insert(eachHospital);
			}
		}

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
