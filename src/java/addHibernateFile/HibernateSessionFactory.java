/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addHibernateFile;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;
    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null || sessionFactory.isClosed()){
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
    
}
