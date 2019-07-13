package de.ollie.library.persistence.adapter;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.ollie.library.persistence.converter.RackDBOConverter;
import de.ollie.library.persistence.dbo.RackDBO;
import de.ollie.library.persistence.repository.RackRepository;
import de.ollie.library.service.so.RackSO;

/**
 * Unit tests for class "RackRDBMSPersistenceAdapter".
 * 
 * @author ollie
 *
 */
@ExtendWith(MockitoExtension.class)
public class RackRDBMSPersistenceAdapterTest {

	@Mock
	private RackDBOConverter rackConverter;
	@Mock
	private RackRepository rackRepository;

	@InjectMocks
	private RackRDBMSPersistenceAdapter unitUnderTest;

	@Test
	public void findById_PassANotExistingId_ReturnsAnEMptyOptional() {
		// Prepare
		long id = 42;
		Optional<RackSO> expected = Optional.empty();
		Optional<RackDBO> dbo = Optional.empty();
		when(this.rackRepository.findById(id)).thenReturn(dbo);
		// Run
		Optional<RackSO> returned = this.unitUnderTest.findById(id);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void findById_PassAnExistingId_ReturnsTheRackDeliveredFromRepository() {
		// Prepare
		// Prepare
		long id = 42;
		String name = "name";
		Optional<RackSO> expected = Optional.of(new RackSO().setId(id).setName(name));
		Optional<RackDBO> dbo = Optional.of(new RackDBO().setId(id).setName(name));
		when(this.rackRepository.findById(id)).thenReturn(dbo);
		when(this.rackConverter.convertDBOToSO(dbo.get())).thenReturn(expected.get());
		// Run
		Optional<RackSO> returned = this.unitUnderTest.findById(id);
		// Check
		assertThat(returned, equalTo(expected));
		// Run
		// Check
	}

}