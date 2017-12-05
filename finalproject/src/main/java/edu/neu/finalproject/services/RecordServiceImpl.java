package edu.neu.finalproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.finalproject.DAOs.RecordDAO;
import edu.neu.finalproject.model.Appointment;
import edu.neu.finalproject.model.Record;

@Service
public class RecordServiceImpl implements RecordService {
 
    @Autowired
    private RecordDAO recordDAO;
 
    @Transactional
    public void addRecord(Record a) {
    	recordDAO.addRecord(a);
    }
 
    @Transactional
    public List<Record> listRecord() {
 
        return recordDAO.listRecord();
    }
 
    @Transactional
    public void removeRecord(String id) {
    	recordDAO.removeRecord(id);
    }
    @Transactional
    public Record findRecord(String id) {
    	return recordDAO.findRecord(id);
    }
}
