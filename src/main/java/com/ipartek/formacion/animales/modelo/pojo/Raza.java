package com.ipartek.formacion.animales.modelo.pojo;

public class Raza {

	private int id;

	private String nombre;

	private Especie especie;

	private Dieta dieta;

	public Raza() {
		super();
		this.id = -1;
		this.nombre = "";
		this.especie = new Especie();
		this.dieta = new Dieta();
	}

	public Raza(int id, String nombre, Especie especie, Dieta dieta) {
		this();
		this.setId(id);
		this.setNombre(nombre);
		this.setEspecie(especie);
		this.setDieta(dieta);
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

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Dieta getDieta() {
		return dieta;
	}

	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
	}

	// to string
	@Override
	public String toString() {
		return "Raza [id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", dieta=" + dieta + "]";
	}
}
