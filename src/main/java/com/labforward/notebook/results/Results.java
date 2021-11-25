package com.labforward.notebook.results;

import java.util.ArrayList;
import java.util.List;

public class Results {
	private long wordsFound;
	private List<String> similarWords;
	
	public Results() {
		similarWords = new ArrayList();
	}

	public Results(int wordsFound, List<String> similarWords) {
		this.wordsFound = wordsFound;
		this.similarWords = similarWords;
	}

	public void setWordsFound(long l) {
		this.wordsFound = l;
	}
	
	public long getWordsFound() {
		return wordsFound;
	}


	@Override
	public String toString() {
		return "Words Found:"+wordsFound+" Similar Words:"+similarWords;
	}

	public List<String> getSimilarWords() {
		return similarWords;
	}

	public void setSimilarWords(List<String> similarWords) {
		this.similarWords = similarWords;
	}
}
