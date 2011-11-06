package org.sinau.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.Session;
import org.sinau.db.DBManager;

@Entity
@XmlRootElement
public class Professor implements Serializable {
	@Id
	private Integer id;
	
	private Boolean coordenador;
	
	@OneToOne
	@JoinColumn(name = "usuarioid")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "departamentoid", insertable=false, updatable=false)
	@XmlTransient
	private Departamento departamento;
	
	public Professor() {}
	
	@XmlElement(name = "iddepartamento")
	public void setIddepartamento (String id) {
		this.departamento = Departamento.load(Integer.parseInt(id));
		this.departamento.getProfessores().add(this);
	}
	
	@XmlElement(name = "idusuario")
	public void setIdusuario (String id) {
		this.id = Integer.parseInt(id);
		this.usuario = Usuario.load(Integer.parseInt(id));
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "Professor [id=" + id + ", coordenador=" + coordenador + "]";
	}
	
	public static Professor load (Integer id) {
		Session session = DBManager.getSession();
		return (Professor) session.load(Professor.class, id);
	}
}
