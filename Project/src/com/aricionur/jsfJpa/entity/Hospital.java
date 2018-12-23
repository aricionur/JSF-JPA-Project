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


@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id; //	@GeneratedValue(strategy = GenerationType.AUTO)

	String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hospital_patient", joinColumns=@JoinColumn(name="hospital_id"), inverseJoinColumns=@JoinColumn(name="patient_id"))
	List<Patient> patientList = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hospital_doctor", joinColumns=@JoinColumn(name="hospital_id"), inverseJoinColumns=@JoinColumn(name="doctor_id"))
	List<Doctor> doctorList = new ArrayList<>();

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getName() {
		return name;
	}
	
	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}
	
	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}
	public List<Doctor> getDoctorList() {
		return doctorList;
	}
}
