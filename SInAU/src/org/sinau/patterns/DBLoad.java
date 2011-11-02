package org.sinau.patterns;

import java.lang.reflect.Field;

import org.hibernate.Session;
import org.sinau.beans.Usuario;
import org.sinau.db.DBManager;

public class DBLoad extends DBCommand {

	@Override
	public void execute(Object o) {
		Session session = DBManager.getSession();
		Integer id = null;
		
		try {
			Field[] fields = o.getClass().getDeclaredFields();
			int i = 0;
			boolean acabou = false;
			while (!acabou) {
				Field field = fields[i];
				if (field.getAnnotation(javax.persistence.Id.class) != null) {
					acabou = true;
					String fieldName = field.getName();
					fieldName = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
					String getId = "get" + fieldName;
					id = (Integer) o.getClass().getMethod(getId, null).invoke(o, new Object[] {});
				} else {
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.load(o, id);
	}
	
	public static void main (String[] args) {
		Session session = DBManager.getSession();
		session.beginTransaction();
		
		Usuario u = new Usuario();
		u.setIdusuario(2);
		
		new DBLoad().execute(u);
		System.out.println(u);
		
		session.getTransaction().commit();
	}
}
