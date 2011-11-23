package org.sinau.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.Session;
import org.sinau.db.DBManager;

@Entity
@XmlRootElement(name = "admin")
public class Administrador implements Serializable {
	private static final long serialVersionUID = -7073281227537749396L;
	
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
		return "\"" + id + "\" : { " + usuario.data() + ", \"Cargo\" : \"" + cargo + "\" }";
	}

	public static Administrador load(Integer id) {
		Session session = DBManager.getSession();
		return (Administrador) session.load(Administrador.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public static List<Administrador> findAll() {
		Session session = DBManager.getSession();
		String hql = "from Administrador order by id";
		org.hibernate.Query query = session.createQuery(hql);
		return query.list();
	}
}
