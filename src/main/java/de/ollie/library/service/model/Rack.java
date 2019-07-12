package de.ollie.library.service.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * A model class for racks.
 *
 * @author ollie
 *
 */
@Accessors(chain = true)
@Data
public class Rack {

	private long id;
	private String name;

}
