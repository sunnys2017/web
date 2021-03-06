package edu.neu.finalproject.DAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.finalproject.model.Doctor;



@Repository
public class DoctorDAOImpl implements DoctorDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
 
    public void addDoctor(Doctor contact) {
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
        session.save(contact);
        tx.commit();
        session.close();
    }
 
    @SuppressWarnings("unchecked")
	public List<Doctor> listDoctor() {
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	List<Doctor> list= session.createQuery("from Doctor").list();
    	tx.commit();
    	session.close();
        return list;
        }
 
    @SuppressWarnings("unchecked")
	public List<Doctor> searchDoctor(String department) {
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	List<Doctor> list= session.createQuery("from Doctor as d where d.department="+"'"+department+"'").list();
    	tx.commit();
    	session.close();
        return list;
        }
    
    public void removeDoctor(String id) {
    	Session session=sessionFactory.openSession();
    	Doctor contact = (Doctor) session.load(
    			Doctor.class, id);
    	Transaction tx=session.beginTransaction();
        if (null != contact) {
        	session.delete(contact);
        }
    	tx.commit();
    	session.close();
    }
    public Doctor findDoctor(String id){
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	//Doctor list= (Doctor) session.createQuery("from Doctor where doctorID=id");
    	Doctor contact = (Doctor) session.get(
    			Doctor.class, id);
    	tx.commit();
    	session.close();
        return contact;
    }

/*
	public UserAccount getUserAccount(UserAccount account){
		Configuration configuration = new Configuration().configure();

		// Create a configuration based on the properties file we've put
        // in hibernate.examples.dao
        Configuration config = 
        	new Configuration().setProperties(ConfigHelper.getConfigProperties("edu/neu/finalproject/dao/hibernate-mysql.properties"));
        
        // Tell it about the classes we want mapped, taking advantage of
        // the way we' ve named their mapping documents.
        config.addClass(UserAccount.class);
        
        // Get the session factory we can use for persistence
        SessionFactory sessionFactory = config.buildSessionFactory();
        
		Session session = sessionFactory.openSession();
	    Transaction tx = null;
	    try {
	    	// Create data and persist it
            tx = session.beginTransaction() ;
	    	
            session.save(account);
	  
            // We're done; make our changes permanent
            tx.commit() ; 
        } catch (Exception e) {
            if (tx != null) {
                // Something went wrong; discard all partial changes
                tx.rollback( ) ;
            }
            throw e;
        } finally {
            // No matter what, close the session
            session.close() ;
        }
        // Clean up after ourselves
        sessionFactory.close();
		return account;
	}

	
	
	
*/

}
