package de.ollie.library.rest.v1.controller;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import de.ollie.library.rest.v1.converter.RackRESTConverter;
import de.ollie.library.rest.v1.dto.RackDTO;
import de.ollie.library.service.RackService;
import de.ollie.library.service.so.RackSO;

/**
 * UNit tests for class "RackRESTController".
 *
 * @author ollie
 *
 */
@ExtendWith(MockitoExtension.class)
public class RackRESTControllerTest {

	@Mock
	private RackRESTConverter rackRESTConverter;
	@Mock
	private RackService rackService;

	@InjectMocks
	private RackRESTController unitUnderTest;

	@Test
	public void findById_PassANotExistingId_ReturnsANotFound() throws Exception {
		// Prepare
		long id = 42;
		ResponseEntity<RackDTO> expected = ResponseEntity.notFound().build();
		Optional<RackSO> so = Optional.empty();
		when(this.rackService.findById(id)).thenReturn(so);
		// Run
		ResponseEntity<RackDTO> returned = this.unitUnderTest.findById(id);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void findById_PassAnExistingId_ReturnsARackDTOWithTheRack() throws Exception {
		// Prepare
		long id = 42;
		String name = "name";
		ResponseEntity<RackDTO> expected = ResponseEntity.ok().body(new RackDTO().setId(id).setName(name));
		Optional<RackSO> so = Optional.of(new RackSO().setId(id).setName(name));
		when(this.rackRESTConverter.convertSOToDTO(so.get())).thenReturn(expected.getBody());
		when(this.rackService.findById(id)).thenReturn(so);
		// Run
		ResponseEntity<RackDTO> returned = this.unitUnderTest.findById(id);
		// Check
		assertThat(returned, equalTo(expected));
	}

}