package edu.neu.finalproject.services;

import java.util.List;


import edu.neu.finalproject.model.Admin;

public interface AdminService {
 
    public void addAdmin(Admin c);
    public List<Admin> listAdmin();
    public void removeAdmin(String id);
    public Admin findAdmin(String id);
}
