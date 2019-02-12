package com.ipartek.formacion.animales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.animales.modelo.dao.AnimalDAO;
import com.ipartek.formacion.animales.modelo.dao.DietaDAO;
import com.ipartek.formacion.animales.modelo.dao.DisponibilidadDAO;
import com.ipartek.formacion.animales.modelo.dao.EspecieDAO;
import com.ipartek.formacion.animales.modelo.dao.RazaDAO;
import com.ipartek.formacion.animales.modelo.pojo.Animal;
import com.ipartek.formacion.animales.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	AnimalDAO animalDAO;
	@Autowired
	RazaDAO razaDAO;
	@Autowired
	EspecieDAO especieDAO;
	@Autowired
	DietaDAO dietaDAO;
	@Autowired
	DisponibilidadDAO disponibilidadDAO;

	@Override
	public List<Animal> listar() {
		ArrayList<Animal> animales = new ArrayList<Animal>();
		animales = (ArrayList<Animal>) animalDAO.getAll();

		return animales;
	}

	@Override
	public Animal detalle(int idAnimal) {
		Animal animal = animalDAO.getById(idAnimal);
		return animal;
	}
}
