package com.ipartek.formacion.animales.service;

import java.util.List;

import com.ipartek.formacion.animales.modelo.pojo.Animal;

public interface AnimalService {

	/**
	 * Listado de todos los animales registrados ordenados por ID descendente
	 * 
	 * @return List<Animal>, Lista vacía si no hay datos
	 */
	List<Animal> listar();

	/**
	 * Detalle de un Animal concreto
	 * 
	 * @param idAnimal int ID del Animal del que se quiere obtener el detalle
	 * @return Animal, <b>Null</b> si no existe
	 */
	Animal detalle(int idAnimal);

}
