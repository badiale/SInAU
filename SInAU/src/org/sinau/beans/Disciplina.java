package org.sinau.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import org.sinau.config.Config;

import com.sun.jersey.api.client.GenericType;

@XmlRootElement
public class Disciplina implements Serializable {
	private String iddisciplina;
	private Integer cargaHoraria;
	private Curso curso;
	private String descricao;
	private Date horario;
	private String nome;
	private Integer sala;
	
	@XmlID
	public String getIddisciplina() {
		return iddisciplina;
	}
	
	@XmlElement(name = "cursoIdcurso")
	public void setIdcurso(String id) {
		this.curso = Curso.get(id);
	}
	
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public Curso getCursoIdcurso() {
		return curso;
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
	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	public void setIddisciplina(String iddisciplina) {
		this.iddisciplina = iddisciplina;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setSala(Integer sala) {
		this.sala = sala;
	}

	@Override
	public String toString() {
		return "Disciplina [cargaHoraria=" + cargaHoraria + ", curso="
				+ curso + ", descricao=" + descricao + ", horario="
				+ horario + ", iddisciplina=" + iddisciplina + ", nome=" + nome
				+ ", sala=" + sala + "]";
	}
}
