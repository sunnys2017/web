package edu.neu.finalproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.finalproject.DAOs.UserAccountDAO;
import edu.neu.finalproject.model.UserAccount;

@Service
public class UserAccountServiceImpl implements UserAccountService {
 
    @Autowired
    private UserAccountDAO userAccountDAO;
 
    @Transactional
    public void addUserAccount(UserAccount a) {
    	userAccountDAO.addUserAccount(a);
    }
 
    @Transactional
    public List<UserAccount> listUserAccount() {
 
        return userAccountDAO.listUserAccount();
    }
 
    @Transactional
    public void removeUserAccount(String id) {
    	userAccountDAO.removeUserAccount(id);
    }
    @Transactional
    public UserAccount findUserAccount(String userName) {
    	return userAccountDAO.findUserAccount(userName);
    }
    @Transactional
    public boolean checkUserAccount(String userName,String password){
    	return userAccountDAO.checkUserAccount(userName, password);
    }
    @Transactional
    public boolean checkUserName(String userName){
    	return userAccountDAO.checkUserName(userName);
    }
    @Transactional
    public void searchUAListByEntID(String entID){
    	userAccountDAO.searchUAListByEntID(entID);
    }
}
