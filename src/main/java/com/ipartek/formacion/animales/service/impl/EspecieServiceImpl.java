package com.ipartek.formacion.animales.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.animales.modelo.dao.EspecieDAO;
import com.ipartek.formacion.animales.modelo.pojo.Especie;
import com.ipartek.formacion.animales.service.EspecieService;

@Service
public class EspecieServiceImpl implements EspecieService {

	@Autowired
	EspecieDAO especieDAO;

	@Override
	public ArrayList<Especie> listar() {

		ArrayList<Especie> especies = (ArrayList<Especie>) especieDAO.getAll();

		return especies;

	}

	@Override
	public Especie detalle(int idEspecie) {
		Especie especies = especieDAO.getById(idEspecie);
		return especies;
	}
}