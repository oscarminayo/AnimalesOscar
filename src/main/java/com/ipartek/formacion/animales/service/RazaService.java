package com.ipartek.formacion.animales.service;

import java.util.List;

import com.ipartek.formacion.animales.modelo.pojo.Raza;

public interface RazaService {

	/**
	 * Listado de todas las razas registradas ordenadas por ID descendente
	 * 
	 * @return List<Raza>, Lista vacía si no hay datos
	 */
	List<Raza> listar();

	/**
	 * Detalle de una Raza concreta
	 * 
	 * @param idRaza int ID de la Raza del que se quiere obtener el detalle
	 * @return Raza, <b>Null</b> si no existe
	 */
	Raza detalle(int idRaza);

}
