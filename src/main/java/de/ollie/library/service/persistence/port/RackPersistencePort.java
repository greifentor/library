package de.ollie.library.service.persistence.port;

import java.util.Optional;

import de.ollie.library.service.model.RackSO;

/**
 * An interface for rack persistence ports.
 * 
 * @author ollie
 *
 */
public interface RackPersistencePort {

	Optional<RackSO> findById(long id);

}