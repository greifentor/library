package de.ollie.library.rest.v1.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Integration tests for the rack REST controller.
 *
 * @author ollie
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RackRESTControllerIntegrationTest {

	@Autowired
	MockMvc mvc;

	@Test
	public void getRackWithExistingId_ReturnsRackDataAndStatusOk200() throws Exception {
		mvc.perform(get("/api/v1/racks/1") //
				.contentType(MediaType.APPLICATION_JSON)) //
				.andExpect(status().isOk()) //
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)) //
				.andExpect(jsonPath("name", is("Rack 1")));
	}

	@Test
	public void getRackWithAnUnexistingId_ReturnsStatusNotFound404() throws Exception {
		mvc.perform(get("/api/v1/racks/-1") //
				.contentType(MediaType.APPLICATION_JSON)) //
				.andExpect(status().isNotFound());
	}

}