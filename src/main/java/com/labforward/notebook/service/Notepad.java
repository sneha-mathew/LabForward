package com.labforward.notebook.service;

import java.util.List;

import com.labforward.notebook.model.Notes;
import com.labforward.notebook.results.Results;

public interface Notepad {
    long wordsFound(String search);
    List<String> similarWord(String search);
	Results wordsRelated(String key);
	void setNotes(Notes notes); 
	
}
