package org.sinau.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.Session;
import org.sinau.db.DBManager;

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

	public Disciplina getDisciplina() {
		return professorDisciplinaPK.getDisciplina();
	}
	public Usuario getUsuario() {
		return professorDisciplinaPK.getUsuario();
	}
	public void setDisciplina(Disciplina disciplina) {
		professorDisciplinaPK.setDisciplina(disciplina);
	}
	public void setUsuario(Usuario usuario) {
		professorDisciplinaPK.setUsuario(usuario);
	}
	
	@Override
	public String toString() {
		return "ProfessorDisciplina [professorDisciplinaPK="
				+ professorDisciplinaPK + "]";
	}
	
	@SuppressWarnings("unchecked")
	public static List<Disciplina> findDisciplinaByProfessor(int profId) {
		Session session = DBManager.getSession();
		String hql = "Select d from Disciplina d, ProfessorDisciplina pd where d.iddisciplina = pd.professorDisciplinaPK.disciplina AND pd.professorDisciplinaPK.usuario = " + profId;
		org.hibernate.Query query = session.createQuery(hql);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Professor> findProfessorByDisciplina(int id) {
		Session session = DBManager.getSession();
		String hql = "Select p from Professor p, ProfessorDisciplina pd where p.id = pd.professorDisciplinaPK.usuario AND pd.professorDisciplinaPK.disciplina = " + id;
		org.hibernate.Query query = session.createQuery(hql);
		return query.list();
	}
	
	public static void main (String[] args) {
		Session session = DBManager.getSession();
		session.beginTransaction();
		
		for (Object obj : ProfessorDisciplina.findDisciplinaByProfessor(130))
			System.out.println(obj);
		
		session.getTransaction().commit();
	}
}
