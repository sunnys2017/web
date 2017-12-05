package edu.neu.finalproject.DAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.finalproject.model.Invoice;


@Repository
public class InvoiceDAOImpl implements InvoiceDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
 
    public void addInvoice(Invoice contact) {
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
        session.save(contact);
        tx.commit();
        session.close();
    }
 
    @SuppressWarnings("unchecked")
	public List<Invoice> listInvoice() {
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	List<Invoice> list= session.createQuery("from Invoice").list();
    	tx.commit();
    	session.close();
        return list;
        }
 
    public void removeInvoice(String id) {
    	Session session=sessionFactory.openSession();
    	Invoice contact = (Invoice) session.load(
    			Invoice.class, id);
    	Transaction tx=session.beginTransaction();
        if (null != contact) {
        	session.delete(contact);
        }
    	tx.commit();
    	session.close();
    }
    @SuppressWarnings("unchecked")
	public List<Invoice> patientInvoice(String s) {
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	List<Invoice> list= session.createQuery("from Invoice as i where i.patientID="+"'"+s+"'").list();
    	//System.out.println(list.size());
    	tx.commit();
    	session.close();
        return list;
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
