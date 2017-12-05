package edu.neu.finalproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.neu.finalproject.DAOs.MedicineDAO;
import edu.neu.finalproject.model.Medicine;

@Service
public class MedicineServiceImpl implements MedicineService {
 
    @Autowired
    private MedicineDAO medicineDAO;
 
    @Transactional
    public void addMedicine(Medicine a) {
    	medicineDAO.addMedicine(a);
    }
 
    @Transactional
    public List<Medicine> listMedicine() {
 
        return medicineDAO.listMedicine();
    }
 
    @Transactional
    public void removeMedicine(String id) {
    	medicineDAO.removeMedicine(id);
    }
}
