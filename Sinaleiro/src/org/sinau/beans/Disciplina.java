package org.sinau.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.Session;
import org.sinau.db.DBManager;

@Entity
@XmlRootElement
public class Disciplina implements Serializable {
	private static final long serialVersionUID = -2315882260788173517L;

	@Id
	private Integer iddisciplina;
	
	private Integer cargaHoraria;
	private String descricao;
	private Date horario;
	private String nome;
	private Integer sala;
	
	@ManyToOne
	@JoinColumn(name = "cursoid", insertable=false, updatable=false)
	@XmlTransient
	private Curso curso;
	
	@XmlElement(name = "cursoIdcurso")
	public void setIdcurso(String id) {
		this.curso = Curso.load(Integer.parseInt(id));
		this.curso.getDisciplinas().add(this);
	}

	public Integer getIddisciplina() {
		return iddisciplina;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public String getDescricao() {
		return descricao;
	}

	public Date getHorario() {
		return horario;
	}

	public String getNome() {
		return nome;
	}

	public Integer getSala() {
		return sala;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setIddisciplina(Integer iddisciplina) {
		this.iddisciplina = iddisciplina;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSala(Integer sala) {
		this.sala = sala;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return " \"" + iddisciplina + "\" : {" +
					"\"Nome\"         : \"" + nome + "\"," +
					"\"CargaHoraria\" : \"" + cargaHoraria + "\"," +
					"\"Descricao\"    : \"" + descricao.replace('\n', ' ') + "\"," +
					"\"Horario\"      : \"" + horario + "\"," +
					"\"Sala\"         : \"" + sala + "\"" + 
				"}";
	}
	
	public static Disciplina load (Integer id) {
		Session session = DBManager.getSession();
		return (Disciplina) session.load(Disciplina.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public static List<Disciplina> findAll() {
		Session session = DBManager.getSession();
		String hql = "from Disciplina";
		org.hibernate.Query query = session.createQuery(hql);
		return query.list();
	}
}
