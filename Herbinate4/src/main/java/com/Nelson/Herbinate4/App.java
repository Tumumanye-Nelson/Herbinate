package com.Nelson.Herbinate4;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args )
    
    {
    	StudentNames st = new StudentNames();
    	st.setFname("Peter");
    	st.setLname("sema");
    	st.setMname("Elder");
    	Student 	student  = new 	Student();
    	student.setAge(44);
    	student.setRollno(777);
    	student.setName(st);
    	
    	Configuration con = new 	Configuration ().configure().addAnnotatedClass(Student.class);
    	ServiceRegistry sr = new ServiceRegistryBuilder().applySettings( con.getProperties()).buildServiceRegistry();
    	SessionFactory  ss= con.buildSessionFactory(sr); 
    	Session session =ss.openSession(); 
    	Transaction tr  =  session.beginTransaction();
    	session.save(student);
    	tr .commit();
    	System.out.println(student );
    }
}
