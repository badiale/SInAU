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
		setUsuario(Usuario.get(id));
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

	public static List<Administrador> getAll() {
		return Config.getInstance().getService("administradores").get(new GenericType<List<Administrador>>() {});
	}
	
	// teste
	public static void main(String[] args) {
		Session session = DBManager.getSession();
		session.beginTransaction();
		
		for (Administrador a : getAll()) {
			session.saveOrUpdate(a);
		}
		
		Usuario u = (Usuario) session.load(Usuario.class, new Integer(42));
		System.out.println(u.getAdmin());
		
		session.getTransaction().commit();
	}
}
