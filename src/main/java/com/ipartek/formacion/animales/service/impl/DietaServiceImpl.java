package com.ipartek.formacion.animales.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.animales.modelo.dao.DietaDAO;
import com.ipartek.formacion.animales.modelo.pojo.Dieta;
import com.ipartek.formacion.animales.service.DietaService;

@Service
public class DietaServiceImpl implements DietaService {

	@Autowired
	DietaDAO dietaDAO;

	@Override
	public ArrayList<Dieta> listar() {

		ArrayList<Dieta> dietas = (ArrayList<Dieta>) dietaDAO.getAll();

		return dietas;

	}

	@Override
	public Dieta detalle(int idDieta) {
		Dieta dieta = dietaDAO.getById(idDieta);
		return dieta;
	}
}