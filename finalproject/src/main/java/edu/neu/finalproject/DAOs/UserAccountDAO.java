package edu.neu.finalproject.DAOs;

import java.util.List;

import edu.neu.finalproject.model.UserAccount;

public interface UserAccountDAO {
	
	    public void addUserAccount(UserAccount contact);
	    public List<UserAccount> listUserAccount();
	    public void removeUserAccount(String id);	
        public UserAccount findUserAccount(String userName);
        public boolean checkUserAccount(String userName,String password);
        public boolean checkUserName(String userName);
        public void searchUAListByEntID(String entID) ;
}
