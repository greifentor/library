package de.ollie.library.service.impl;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.ollie.library.service.persistence.port.RackPersistencePort;
import de.ollie.library.service.so.RackSO;

/**
 * Unit tests for class "RackServiceImpl".
 * 
 * @author ollie
 *
 */
@ExtendWith(MockitoExtension.class)
public class RackServiceImplTest {

	@Mock
	private RackPersistencePort rackPersistencePort;

	@InjectMocks
	private RackServiceImpl unitUnderTest;

	@Test
	public void findById_CallsTheFindByIdMethodOfTheRackPersistencePort() {
		// Prepare
		long id = 42;
		String name = "name";
		RackSO so = new RackSO().setId(id).setName(name);
		Optional<RackSO> expected = Optional.of(so);
		when(this.rackPersistencePort.findById(id)).thenReturn(Optional.of(so));
		// Run
		Optional<RackSO> returned = this.unitUnderTest.findById(id);
		// Check
		assertThat(returned, equalTo(expected));
	}

}