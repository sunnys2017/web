package edu.neu.finalproject.DAOs;




import java.util.List;

import edu.neu.finalproject.model.Admin;


public interface AdminDAO {
	
    public void addAdmin(Admin admin);
    public List<Admin> listAdmin();
    public void removeAdmin(String id);	
    public Admin findAdmin(String id);	
	

}
