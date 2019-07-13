package de.ollie.library.rest.v1.converter;

import org.springframework.stereotype.Component;

import de.ollie.library.rest.v1.dto.RackDTO;
import de.ollie.library.service.so.RackSO;

/**
 * A converter for rack objects in REST context.
 *
 * @author ollie
 *
 */
@Component
public class RackRESTConverter {

	public RackDTO convertSOToDTO(RackSO so) {
		if (so == null) {
			return null;
		}
		return new RackDTO().setId(so.getId()).setName(so.getName());
	}

}