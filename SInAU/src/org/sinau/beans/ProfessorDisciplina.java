package org.sinau.beans;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class ProfessorDisciplina implements Serializable {
	private static final long serialVersionUID = 7263041574525686324L;
	
	@EmbeddedId
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
