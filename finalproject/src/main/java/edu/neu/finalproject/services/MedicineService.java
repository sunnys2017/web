package edu.neu.finalproject.services;

import java.util.List;

import edu.neu.finalproject.model.Medicine;

public interface MedicineService {
 
    public void addMedicine(Medicine c);
    public List<Medicine> listMedicine();
    public void removeMedicine(String id);
}
