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

	String selectedHospitalName;
	List<String> hospitalNameList = new ArrayList<>();
	Hospital selectedHospital;

	List<Patient> patientListOfSelecetedHospital = new ArrayList<>();
	List<Doctor> doctorListOfSelecetedHospital = new ArrayList<>();

	@PostConstruct
	public void init() {
		dao = new DAO();
		this.hospitalAdd = new Hospital();// burada hospital ve hospital_patient tablolarýný JPA oluþturacak
//		this.hospitalAdd.setId(UUID.randomUUID().toString());  // artýk genereted value ile artacak
//		this.currentHospital = dao.getSingleHospitalById(this.hospitalAdd.getId());
		this.hospitalList = dao.getAllHospitals();
		createHospitalNameList();
	}

	public void createHospitalNameList() {

		for (Hospital hospital : this.hospitalList) {
			this.hospitalNameList.add(hospital.getName());
		}
	}

	public String viewSelectedHospitalDoctors() {

		for (Hospital eachHospital : getHospitalList()) {
			if (getSelectedHospitalName().equals(eachHospital.getName())) {
				System.out.println("\n\n selected hospital is : " + eachHospital.getName());

				this.doctorListOfSelecetedHospital = eachHospital.getDoctorList();
				this.patientListOfSelecetedHospital = eachHospital.getPatientList();

			}
		}
		return "hospitalDetailView.xhtml?faces-redirect=true";
	}

	public String save() {
		System.out.println("\n\n--------------------------------\n\n");
		System.out.println(hospitalAdd.getName() + "is saving...");

		dao.insert(hospitalAdd);
		hospitalAdd = new Hospital();

		this.hospitalList = dao.getAllHospitals();

		createHospitalNameList();

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

	public String getSelectedHospitalName() {
		return selectedHospitalName;
	}

	public void setSelectedHospitalName(String selectedHospitalName) {
		this.selectedHospitalName = selectedHospitalName;
	}

	public List<String> getHospitalNameList() {
		return hospitalNameList;
	}

	public void setHospitalNameList(List<String> hospitalNameList) {
		this.hospitalNameList = hospitalNameList;
	}

	public Hospital getSelectedHospital() {
		return selectedHospital;
	}

	public void setSelectedHospital(Hospital selectedHospital) {
		this.selectedHospital = selectedHospital;
	}

	public List<Patient> getPatientListOfSelecetedHospital() {
		return patientListOfSelecetedHospital;
	}

	public void setPatientListOfSelecetedHospital(List<Patient> patientListOfSelecetedHospital) {
		this.patientListOfSelecetedHospital = patientListOfSelecetedHospital;
	}

	public List<Doctor> getDoctorListOfSelecetedHospital() {
		return doctorListOfSelecetedHospital;
	}

	public void setDoctorListOfSelecetedHospital(List<Doctor> doctorListOfSelecetedHospital) {
		this.doctorListOfSelecetedHospital = doctorListOfSelecetedHospital;
	}
	

}
