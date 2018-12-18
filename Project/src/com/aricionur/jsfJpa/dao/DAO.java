package com.aricionur.jsfJpa.dao;

import java.util.List;

import com.aricionur.jsfJpa.entity.Doctor;
import com.aricionur.jsfJpa.entity.Hospital;
import com.aricionur.jsfJpa.entity.Patient;

public class DAO extends ADao {

	// -------INSERT-----//
	public void insert(Object obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}

	// -------UPDATE-----//
	public void update(Object obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}

	// -------DELETE-----//
	public void delete(Object obj) {
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
	}

	// -------READ-----//
	public Hospital getSingleHospitalById(String id) {
		return em.find(Hospital.class, id);
	}

	
	public List<Hospital> getAllHospitals() {
		return em.createQuery("SELECT h FROM Hospital h").getResultList();
	}

	public Doctor getSingleDocotrById(int id) {
		return em.find(Doctor.class, id);
	}

	public List<Doctor> getAllDoctors() {
		return em.createQuery("SELECT d FROM Doctor d").getResultList();
	}

	public Patient getSinglePatientById(int id) {
		return em.find(Patient.class, id);
	}

	public List<Patient> getAllPatients() {
		return em.createQuery("SELECT p FROM Patient p").getResultList();
	}

}
