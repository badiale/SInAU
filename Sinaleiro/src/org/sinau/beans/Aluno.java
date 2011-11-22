package org.sinau.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.Session;
import org.sinau.db.DBManager;

@Entity
@XmlRootElement
public class Aluno implements Serializable {
	private static final long serialVersionUID = 6096842038230881759L;

	@Id
	private Integer idaluno;
	
	private String matriculaNusp;
	private Date anoInicio;
	private Boolean bolsista;
	private String endereco;
	private Integer semestre;
	
	@OneToOne
	@JoinColumn(name = "usuarioid")
	private Usuario usuario;
	
	public Aluno () {}
	
	@XmlElement(name = "idusuario")
	public void setIdusuario (String id) {
		this.idaluno = Integer.parseInt(id);
		this.usuario = Usuario.load(Integer.parseInt(id));
	}
	
	@XmlID
	public String getMatriculaNusp() {
		return matriculaNusp;
	}
	
	public Date getAnoInicio() {
		return anoInicio;
	}

	public Boolean getBolsista() {
		return bolsista;
	}

	public String getEndereco() {
		return endereco;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public Integer getIdaluno() {
		return idaluno;
	}

	public void setIdaluno(Integer idaluno) {
		this.idaluno = idaluno;
	}

	public void setAnoInicio(Date anoInicio) {
		this.anoInicio = anoInicio;
	}

	public void setBolsista(Boolean bolsista) {
		this.bolsista = bolsista;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setMatriculaNusp(String matriculaNusp) {
		this.matriculaNusp = matriculaNusp;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		return "Aluno [idaluno=" + idaluno + ", matriculaNusp=" + matriculaNusp
				+ ", anoInicio=" + anoInicio + ", bolsista=" + bolsista
				+ ", endereco=" + endereco + ", semestre=" + semestre + "]";
	}
	
	public static Aluno load (Integer id) {
		Session session = DBManager.getSession();
		return (Aluno) session.load(Aluno.class, id);
	}
}
