package com.websi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.websi.dao.ConnectionFactory;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Connection c = new ConnectionFactory().getConnection();
		String sql = "create table produtos (id serial, "+  
				"descricao VARCHAR(255), valor double precision, "+ 
				"primary key (id))";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.executeUpdate();
		c.close();
	}

}

