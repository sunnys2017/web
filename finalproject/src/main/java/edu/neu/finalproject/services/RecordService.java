package edu.neu.finalproject.services;

import java.util.List;

import edu.neu.finalproject.model.Record;

public interface RecordService {
 
    public void addRecord(Record c);
    public List<Record> listRecord();
    public void removeRecord(String id);
    public Record findRecord(String id) ;
}
