package com.ipartek.formacion.animales.modelo.pojo;

public class Disponibilidad {

	private int id;

	private String estado;

	public Disponibilidad() {
		super();
		this.id = -1;
		this.estado = "";
	}

	public Disponibilidad(int id, String Estado) {
		this();
		this.setId(id);
		this.setEstado(estado);
	}

	// getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// to string
	@Override
	public String toString() {
		return "Disponibilidad [id=" + id + ", Estado=" + estado + "]";
	}

}
