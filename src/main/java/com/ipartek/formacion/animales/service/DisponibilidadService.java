package com.ipartek.formacion.animales.service;

import java.util.List;

import com.ipartek.formacion.animales.modelo.pojo.Disponibilidad;

public interface DisponibilidadService {

	/**
	 * Listado de todos los estados registrados ordenados por ID descendente
	 * 
	 * @return List<Disponibilidad>, Lista vacía si no hay datos
	 */
	List<Disponibilidad> listar();

	/**
	 * Detalle de un estado concreto
	 * 
	 * @param idDisponibilidad int ID del estado del que se quiere obtener el
	 *                         detalle
	 * @return Disponibilidad, <b>Null</b> si no existe
	 */
	Disponibilidad detalle(int idDisponibilidad);

}
