package com.ipartek.formacion.animales.modelo.dao;

import com.ipartek.formacion.animales.modelo.pojo.Dieta;
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
public class RazaDAO implements IDAO<Raza> {
	private static final String SQL_GET_ALL = "SELECT id, nombre, especie_id, dieta_id FROM raza;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre, especie_id, dieta_id FROM raza WHERE id=?;";

	@Override
	public Raza getById(int id) {

		Raza r = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					r = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<Raza> getAll() {

		ArrayList<Raza> razas = new ArrayList<Raza>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				razas.add(rowMapper(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return razas;
	}

	private Raza rowMapper(ResultSet rs) throws SQLException {

		Raza r = new Raza();
		
		EspecieDAO especieDAO = new EspecieDAO();
		DietaDAO dietaDAO = new DietaDAO();
		r.setId(rs.getInt("id"));
		r.setNombre(rs.getString("nombre"));
		r.setEspecie(especieDAO.getById(rs.getInt("id")));
		r.setDieta(dietaDAO.getById(r.getId()));
		

		return r;
	}
}