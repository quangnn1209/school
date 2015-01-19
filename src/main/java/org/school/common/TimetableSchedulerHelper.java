package org.school.common;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.school.hibernate.HibernateUtility;
import org.school.persisted.TimetableSchedule;

public class TimetableSchedulerHelper {

	@SuppressWarnings("unchecked")
	public static List<TimetableSchedule> getAllTs() {
		Session hibernateSession = null;
		Transaction transaction = null;
		List<TimetableSchedule> objectList = new ArrayList<TimetableSchedule>();
		try {
			hibernateSession = HibernateUtility.getSessionFactory().openSession();
			transaction = hibernateSession.beginTransaction();
			objectList = hibernateSession.createCriteria(TimetableSchedule.class).list();
			transaction.commit();
		} catch (HibernateException he) {
			if (transaction != null)
				transaction.rollback();
			System.err.println(he.getMessage());
		}
		return objectList;
	}
}
