package org.sinau.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.sinau.patterns.DBLoad;

@XmlRootElement
public class ProfessorDisciplinaPK implements Serializable {
	private Disciplina disciplina;
	private Usuario usuario;
	
	@XmlElement(name = "iddisciplina")
	public void setIddisciplina (String id) {
		this.disciplina = new Disciplina();
		this.disciplina.setIddisciplina(id);
		new DBLoad().execute(this.disciplina);
	}
	
	@XmlElement(name = "idusuario")
	public void setIdusuario (String id) {
		this.usuario = new Usuario();
		this.usuario.setIdusuario(Integer.parseInt(id));
		new DBLoad().execute(this.usuario);
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "ProfessorDisciplinaPK [disciplina=" + disciplina + ", usuario="
				+ usuario + "]";
	}
}
