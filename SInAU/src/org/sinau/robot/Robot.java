package org.sinau.robot;

import java.util.List;

import org.hibernate.Session;
import org.sinau.beans.Curso;
import org.sinau.beans.Departamento;
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
				"disciplinas"
		};
		
		Session session = DBManager.getSession();
		session.beginTransaction();
		
		for (String item : lista) {
			System.out.print("Inserindo " + item + "...");
			@SuppressWarnings("rawtypes")
			List webservice = service.create(item);
			for (Object o : webservice)
				comm.execute(o);
			
			System.out.println(" pronto.");
		}
		
		Curso c = Curso.load(1);
		System.out.println(c);
		System.out.println(c.getDisciplinas());
		
		session.getTransaction().commit();
	}
}
