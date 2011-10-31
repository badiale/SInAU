package org.sinau.patterns;

import org.hibernate.Session;
import org.sinau.db.DBManager;

public class DBSave extends DBCommand {

	@Override
	public void execute(Object o) {
		Session session = DBManager.getSession();
		session.saveOrUpdate(o);
	}

}
