package org.sinau.beans;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class AlunoDisciplina implements Serializable {
	private static final long serialVersionUID = 5108292590266316659L;

	@EmbeddedId
	private AlunoDisciplinaPK alunoDisciplinaPK;
	
	private Float nota;
	
	public AlunoDisciplina() {}

	public AlunoDisciplinaPK getAlunoDisciplinaPK() {
		return alunoDisciplinaPK;
	}

	public Float getNota() {
		return nota;
	}

	public void setAlunoDisciplinaPK(AlunoDisciplinaPK alunoDisciplinaPK) {
		this.alunoDisciplinaPK = alunoDisciplinaPK;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "AlunoDisciplina [alunoDisciplinaPK=" + alunoDisciplinaPK
				+ ", nota=" + nota + "]";
	}
}
