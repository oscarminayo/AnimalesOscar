package com.ipartek.formacion.animales.modelo.dao;

import com.ipartek.formacion.animales.modelo.pojo.Disponibilidad;
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
public class DisponibilidadDAO implements IDAO<Disponibilidad> {
	private static final String SQL_GET_ALL = "SELECT id, estado FROM disponibilidad;";
	private static final String SQL_GET_BY_ID = "SELECT id, estado FROM disponibilidad WHERE id=?;";

	@Override
	public Disponibilidad getById(int id) {

		Disponibilidad d = null;
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
	public List<Disponibilidad> getAll() {

		ArrayList<Disponibilidad> estados = new ArrayList<Disponibilidad>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				estados.add(rowMapper(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estados;
	}

	private Disponibilidad rowMapper(ResultSet rs) throws SQLException {

		Disponibilidad d = new Disponibilidad();
		d.setId(rs.getInt("id"));
		d.setEstado(rs.getString("estado"));

		return d;
	}
}
