package com.labforward.notebook.words;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.labforward.notebook.model.Notes;
import com.labforward.notebook.model.Notes;
import com.labforward.notebook.results.Results;
import com.labforward.notebook.service.Notepad;
import com.labforward.notebook.service.NotepadImp;
@SpringBootTest
class NotepadTest  {
    private Notes noteFolder=new Notes("A single digital folder can replace multiple physical folders");
    private Notes notePunctions=new Notes("Mary wrote only a few words; but each word had great impact");
    private Notes noteWords=new Notes("Words word Word Lord Ford work ward");
    
    @Autowired
	private Notepad notepad;	
    
    @Test
	void wordsFound_shouldReturn1() {
		notepad.setNotes(noteFolder);
		long count = notepad.wordsFound("folder");
		assertEquals(1, count);
	}
	@Test
	void similarWord_shouldReturnFolders() {
		notepad.setNotes(noteFolder);
		List<String> similar = notepad.similarWord("folder");
		assertEquals(List.of("folders"), similar);
	}
	@Test
	void wordsFound_shouldReturn1IgnoringPuncation() {
		notepad.setNotes(notePunctions);
		long count = notepad.wordsFound("words");
		assertEquals(1, count);
	}
	@Test
	void similarWord_shouldReturnWordsIgnoringPuncations() {
		notepad.setNotes(notePunctions);
		List<String> similar = notepad.similarWord("word");
		assertEquals(List.of("words"), similar);
	}
	@Test
	void wordListArray_shouldReturn4SimilarWords() {
		notepad.setNotes(noteWords);
		List<String> similar = notepad.similarWord("word");
		assertEquals(List.of("Word", "Lord","Ford","work" ,"ward"), similar);
	}
	@Test
	void wordListArray_shouldReturn1WordFound() {
		notepad.setNotes(noteWords);
		long count = notepad.wordsFound("word");
		assertEquals(count, 1);
	}
	
	@Test
	void removePunction_shouldReturnStringsWithAllPuncationsRemoved() {
		String actual=NotepadImp.removePunctions("1a2!b@3c#4d%e^f&g*h(i)j{k}l:m;n/.,o[p~]q\\r`s><t?/");
		assertEquals("1a2b3c4defghijklmnopqrst", actual);
	}
	@ParameterizedTest
	@CsvSource({"IsaacNewton, Isaac:Newton", "CharlesRobertDarwin, Charles-Robert-Darwin"})
	void removePunction_shouldReturnStrings(String expectedFullName,
			String inputFullName) {
		String actual=NotepadImp.removePunctions(inputFullName);
		assertEquals(expectedFullName, actual);
	}
	
	@Test
	void wordsRelated_shouldReturnEmptyResult(){
	    Results results=notepad.wordsRelated(null);
	    assertEquals(new Results().toString(),results.toString());
	}
	@Test
	void wordsRelated_shouldReturnEmptyResultWhenNotesIsNULL(){
	    Results results=notepad.wordsRelated("key");
	    assertEquals(new Results().toString(),results.toString());
	}
	@Test
	void wordsRelated_shouldReturnEmptyResultWhenKeyIsNULL(){
	    notepad.setNotes(noteFolder);
	    Results results=notepad.wordsRelated(null);
	    assertEquals(new Results().toString(),results.toString());
	}
	@Test
	void wordsRelated_shouldReturnEmptyResultWhenKeyNotesNotNULL(){
	    notepad.setNotes(noteFolder);
	    Results results=notepad.wordsRelated("folder");
	    assertEquals(new Results(1,List.of("folders")).toString(),results.toString());
	}
}
