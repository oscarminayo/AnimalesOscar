package com.ipartek.formacion.animales.modelo.pojo;

public class Animal {

	private int id;

	private String mote;

	private Raza raza;

	private Float peso;

	private Float precio;

	private Disponibilidad disponibilidad;

	// getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMote() {
		return mote;
	}

	public void setMote(String mote) {
		this.mote = mote;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Disponibilidad getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Disponibilidad disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	// to string
	@Override
	public String toString() {
		return "Animal [id=" + id + ", mote=" + mote + ", raza=" + raza + ", peso=" + peso + ", precio=" + precio
				+ ", disponibilidad=" + disponibilidad + "]";
	}

}
