package edu.neu.finalproject.DAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.finalproject.model.Doctor;
import edu.neu.finalproject.model.UserAccount;


@Repository
public class UserAccountDAOImpl implements UserAccountDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
 
    public void addUserAccount(UserAccount contact) {
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
        session.save(contact);
        tx.commit();
        session.close();
    }
 
    @SuppressWarnings("unchecked")
	public List<UserAccount> listUserAccount() {
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	List<UserAccount> list= session.createQuery("from UserAccount").list();
    	tx.commit();
    	session.close();
        return list;
        }
 
    public void removeUserAccount(String id) {
    	Session session=sessionFactory.openSession();
    	UserAccount contact = (UserAccount) session.load(
    			UserAccount.class, id);
    	Transaction tx=session.beginTransaction();
        if (null != contact) {
        	session.delete(contact);
        }
    	tx.commit();
    	session.close();
    }
    public UserAccount findUserAccount(String id){
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	UserAccount contact = (UserAccount) session.get(
    			UserAccount.class, id);
    	tx.commit();
    	session.close();
    	return contact;
    }
    
    @SuppressWarnings("unchecked")
    public boolean checkUserAccount(String userName,String password){
    	boolean flag = false;
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	List<UserAccount> list= session.createQuery("from UserAccount as u where u.userName ="+"'"+userName+"'" +"and u.password ="+"'"+password+"'").list();
    	if(list.size()==0){
    		flag=false;
    	}else{
    		flag=true;
    	}
    	tx.commit();
    	session.close();
    	return flag;
    }
    
    @SuppressWarnings("unchecked")
    public boolean checkUserName(String userName){
    	boolean flag = false;
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	List<UserAccount> list= session.createQuery("from UserAccount as u where u.userName ="+"'"+userName+"'").list();
    	if(list.size()==0){
    		flag=false;
    	}else{
    		flag=true;
    	}
    	tx.commit();
    	session.close();
    	return flag;
    }
    
    @SuppressWarnings("unchecked")
	public void searchUAListByEntID(String entID) {
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	List<UserAccount> list= session.createQuery("from UserAccount as ua where ua.ssn="+"'"+entID+"'").list();
    	for(int i=0;i<list.size();i++){
    		UserAccount ua = list.get(i);
    		if(ua!=null){
    			session.delete(ua);
    		}
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
