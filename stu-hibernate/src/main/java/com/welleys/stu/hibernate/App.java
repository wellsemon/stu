package com.welleys.stu.hibernate;

import com.welleys.stu.hibernate.bean.po.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    private static Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx  = session.beginTransaction();

        List list= session.getNamedQuery("all").list();
        for(Object obj : list){
            logger.info(((Student) obj).getName());
        }

        tx.commit();
        session.close();
    }
}
