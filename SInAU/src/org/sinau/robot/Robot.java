package org.sinau.robot;

import java.util.List;

import org.hibernate.Session;
import org.sinau.beans.Administrador;
import org.sinau.beans.Professor;
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
				"professores"
		};
		
		Session session = DBManager.getSession();
		session.beginTransaction();
		
		for (String item : lista) {
			System.out.print("Inserindo " + item + "...");
			List webservice = service.create(item);
			for (Object o : webservice)
				comm.execute(o);
			
			System.out.println(" pronto.");
		}
		
		session.getTransaction().commit();
	}
}
