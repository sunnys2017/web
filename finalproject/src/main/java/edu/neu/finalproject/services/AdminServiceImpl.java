package edu.neu.finalproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.neu.finalproject.DAOs.AdminDAO;
import edu.neu.finalproject.model.Admin;

@Service
public class AdminServiceImpl implements AdminService {
 
    @Autowired
    private AdminDAO adminDAO;
 
    @Transactional
    public void addAdmin(Admin a) {
    	adminDAO.addAdmin(a);
    }
 
    @Transactional
    public List<Admin> listAdmin() {
 
        return adminDAO.listAdmin();
    }
 
    @Transactional
    public void removeAdmin(String id) {
    	adminDAO.removeAdmin(id);
    }
    @Transactional
    public Admin findAdmin(String id) {
    	return adminDAO.findAdmin(id);
    }
}
