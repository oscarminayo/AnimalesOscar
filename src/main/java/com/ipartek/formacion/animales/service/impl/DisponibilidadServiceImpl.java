package com.ipartek.formacion.animales.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.animales.modelo.dao.DisponibilidadDAO;
import com.ipartek.formacion.animales.modelo.pojo.Disponibilidad;
import com.ipartek.formacion.animales.service.DisponibilidadService;

@Service
public class DisponibilidadServiceImpl implements DisponibilidadService {

	@Autowired
	DisponibilidadDAO disponibilidadDAO;

	@Override
	public ArrayList<Disponibilidad> listar() {

		ArrayList<Disponibilidad> estados = (ArrayList<Disponibilidad>) disponibilidadDAO.getAll();

		return estados;

	}

	@Override
	public Disponibilidad detalle(int idDisponibilidad) {
		Disponibilidad estado = disponibilidadDAO.getById(idDisponibilidad);
		return estado;
	}
}