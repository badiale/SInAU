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
	
	public Disciplina getDisciplina() {
		return alunoDisciplinaPK.getDisciplina();
	}
	public Usuario getUsuario() {
		return alunoDisciplinaPK.getUsuario();
	}
	public void setDisciplina(Disciplina disciplina) {
		alunoDisciplinaPK.setDisciplina(disciplina);
	}
	public void setUsuario(Usuario usuario) {
		alunoDisciplinaPK.setUsuario(usuario);
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
	
	@SuppressWarnings("unchecked")
	public static List<AlunoDisciplina> findAll() {
		Session session = DBManager.getSession();
		String hql = "from AlunoDisciplina";
		org.hibernate.Query query = session.createQuery(hql);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Disciplina> findDisciplinaByAluno(int id) {
		Session session = DBManager.getSession();
		String hql = "Select d from Disciplina d, AlunoDisciplina ad where d.iddisciplina = ad.alunoDisciplinaPK.disciplina and ad.alunoDisciplinaPK.usuario = " + id + " order by d.iddisciplina";
		org.hibernate.Query query = session.createQuery(hql);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Aluno> findAlunoByDisciplina(int id) {
		Session session = DBManager.getSession();
		String hql = "Select a from Aluno a, AlunoDisciplina ad where a.idaluno = ad.alunoDisciplinaPK.usuario AND ad.alunoDisciplinaPK.disciplina = " + id + " order by a.idaluno";
		org.hibernate.Query query = session.createQuery(hql);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Aluno> findAlunoBolsistaByDisciplina(int id) {
		Session session = DBManager.getSession();
		String hql = "Select a from Aluno a, AlunoDisciplina ad where a.bolsista = true AND a.idaluno = ad.alunoDisciplinaPK.usuario AND ad.alunoDisciplinaPK.disciplina = " + id + " order by a.idaluno";
		org.hibernate.Query query = session.createQuery(hql);
		return query.list();
	}
	
	public static void main (String[] args) {
		Session session = DBManager.getSession();
		session.beginTransaction();
		
		System.out.println("byAluno");
		for (Object obj : AlunoDisciplina.findDisciplinaByAluno(5))
			System.out.println(obj);
		
		System.out.println("byDisciplina");
		for (Object obj : AlunoDisciplina.findAlunoByDisciplina(1))
			System.out.println(obj);
		
		System.out.println("BolsistabyDisciplina");
		for (Object obj : AlunoDisciplina.findAlunoBolsistaByDisciplina(1))
			System.out.println(obj);
		
		session.getTransaction().commit();
	}
}
