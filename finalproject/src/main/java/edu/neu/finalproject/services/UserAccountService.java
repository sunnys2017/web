package edu.neu.finalproject.services;

import java.util.List;

import edu.neu.finalproject.model.UserAccount;

public interface UserAccountService {
 
    public void addUserAccount(UserAccount c);
    public List<UserAccount> listUserAccount();
    public void removeUserAccount(String id);
    public UserAccount findUserAccount(String userName);
    public boolean checkUserAccount(String userName,String password);
    public boolean checkUserName(String userName);
    public void searchUAListByEntID(String entID) ;
}
