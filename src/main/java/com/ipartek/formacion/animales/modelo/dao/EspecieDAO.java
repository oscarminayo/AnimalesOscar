package com.ipartek.formacion.animales.modelo.dao;

import com.ipartek.formacion.animales.modelo.pojo.Especie;
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
public class EspecieDAO implements IDAO<Especie> {
	private static final String SQL_GET_ALL = "SELECT id, nombre FROM especie;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM especie WHERE id=?;";

	@Override
	public Especie getById(int id) {

		Especie es = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					es = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return es;
	}

	@Override
	public List<Especie> getAll() {

		ArrayList<Especie> especies = new ArrayList<Especie>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				especies.add(rowMapper(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return especies;
	}

	private Especie rowMapper(ResultSet rs) throws SQLException {

		Especie e = new Especie();
		e.setId(rs.getInt("id"));
		e.setNombre(rs.getString("nombre"));

		return e;
	}
}