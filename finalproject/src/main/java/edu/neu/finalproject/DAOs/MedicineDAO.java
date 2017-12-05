package edu.neu.finalproject.DAOs;

import java.util.List;

import edu.neu.finalproject.model.Medicine;



public interface MedicineDAO {
	
    public void addMedicine(Medicine medicine);
    public List<Medicine> listMedicine();
    public void removeMedicine(String id);	



}
