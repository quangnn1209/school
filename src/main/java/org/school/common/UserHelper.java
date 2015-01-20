package org.school.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.school.hibernate.HibernateUtility;
import org.school.persisted.User;

public class UserHelper {
	public static User getPersistantObject(User user) {
		Session hibernateSession = null;
		Transaction transaction = null;
		try {
			hibernateSession = HibernateUtility.getSessionFactory().openSession();
			transaction = hibernateSession.beginTransaction();
			user = (User) hibernateSession.get(User.class, user.getId());
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("object not saved  - " + e.getMessage());
		} finally {
			hibernateSession.close();
		}
		return user;
	}

	public static User doLogin(User user) {
		Session hibernateSession = null;
		Transaction transaction = null;
		try {
			hibernateSession = HibernateUtility.getSessionFactory().openSession();
			transaction = hibernateSession.beginTransaction();
			user = (User) hibernateSession.createCriteria(User.class).add(Restrictions.eq("email", user.getEmail()))
					.add(Restrictions.eq("password", user.getPassword())).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("object not saved  - " + e.getMessage());
		} finally {
			hibernateSession.close();
		}
		return user;
	}

	public static long saveOrUpdate(User user) {
		Session hibernateSession = null;
		Transaction transaction = null;
		try {
			hibernateSession = HibernateUtility.getSessionFactory().openSession();
			transaction = hibernateSession.beginTransaction();
			hibernateSession.saveOrUpdate(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("object not saved  - " + e.getMessage());
		} finally {
			hibernateSession.close();
		}
		return user.getId();
	}

	@SuppressWarnings("unchecked")
	public static List<User> getAllUsers() {
		Session hibernateSession = null;
		Transaction transaction = null;
		List<User> objectList = new ArrayList<User>();
		try {
			hibernateSession = HibernateUtility.getSessionFactory().openSession();
			transaction = hibernateSession.beginTransaction();
			objectList = hibernateSession.createCriteria(User.class).list();
			transaction.commit();
		} catch (HibernateException he) {
			if (transaction != null)
				transaction.rollback();
			System.err.println(he.getMessage());
		}
		return objectList;
	}

	public static void delete(User user) {
		Session hibernateSession = null;
		Transaction transaction = null;
		try {
			hibernateSession = HibernateUtility.getSessionFactory().openSession();
			transaction = hibernateSession.beginTransaction();
			user = (User) hibernateSession.createCriteria(User.class).add(Restrictions.eq("id", user.getId())).uniqueResult();
			hibernateSession.delete(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("Could not delete node - " + e.getMessage());
		} finally {
			hibernateSession.close();
		}
	}

	public static String md5(String input) {
		String md5 = null;
		if (null == input)
			return null;
		try {
			// Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");

			// Update input string in message digest
			digest.update(input.getBytes(), 0, input.length());

			// Converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}
}
