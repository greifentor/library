package de.ollie.library.service.persistence.port;

import java.util.Optional;

import de.ollie.library.service.model.Rack;

/**
 * An interface for rack persistence ports.
 * 
 * @author ollie
 *
 */
public interface RackPersistencePort {

	Optional<Rack> findById(long id);

}