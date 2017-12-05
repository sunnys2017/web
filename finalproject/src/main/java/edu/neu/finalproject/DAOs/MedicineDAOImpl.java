package edu.neu.finalproject.DAOs;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import edu.neu.finalproject.model.Medicine;



@Repository
public class MedicineDAOImpl implements MedicineDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
 
    public void addMedicine(Medicine contact) {
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
        session.save(contact);
        tx.commit();
        session.close();
    }
 
    @SuppressWarnings("unchecked")
	public List<Medicine> listMedicine() {
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	List<Medicine> list= session.createQuery("from Medicine").list();
    	tx.commit();
    	session.close();
        return list;
        }
 
    public void removeMedicine(	String id) {
    	Session session=sessionFactory.openSession();
    	Medicine contact = (Medicine) session.load(
    			Medicine.class, id);
    	Transaction tx=session.beginTransaction();
        if (null != contact) {
        	session.delete(contact);
        }
    	tx.commit();
    	session.close();
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
