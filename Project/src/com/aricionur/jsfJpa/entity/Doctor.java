package com.aricionur.jsfJpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	String name;

	
	
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "doctor_patient", joinColumns=@JoinColumn(name="doctor_id"), inverseJoinColumns=@JoinColumn(name="patient_id"))
//	List<Patient> patientList = new ArrayList<>();

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

//	public List<Patient> getPatientList() {
//		return patientList;
//	}
//
//	public void setPatientList(List<Patient> patientList) {
//		this.patientList = patientList;
//	}
//	
	

}
