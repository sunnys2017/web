package edu.neu.finalproject.DAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.finalproject.model.Admin;




@Repository
public class AdminDAOImpl implements AdminDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
 
    public void addAdmin(Admin a) {
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
        session.save(a);
        tx.commit();
        session.close();
    }
 
    @SuppressWarnings("unchecked")
	public List<Admin> listAdmin() {
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	List<Admin> list= session.createQuery("from Admin").list();
    	tx.commit();
    	session.close();
        return list;
        
    }
 
    public void removeAdmin(String id) {
    	Session session=sessionFactory.openSession();
    	Admin contact = (Admin) session.load(
    			Admin.class, id);
    	Transaction tx=session.beginTransaction();
        if (null != contact) {
        	session.delete(contact);
        }
    	tx.commit();
    	session.close();
    }
    
    public Admin findAdmin(String id){
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	Admin contact = (Admin) session.get(
    			Admin.class, id);
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
