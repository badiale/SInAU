package org.sinau.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.sinau.patterns.DBLoad;

@XmlRootElement
public class AlunoDisciplinaPK implements Serializable {
	private Disciplina disciplina;
	private Usuario usuario;
	
	public AlunoDisciplinaPK() {}

	@XmlElement(name = "idusuario")
	public void setIdusuario (String id) {
		usuario = new Usuario();
		usuario.setIdusuario(Integer.parseInt(id));
		new DBLoad().execute(usuario);
	}
	
	@XmlElement(name = "iddisciplina")
	public void setIddisciplina (String id) {
		disciplina = new Disciplina();
		disciplina.setIddisciplina(Integer.parseInt(id));
		new DBLoad().execute(disciplina);
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
		return "AlunoDisciplinaPK [disciplina=" + disciplina + ", usuario="
				+ usuario + "]";
	}
}
