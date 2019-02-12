package com.ipartek.formacion.animales.service;

import java.util.List;

import com.ipartek.formacion.animales.modelo.pojo.Dieta;

public interface DietaService {

	/**
	 * Listado de todos las dietas registradas ordenadas por ID descendente
	 * 
	 * @return List<Dieta>, Lista vacía si no hay datos
	 */
	List<Dieta> listar();

	/**
	 * Detalle de una Dieta concreta
	 * 
	 * @param idDieta int ID de la Dieta del que se quiere obtener el detalle
	 * @return Dieta, <b>Null</b> si no existe
	 */
	Dieta detalle(int idDieta);

}
