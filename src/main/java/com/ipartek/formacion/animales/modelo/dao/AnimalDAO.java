package com.ipartek.formacion.animales.modelo.dao;

import com.ipartek.formacion.animales.modelo.pojo.Animal;
import com.ipartek.formacion.animales.modelo.pojo.Dieta;
import com.ipartek.formacion.animales.modelo.pojo.Disponibilidad;
import com.ipartek.formacion.animales.modelo.pojo.Especie;
import com.ipartek.formacion.animales.modelo.pojo.Raza;
import com.ipartek.formacion.animales.modelo.config.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.animales.modelo.dao.IDAO;

@Repository
public class AnimalDAO implements IDAO<Animal> {
	private static final String SQL_GET_ALL = "SELECT \r\n" + 
			"	a.id as 'id_animal',\r\n" + 
			"    a.mote as 'mote',\r\n" + 
			"    r.id as 'id_raza',\r\n" + 
			"    r.nombre as 'nombre_raza',\r\n" + 
			"    e.id as 'id_especie',\r\n" + 
			"    e.nombre as 'nombre_especie',\r\n" + 
			"    di.id as 'id_dieta',\r\n" + 
			"    di.nombre as 'nombre_dieta',\r\n" + 
			"    a.pesoKG as 'peso',\r\n" + 
			"    a.precio as 'precio',\r\n" + 
			"    d.id as 'id_disponibilidad',\r\n" + 
			"    d.estado as 'estado'\r\n" + 
			"FROM animal_stock as a, raza as r, disponibilidad as d, especie as e, dieta as di\r\n" + 
			"WHERE a.raza_id = r.id AND a.disponibilidad_id = d.id AND r.especie_id = e.id AND r.dieta_id = di.id;";
	private static final String SQL_GET_BY_ID = "SELECT id, mote ,raza_id, pesoKG, precio, disponibilidad_id FROM animal_stock WHERE id=?;";
	RazaDAO razaDAO = new RazaDAO();
	DisponibilidadDAO disponibilidadDAO = new DisponibilidadDAO();
	@Override
	public Animal getById(int id) {

		Animal a = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					a = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Animal> getAll() {

		ArrayList<Animal> animales = new ArrayList<Animal>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				animales.add(rowMapper(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return animales;
	}

	private Animal rowMapper(ResultSet rs) throws SQLException {
	
		// Especie
		Especie especie = new Especie();
		especie.setId(rs.getInt("id_especie"));
		especie.setNombre(rs.getString("nombre_especie"));
		
		//Dieta
		Dieta dieta = new Dieta();
		dieta.setId(rs.getInt("id_dieta"));
		dieta.setNombre(rs.getString("nombre_dieta"));
		
		//Raza
		Raza raza = new Raza();
		raza.setId(rs.getInt("id_raza"));
		raza.setNombre(rs.getString("nombre_raza"));
		raza.setEspecie(especie);
		raza.setDieta(dieta);

		// Disponibilidad
		Disponibilidad disponibilidad = new Disponibilidad();
		disponibilidad.setId( rs.getInt("id_disponibilidad"));
		disponibilidad.setEstado( rs.getString("estado"));
		
		Animal animal = new Animal();
		animal.setId(rs.getInt("id_animal"));
		animal.setRaza(raza);
		animal.setMote(rs.getString("mote"));
		animal.setPeso(rs.getFloat("peso"));
		animal.setPrecio(rs.getFloat("precio"));
		animal.setDisponibilidad(disponibilidad);
		
		return animal;
	}
}
