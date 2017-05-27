package com.websi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.websi.model.Produto;

public class ProdutoDao {
	private Connection connection;

	public ProdutoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert (Produto produto) {
		String sql = "insert into produtos " + "(descricao, valor)" + " values (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, produto.getDescricao());
			stmt.setDouble(2, produto.getValor());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Produto getProduto (Long id) {
		try {			
			PreparedStatement stmt = this.connection.prepareStatement("select * from produtos where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Produto produto = new Produto (rs.getLong("id"), rs.getString("descricao"), rs.getDouble("valor"));
			rs.close();
			stmt.close();
			return produto;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Produto> getAllProdutos() {
		try {
			List<Produto> produtos = new ArrayList<>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from produtos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto (rs.getLong("id"), rs.getString("descricao"), rs.getDouble("valor"));
				produtos.add(produto);
			}
			rs.close();
			stmt.close();
			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateProduto(Produto produto) {
		try {
			PreparedStatement stmt = connection.prepareStatement("update produtos set descricao=?, valor=? where id=?");
			stmt.setString(1, produto.getDescricao());
			stmt.setDouble(2, produto.getValor());
			stmt.setLong(3, produto.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void removeProduto (Long id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from produtos where id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
