package com.labforward.notebook.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.labforward.notebook.model.Notes;
import com.labforward.notebook.results.Results;
import com.labforward.notebook.service.Notepad;

@Controller
public class NotebookController {
  
  @Autowired
  Notepad notebook;
  
  @RequestMapping("/")
  public String homePage(){
	  return "home"; 
  }
  
  @PostMapping("/Search")
  public String searchKey( @RequestParam ("notes")Notes notes, 
		  @RequestParam ("searchKey")String key,
		  Map<String, Object> model) {
	  
	  notebook.setNotes(notes);
	  model.put("results", notebook.wordsRelated(key));
	  model.put("notes", notes);
	  model.put("searchKey", key);
	  return "home"; 
	  
  }
  
}
