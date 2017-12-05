package edu.neu.finalproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.finalproject.DAOs.InvoiceDAO;
import edu.neu.finalproject.model.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService {
 
    @Autowired
    private InvoiceDAO invoiceDAO;
 
    @Transactional
    public void addInvoice(Invoice a) {
    	invoiceDAO.addInvoice(a);
    }
 
    @Transactional
    public List<Invoice> listInvoice() {
 
        return invoiceDAO.listInvoice();
    }
 
    @Transactional
    public void removeInvoice(String id) {
    	invoiceDAO.removeInvoice(id);
    }
    
    @Transactional
    public List<Invoice> patientInvoice(String s) {
    	System.out.println("service");
        return invoiceDAO.patientInvoice(s);
    }
    
    
    
}
