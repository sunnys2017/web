package edu.neu.finalproject.DAOs;

import java.util.List;

import edu.neu.finalproject.model.Invoice;



public interface InvoiceDAO {
	
    public void addInvoice(Invoice invoice);
    public List<Invoice> listInvoice();
    public void removeInvoice(String id);	
    public List<Invoice> patientInvoice(String s);

}
