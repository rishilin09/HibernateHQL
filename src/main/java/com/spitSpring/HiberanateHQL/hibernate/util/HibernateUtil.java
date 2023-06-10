package com.spitSpring.HiberanateHQL.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
//			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//			SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			return sessionFactory;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}