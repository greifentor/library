package de.ollie.library.persistence.adapter;

import java.util.Optional;

import org.springframework.stereotype.Service;

import de.ollie.library.persistence.model.RackDBO;
import de.ollie.library.persistence.repository.RackRepository;
import de.ollie.library.service.model.Rack;
import de.ollie.library.service.persistence.port.RackPersistencePort;

/**
 * An implementation of the rack persistence port interface for RDBMS.
 *
 * @author ollie
 *
 */
@Service
public class RackRDBMSPersistenceAdapter implements RackPersistencePort {

	private final RackRepository rackRepository;

	public RackRDBMSPersistenceAdapter(RackRepository rackRepository) {
		super();
		this.rackRepository = rackRepository;
	}

	@Override
	public Optional<Rack> findById(long id) {
		Optional<RackDBO> dbo = this.rackRepository.findById(id);
		if (dbo.isEmpty()) {
			return Optional.empty();
		}
		RackDBO rack = dbo.get();
		return Optional.of(new Rack().setId(rack.getId()).setName(rack.getName())); // CONVERTER !!!
	}

}