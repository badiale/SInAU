package org.sinau.beans;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Embeddable
@XmlRootElement
public class AlunoDisciplinaPK implements Serializable {
	private static final long serialVersionUID = 1018854177325264055L;
	
	private Integer disciplina;
	private Integer usuario;
	
	@XmlElement(name = "iddisciplina")
	public void setIddisciplina (String id) {
		this.disciplina = Integer.parseInt(id);
	}
	
	@XmlElement(name = "idusuario")
	public void setIdusuario (String id) {
		this.usuario = Integer.parseInt(id);
	}
	
	public Disciplina getDisciplina() {
		return Disciplina.load(disciplina);
	}
	public Usuario getUsuario() {
		return Usuario.load(usuario);
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina.getIddisciplina();
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario.getIdusuario();
	}
	@Override
	public String toString() {
		return "AlunoDisciplinaPK [disciplina=" + disciplina + ", usuario="
				+ usuario + "]";
	}
	
	@Override
	public boolean equals (Object o) {
		if (o == null) return false;
		if (!(o instanceof AlunoDisciplinaPK)) return false;
		
		AlunoDisciplinaPK outro = (AlunoDisciplinaPK) o;
		if (outro.usuario == null) return false;
		if (outro.disciplina == null) return false;
		if (this.usuario == null) return false;
		if (this.disciplina == null) return false;
		
		if (usuario.equals(outro.usuario) && disciplina.equals(outro.disciplina)) return true;
		
		return false;
	}
	
	@Override
	public int hashCode () {
		int ret = 0;
		ret += usuario;
		ret += disciplina;
		return ret;
	}
}
