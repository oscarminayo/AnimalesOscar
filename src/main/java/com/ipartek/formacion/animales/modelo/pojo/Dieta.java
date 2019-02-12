package com.ipartek.formacion.animales.modelo.pojo;

public class Dieta {

	private int id;

	private String nombre;

	public Dieta() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	public Dieta(int id, String nombre) {
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
		return "Dieta [id=" + id + ", nombre=" + nombre + "]";
	}
}
