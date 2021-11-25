package com.labforward.notebook.service;

import java.util.List;
import java.util.stream.Stream;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.labforward.notebook.model.Notes;
import com.labforward.notebook.results.Results;

@Service
public class NotepadImp implements Notepad {
	private Notes notes;
	private Results result;

	@Override
	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	@Override
	public long wordsFound(String key) {
		return Stream.of(notes.getText().split(" "))
				.map(s->removePunctions(s))
				.filter(s->StringUtils.equals(s, key))
				.count();
	}

	public static String removePunctions(String str) {
		return str.replaceAll("\\p{Punct}", "");
	}

	@Override
	public List<String> similarWord(String key) {
		return Stream.of(notes.getText().split(" "))
				.map(s->removePunctions(s))
				.filter(s->StringUtils.getLevenshteinDistance(s, key)==1)
				.toList();
	}

	@Override
	public Results wordsRelated(String key) {
		result= new Results();
		if(StringUtils.isBlank(key)|| isNotesNull())
			return result;
		
		result.setWordsFound(wordsFound(key));
		result.setSimilarWords(similarWord(key));
		
		return result;
	}

	private boolean isNotesNull() {
		return notes==null;
	}

}
