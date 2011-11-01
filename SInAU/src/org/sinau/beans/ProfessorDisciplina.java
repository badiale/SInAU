package org.sinau.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.sinau.config.Config;

import com.sun.jersey.api.client.GenericType;

@XmlRootElement
public class ProfessorDisciplina implements Serializable {
	private ProfessorDisciplinaPK professorDisciplinaPK;
	
	public ProfessorDisciplinaPK getProfessorDisciplinaPK() {
		return professorDisciplinaPK;
	}

	public void setProfessorDisciplinaPK(ProfessorDisciplinaPK professorDisciplinaPK) {
		this.professorDisciplinaPK = professorDisciplinaPK;
	}

	@Override
	public String toString() {
		return "ProfessorDisciplina [professorDisciplinaPK="
				+ professorDisciplinaPK + "]";
	}
}
