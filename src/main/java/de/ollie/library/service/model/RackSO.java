package de.ollie.library.service.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * A service object class for racks.
 *
 * @author ollie
 *
 */
@Accessors(chain = true)
@Data
public class RackSO {

	private long id;
	private String name;

}