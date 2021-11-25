package com.labforward.notebook.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labforward.notebook.model.Notes;
import com.labforward.notebook.results.Results;

@SpringBootTest
@AutoConfigureMockMvc
class NotebookControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void getHome_shouldReturnSucces() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	@Test
	public void searchKey_shouldReturn1wordFound() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/Search").param("searchKey", "key")
					.param("notes","The key that is returned")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	} 
}
