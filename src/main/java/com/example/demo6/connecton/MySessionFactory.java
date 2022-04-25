package com.example.demo6.connecton;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {

    private static class GetSession {
        private static final SessionFactory sessionFactory;

        static {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        }
    }

    public static Session openSession(){
        return GetSession.sessionFactory.openSession();
    }
}
