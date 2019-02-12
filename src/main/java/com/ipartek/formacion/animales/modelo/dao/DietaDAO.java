package com.ipartek.formacion.animales.modelo.dao;

import com.ipartek.formacion.animales.modelo.pojo.Dieta;
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
public class DietaDAO implements IDAO<Dieta> {
	private static final String SQL_GET_ALL = "SELECT id, nombre FROM dieta;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM dieta WHERE id=?;";

	@Override
	public Dieta getById(int id) {

		Dieta d = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					d = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	@Override
	public List<Dieta> getAll() {

		ArrayList<Dieta> dietas = new ArrayList<Dieta>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				dietas.add(rowMapper(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dietas;
	}

	private Dieta rowMapper(ResultSet rs) throws SQLException {

		Dieta d = new Dieta();
		d.setId(rs.getInt("id"));
		d.setNombre(rs.getString("nombre"));

		return d;
	}
}