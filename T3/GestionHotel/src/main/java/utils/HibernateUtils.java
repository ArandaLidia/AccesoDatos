package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.id.Configurable;

//Singlenton
//1º private static SessionFactory sessionFactory;

//2º
public class HibernateUtils {

  private static SessionFactory sessionFactory;

  public SessionFactory getSessionFactory(){
    if(sessionFactory == null){
     createSessionFactory();
    }
   return sessionFactory;
  }

  public void createSessionFactory(){
      sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
  }
}
