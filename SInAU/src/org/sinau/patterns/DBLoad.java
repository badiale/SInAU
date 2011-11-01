package org.sinau.patterns;

import java.lang.reflect.Field;

import org.hibernate.Session;
import org.sinau.db.DBManager;

public class DBLoad extends DBCommand {

	@Override
	public void execute(Object o) {
		Session session = DBManager.getSession();
		Integer id = null;
		
		try {
			Field field = o.getClass().getField("id");
			id = field.getInt(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.load(o, id);
	}
}
