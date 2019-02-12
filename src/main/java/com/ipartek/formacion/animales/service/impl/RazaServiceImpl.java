package com.ipartek.formacion.animales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.animales.modelo.dao.DietaDAO;
import com.ipartek.formacion.animales.modelo.dao.EspecieDAO;
import com.ipartek.formacion.animales.modelo.dao.RazaDAO;
import com.ipartek.formacion.animales.modelo.pojo.Raza;
import com.ipartek.formacion.animales.service.RazaService;

@Service
public class RazaServiceImpl implements RazaService {

	@Autowired
	RazaDAO razaDAO;
	@Autowired
	EspecieDAO especieDAO;
	@Autowired
	DietaDAO dietaDAO;

	@Override
	public List<Raza> listar() {
		ArrayList<Raza> razas = new ArrayList<Raza>();
		razas = (ArrayList<Raza>) razaDAO.getAll();

		return razas;
	}
	@Override
	public Raza detalle(int idRaza) {
		Raza raza = razaDAO.getById(idRaza);
		return raza;
	}
}
