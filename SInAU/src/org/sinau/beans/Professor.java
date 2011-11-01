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
import org.sinau.config.Config;
import org.sinau.db.DBManager;

import com.sun.jersey.api.client.GenericType;

@Entity
@XmlRootElement
public class Professor implements Serializable {
	@Id
	private Integer id;
	private Boolean coordenador;
	private Departamento departamento;
	
	@OneToOne
	@JoinColumn(name = "usuarioid")
	private Usuario usuario;
	
	public Professor() {}
	
	@XmlElement(name = "iddepartamento")
	public void setIddepartamento (String id) {
		this.departamento = Departamento.get(id);
	}
	
	@XmlElement(name = "idusuario")
	public void setIdusuario (String id) {
		this.id = Integer.parseInt(id);
		this.usuario = Usuario.load(this.id);
	}
	
	public Boolean getCoordenador() {
		return coordenador;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setCoordenador(Boolean coordenador) {
		this.coordenador = coordenador;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Professor [coordenador=" + coordenador + ", departamento="
				+ departamento + ", usuario=" + usuario + "]";
	}
	
	public static Professor load(Integer id) {
		Session session = DBManager.getSession();
		return (Professor) session.load(Professor.class, id);
	}
	
	public void save() {
		Session session = DBManager.getSession();
		session.saveOrUpdate(this);
	}
}
