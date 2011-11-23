package org.sinau.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
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
public class Departamento implements Serializable {
	private static final long serialVersionUID = 4077544560336079747L;

	@Id
	private Integer iddepartamento;
	
	private String nome;
	private String telefone;
	
	@OneToMany
	@JoinColumn(name="departamentoid")
	private Set<Professor> professores = new HashSet<Professor>();
	
	@ManyToOne
	@JoinColumn(name = "universidadeid", insertable=false, updatable=false)
	@XmlTransient
	private Universidade universidade;
	
	@OneToMany
	@JoinColumn(name="departamentoid")
	private Set<Curso> cursos = new HashSet<Curso>();
	
	@XmlElement(name = "iduniversidade")
	public void setIduniversidade(String iduniversidade) {
		this.universidade = Universidade.load(Integer.parseInt(iduniversidade));
		this.universidade.getDepartamentos().add(this);
	}
	
	public Integer getIddepartamento() {
		return iddepartamento;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public Set<Professor> getProfessores() {
		return professores;
	}

	public Universidade getUniversidade() {
		return universidade;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setIddepartamento(Integer iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setProfessores(Set<Professor> professores) {
		this.professores = professores;
	}

	public void setUniversidade(Universidade universidade) {
		this.universidade = universidade;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		String ret = "";
		ret += "\"" + getIddepartamento() + "\"" + " : ";
		ret += "{";
			ret += "\"Nome\" : \"" + getNome() + "\",";
			ret += "\"Telefone\" : \"" + getTelefone() + "\"";
		ret += "}";
		return ret;
	}

	public static Departamento load (Integer id) {
		Session session = DBManager.getSession();
		return (Departamento) session.load(Departamento.class, id);
	}
        
	@SuppressWarnings("unchecked")
	public static List<Departamento> findAll() {
		Session session = DBManager.getSession();
		String hql = "from Departamento";
		org.hibernate.Query query = session.createQuery(hql);
		return query.list();
	}
        
        public static List<Departamento> findByNameLike (String name) {
		Session session = DBManager.getSession();
		String hql = "from Departamento a where lower(a.nome) like lower('%" + name + "%')";
		org.hibernate.Query query = session.createQuery(hql);
		return query.list();
	}
}
