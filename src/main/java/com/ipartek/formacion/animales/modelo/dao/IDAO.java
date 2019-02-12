package com.ipartek.formacion.animales.modelo.dao;

import java.util.List;

/**
 * Interfaz para que los DAOs implementen las operaciones basicas de CRUD
 * 
 * @author ur00
 *
 */
public interface IDAO<P> {

	P getById(int id);

	List<P> getAll();

}