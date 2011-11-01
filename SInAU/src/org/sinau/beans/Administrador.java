package org.sinau.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.Session;
import org.sinau.config.Config;
import org.sinau.db.DBManager;

import com.sun.jersey.api.client.GenericType;

@Entity
@XmlRootElement(name = "admin")
public class Administrador implements Serializable {
	@Id
	private Integer id;
	private String cargo;
	
	@OneToOne
	@JoinColumn(name = "usuarioid")
	private Usuario usuario;
	
	public Administrador() {}
	
	@XmlElement(name = "idusuario")
	public void setIdusuario (String id) {
		this.id = Integer.parseInt(id);
		setUsuario(Usuario.load(this.id));
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Administrador [cargo=" + cargo + ", usuario=" + usuario + "]";
	}

	public static Administrador load(Integer id) {
		Session session = DBManager.getSession();
		return (Administrador) session.load(Administrador.class, id);
	}
	
	public void save() {
		Session session = DBManager.getSession();
		session.saveOrUpdate(this);
	}
}
