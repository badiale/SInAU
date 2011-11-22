package org.sinau.robot;

import java.util.List;

import org.hibernate.Session;
import org.sinau.beans.Usuario;
import org.sinau.db.DBManager;
import org.sinau.patterns.DBCommand;
import org.sinau.patterns.DBSave;
import org.sinau.patterns.ServiceFactory;

public class Robot {
	public static void main (String[] args) throws Exception {
		ServiceFactory service = new ServiceFactory();
		DBCommand comm = new DBSave();
		
		String[] lista = {
				"usuarios",
				"administradores",
				"alunos",
				"universidades",
				"departamentos",
				"professores",
				"cursos",
				"disciplinas",
				"profdisciplinas",
				"alunodisciplina"
		};
		
		Session session = DBManager.getSession();
		session.beginTransaction();
		
		Usuario u = null;
		
		// esse usuario nao existe
		u = new Usuario();
		u.setIdusuario(1);
		comm.execute(u);
		
		// esse usuario nao existe
		u = new Usuario();
		u.setIdusuario(28182);
		comm.execute(u);
		
		for (String item : lista) {
			System.out.print("Inserindo " + item + "...");
			@SuppressWarnings("rawtypes")
			List webservice = service.create(item);
			for (Object o : webservice)
				comm.execute(o);
			
			System.out.println(" pronto.");
		}
		
		/*Curso c = Curso.load(1);
		System.out.println(c);
		System.out.println(c.getDisciplinas());*/
		
		session.getTransaction().commit();
	}
}
