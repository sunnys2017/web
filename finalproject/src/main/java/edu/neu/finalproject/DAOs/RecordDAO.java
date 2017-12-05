package edu.neu.finalproject.DAOs;

import java.util.List;



import edu.neu.finalproject.model.Record;



public interface RecordDAO {
	   public void addRecord(Record r);
	    public List<Record> listRecord();
	    public void removeRecord(String id);	
	    public Record findRecord(String id);

}
