package com.websi.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "servicos")
public class Servico {
	
	public enum Categoria {
		VAZIA,
		SAUDE,
		EVENTOS,
		TECNOLOGIA,
		SERVICOS_DOMESTICOS;
		
		public static Categoria getCategoria (String categoria) {
			Categoria ctg = Categoria.VAZIA;
			for (Categoria c : Categoria.values())
				if (c.toString().equals(categoria))
					ctg = c;
			return ctg;
		}
	}
	
	public enum Tipo {
		EMPTY,
		HOMEOFFICE,
		PRESENCIAL;
		
		public static Tipo getTipo (String tipo) {
			Tipo tp = EMPTY;
			for (Tipo t : Tipo.values())
				if (t.toString().equals(tipo))
					tp = t;
			return tp;
		}
	}
	
	public Servico() {}
	
	public Servico(String nome, Tipo tipo, Categoria categoria, String atividade, String descricao) {
		this.nome = nome;
		this.tipo = tipo;
		this.categoria = categoria;
		this.atividade = atividade;
		this.descricao = descricao;
	}
	
	public Servico(Long id, String nome, Tipo tipo, Categoria categoria, String atividade, String descricao) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.categoria = categoria;
		this.atividade = atividade;
		this.descricao = descricao;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	private String atividade;
	
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
