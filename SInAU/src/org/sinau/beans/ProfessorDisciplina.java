package org.sinau.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class ProfessorDisciplina implements Serializable {
	@Id
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
