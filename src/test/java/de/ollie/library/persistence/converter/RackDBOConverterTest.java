package de.ollie.library.persistence.converter;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import de.ollie.library.persistence.dbo.RackDBO;
import de.ollie.library.service.so.RackSO;

/**
 * Unit tests for class "RackDBOConverter".
 *
 * @author ollie
 *
 */
@ExtendWith(MockitoExtension.class)
public class RackDBOConverterTest {

	@InjectMocks
	private RackDBOConverter unitUnderTest;

	@Test
	public void convertDBOToSO_PassANullValue_ReturnsANullValue() {
		// Prepare
		RackDBO passed = null;
		// Run
		RackSO returned = this.unitUnderTest.convertDBOToSO(passed);
		// Check
		assertThat(returned, nullValue());
	}

	@Test
	public void convertDBOToSO_PassARackDBO_ReturnsARackSOWithValueOfThePassedRackDBO() {
		// Prepare
		long id = 42;
		String name = "name";
		RackDBO passed = new RackDBO().setId(id).setName(name);
		RackSO expected = new RackSO().setId(id).setName(name);
		// Run
		RackSO returned = this.unitUnderTest.convertDBOToSO(passed);
		// Check
		assertThat(returned, equalTo(expected));
	}

}