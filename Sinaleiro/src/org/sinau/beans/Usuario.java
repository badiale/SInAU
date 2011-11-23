package org.sinau.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.Session;
import org.sinau.db.DBManager;

@Entity
@XmlRootElement
public class Usuario implements Serializable {
	private static final long serialVersionUID = 6194985310779971753L;

	@Id
	private Integer idusuario;
	
	private Boolean ativo;
	private String email;
	private String nome;
	private String nomeUsuario;
	private String senha;
	private String telefone;
	private String tipo;
	
	@OneToOne(mappedBy = "usuario")
	@XmlTransient
	private Administrador admin;
	
	@OneToOne(mappedBy = "usuario")
	@XmlTransient
	private Professor professor;
	
	@OneToOne(mappedBy = "usuario")
	@XmlTransient
	private Aluno aluno;
	
	/**
	 * Pojo.
	 * */
	public Usuario() {}

	public Integer getIdusuario() {
		return idusuario;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public Administrador getAdmin() {
		return admin;
	}

	public Professor getProfessor() {
		return professor;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String data() {
		return    "\"Nome\"     : \"" + nome        + "\","
				+ "\"Ativo\"    : \"" + ativo       + "\", "
				+ "\"Email\"    : \"" + email       + "\","
				+ "\"Login\"    : \"" + nomeUsuario + "\","
				+ "\"Senha\"    : \"" + senha       + "\","
				+ "\"Telefone\" : \"" + telefone    + "\","
				+ "\"Tipo\"     : \"" + tipo        + "\"";
	}
	
	@Override
	public String toString() {
		return "\""+ idusuario +"\" : { " + data() + " }";
	}
	
	public static Usuario load (Integer id) {
		Session session = DBManager.getSession();
		return (Usuario) session.load(Usuario.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public static List<Usuario> findAll() {
		Session session = DBManager.getSession();
		String hql = "from Usuario";
		org.hibernate.Query query = session.createQuery(hql);
		return query.list();
	}
}