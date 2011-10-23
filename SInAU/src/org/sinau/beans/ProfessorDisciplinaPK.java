package org.sinau.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProfessorDisciplinaPK implements Serializable {
	private Disciplina disciplina;
	private Usuario usuario;
	
	@XmlElement(name = "iddisciplina")
	public void setIddisciplina (String id) {
		this.disciplina = Disciplina.get(id);
	}
	
	@XmlElement(name = "idusuario")
	public void setIdusuario (String id) {
		this.usuario = Usuario.get(id);
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
