package edu.neu.finalproject.services;

import java.util.List;

import edu.neu.finalproject.model.Invoice;

public interface InvoiceService {
 
    public void addInvoice(Invoice c);
    public List<Invoice> listInvoice();
    public void removeInvoice(String id);
    public List<Invoice> patientInvoice(String id);
}
