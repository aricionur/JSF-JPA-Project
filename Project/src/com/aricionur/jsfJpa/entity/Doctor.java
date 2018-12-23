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
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	String name;

	@ManyToMany(mappedBy = "doctorList" )
	List<Hospital> doctorHospitalList = new ArrayList<>();
	
	
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


	public void setDoctorHospitalList(List<Hospital> doctorHospitalList) {
		this.doctorHospitalList = doctorHospitalList;
	}
	public List<Hospital> getDoctorHospitalList() {
		return doctorHospitalList;
	}
	

}
