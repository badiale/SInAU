package org.sinau.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.ws.rs.GET;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.Session;
import org.sinau.config.Config;
import org.sinau.db.DBManager;

import com.sun.jersey.api.client.GenericType;

@Entity
@XmlRootElement
public class Usuario implements Serializable {
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
	public Administrador admin;
	
	@OneToOne(mappedBy = "usuario")
	@XmlTransient
	public Professor professor;
	
	/**
	 * Pojo.
	 * */
	public Usuario() {}
	
	public Boolean getAtivo() {
		return ativo;
	}

	public String getEmail() {
		return email;
	}

	public Integer getIdusuario() {
		return idusuario;
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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
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

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	public static Usuario load(Integer id) {
		Session session = DBManager.getSession();
		return (Usuario) session.load(Usuario.class, id);
	}
	
	public void save() {
		Session session = DBManager.getSession();
		session.saveOrUpdate(this);
	}
	
	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", ativo=" + ativo
				+ ", email=" + email + ", nome=" + nome + ", nomeUsuario="
				+ nomeUsuario + ", senha=" + senha + ", telefone=" + telefone
				+ ", tipo=" + tipo + ", admin=" + admin + ", professor="
				+ professor + "]";
	}
}