package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            System.out.println("Creating 3 student objects");
            Student tempStudent1 = new Student("Roman", "Spak", "roman.spak@akademiasovy.sk");
            Student tempStudent2 = new Student("Jan", "Pavuk", "jan.pavuk@akademiasovy.sk");
            Student tempStudent3 = new Student("Tomas", "Varga", "tomas.varga@akademiasovy.sk");

            session.beginTransaction();

            System.out.println("Saving the students");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();

            System.out.println("Done!");




        }
        finally {
            factory.close();
        }

    }
}
