package de.ollie.library.rest.v1.converter;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import de.ollie.library.rest.v1.dto.RackDTO;
import de.ollie.library.service.so.RackSO;

/**
 * Unit tests for class "RackRESTConverter".
 *
 * @author ollie
 *
 */
@ExtendWith(MockitoExtension.class)
public class RackRESTConverterTest {

	@InjectMocks
	private RackRESTConverter unitUnderTest;

	@Test
	public void convertSOToDTO_PassANullValue_ReturnsANullValue() {
		// Run
		RackDTO returned = this.unitUnderTest.convertSOToDTO(null);
		// Check
		assertThat(returned, nullValue());
	}

	@Test
	public void convertSOToDTO_PassAServiceObject_ReturnsADTOWithTheDataOfTheSO() {
		// Prepare
		long id = 42;
		String name = "name";
		RackSO so = new RackSO().setId(id).setName(name);
		RackDTO expected = new RackDTO().setId(id).setName(name);
		// Run
		RackDTO returned = this.unitUnderTest.convertSOToDTO(so);
		// Check
		assertThat(returned, equalTo(expected));
	}

}