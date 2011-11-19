package org.sinau.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.Session;
import org.sinau.db.DBManager;

@Entity
@XmlRootElement
public class Curso implements Serializable {
	private static final long serialVersionUID = -1305872735392633340L;

	@Id
	private Integer idcurso;
	
	private String area;
	private String nome;
	private Integer vagas;
	
	@ManyToOne
	@JoinColumn(name = "departamentoid", insertable=false, updatable=false)
	@XmlTransient
	private Departamento departamento;
	
	@OneToMany
	@JoinColumn(name="cursoid")
	private Set<Disciplina> disciplinas = new HashSet<Disciplina>();
	
	@XmlElement(name = "iddepartamento")
	public void setIddepartamento(String id) {
		this.departamento = Departamento.load(Integer.parseInt(id));
		this.departamento.getCursos().add(this);
	}

	public Integer getIdcurso() {
		return idcurso;
	}

	public String getArea() {
		return area;
	}

	public String getNome() {
		return nome;
	}

	public Integer getVagas() {
		return vagas;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void setIdcurso(Integer idcurso) {
		this.idcurso = idcurso;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Curso [idcurso=" + idcurso + ", area=" + area + ", nome="
				+ nome + ", vagas=" + vagas + "]";
	}
	
	public static Curso load (Integer id) {
		Session session = DBManager.getSession();
		return (Curso) session.load(Curso.class, id);
	}
}
