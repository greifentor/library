package de.ollie.library.rest.v1.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * A date transfer object class for racks.
 *
 * @author ollie
 *
 */
@Accessors(chain = true)
@Data
public class RackDTO {

	private long id;
	private String name;

}