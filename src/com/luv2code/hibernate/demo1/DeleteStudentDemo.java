package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class DeleteStudentDemo {

    public static void main(String [] args) {

        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            int studentId = 1;
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id:" +studentId);
            Student myStudent = session.get(Student.class, studentId);
            //System.out.println("Deleting student:" +myStudent);
            //session.delete(myStudent);
            System.out.println("Deleting student Id=2");
            session.createQuery("delete from Student where id=2 ").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }



    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

}
