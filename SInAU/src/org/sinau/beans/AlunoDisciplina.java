package org.sinau.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.sinau.config.Config;

import com.sun.jersey.api.client.GenericType;

@XmlRootElement
public class AlunoDisciplina implements Serializable {
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
