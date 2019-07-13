package de.ollie.library.service;

import java.util.Optional;

import de.ollie.library.service.model.RackSO;

/**
 * An interface for a rack service.
 *
 * @author ollie
 *
 */
public interface RackService {

	Optional<RackSO> findById(long id);

}