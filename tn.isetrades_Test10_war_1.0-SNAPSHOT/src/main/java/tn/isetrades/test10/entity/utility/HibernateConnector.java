package tn.isetrades.test10.entity.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Rania
 */
public class HibernateConnector {

    private static HibernateConnector me;
    private Configuration cfg;
    private SessionFactory sessionFactory;

    private HibernateConnector() throws HibernateException {
        // build the config
        cfg = new Configuration().configure();

        sessionFactory = cfg.buildSessionFactory();
    }

    public static synchronized HibernateConnector getInstance() throws HibernateException {
        if (me == null) {
            me = new HibernateConnector();
        }
        return me;
    }

    public Session getSession() throws HibernateException {
        Session session = sessionFactory.openSession();
        if (!session.isConnected()) {
            this.reconnect();
        }
        return session;
    }

    private void reconnect() throws HibernateException {
        this.sessionFactory = cfg.buildSessionFactory();
    }
}
