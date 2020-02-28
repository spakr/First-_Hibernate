package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

    public static void main(String [] args) {

        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            System.out.println("Creating new student object");
            Student tempStudent = new Student("Roman", "Spak", "roman.spak@akademiasovy.sk");

            session.beginTransaction();

            System.out.println("Saving the student");
            session.save(tempStudent);

            session.getTransaction().commit();

            System.out.println("Done!");




        }
        finally {
            factory.close();
        }



    }

}
