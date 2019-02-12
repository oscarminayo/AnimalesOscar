package com.ipartek.formacion.animales.modelo.pojo;

public class Especie {

	private int id;

	private String nombre;

	public Especie() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	public Especie(int id, String nombre) {
		this();
		this.setId(id);
		this.setNombre(nombre);
	}

	// getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// to string
	@Override
	public String toString() {
		return "Especie [id=" + id + ", nombre=" + nombre + "]";
	}

}
