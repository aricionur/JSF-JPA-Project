package com.aricionur.jsfJpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String name;
	
	@ManyToMany(mappedBy = "patientList")
	List<Hospital> patientHospitalList = new ArrayList<>();

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

	public void setPatientHospitalList(List<Hospital> patientHospitalList) {
		this.patientHospitalList = patientHospitalList;
	}
	public List<Hospital> getPatientHospitalList() {
		return patientHospitalList;
	}
	
	
}
