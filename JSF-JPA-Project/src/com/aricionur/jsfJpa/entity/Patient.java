package com.aricionur.jsfJpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String name;
	
//	@Transient
//	String patientComplaint;
	
//	@OneToOne
//	Hospital hospital;
//	
//	@ManyToMany(mappedBy = "patientList")
//	List<Doctor> doctorList = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getPatientComplaint() {
//		return patientComplaint;
//	}
//
//	public void setPatientComplaint(String patientComplaint) {
//		this.patientComplaint = patientComplaint;
//	}
//
//	public List<Doctor> getDoctorList() {
//		return doctorList;
//	}
//
//	public void setDoctorList(List<Doctor> doctorList) {
//		this.doctorList = doctorList;
//	}
//
//	public Hospital getHospital() {
//		return hospital;
//	}
//
//	public void setHospital(Hospital hospital) {
//		this.hospital = hospital;
//	}
	
	
	
}
