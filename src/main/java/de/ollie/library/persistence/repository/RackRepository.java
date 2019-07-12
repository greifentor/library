package de.ollie.library.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.ollie.library.persistence.model.RackDBO;

/**
 * A repository for rack access.
 *
 * @author ollie
 *
 */
@Repository
public interface RackRepository extends CrudRepository<RackDBO, Long> {
}