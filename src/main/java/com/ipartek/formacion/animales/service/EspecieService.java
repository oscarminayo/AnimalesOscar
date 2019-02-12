package com.ipartek.formacion.animales.service;

import java.util.List;

import com.ipartek.formacion.animales.modelo.pojo.Especie;

public interface EspecieService {

	/**
	 * Listado de todas las especies registradas ordenadas por ID descendente
	 * 
	 * @return List<Especie>, Lista vacía si no hay datos
	 */
	List<Especie> listar();

	/**
	 * Detalle de una Especie concreta
	 * 
	 * @param idEspecie int ID de la especie del que se quiere obtener el detalle
	 * @return Especie, <b>Null</b> si no existe
	 */
	Especie detalle(int idEspecie);

}
