package com.aricionur.jsfJpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Hospital {

	@Id
	String id; //	@GeneratedValue(strategy = GenerationType.AUTO)

	String name;

//	@OneToMany
//	@JoinTable(name = ("hospital_patient"), joinColumns = @JoinColumn(name = "hospital_id"), inverseJoinColumns = @JoinColumn(name = ("patient_id")))
//	List<Patient> patientList = new ArrayList<>();

//	public void setPatientList(List<Patient> patientList) {
//		this.patientList = patientList;
//	}
//
//	public List<Patient> getPatientList() {
//		return patientList;
//	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
