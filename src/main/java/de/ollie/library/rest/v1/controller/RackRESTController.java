package de.ollie.library.rest.v1.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.ollie.library.rest.v1.dto.RackDTO;
import de.ollie.library.service.RackService;
import de.ollie.library.service.model.RackSO;

/**
 * A REST controller for racks.
 *
 * @author ollie
 *
 */
@RestController
@RequestMapping("api/v1/racks")
public class RackRESTController {

	private final Logger logger = LogManager.getLogger(RackRESTController.class);

	private final RackRESTConverter rackRESTConverter;
	private final RackService rackService;

	public RackRESTController(RackRESTConverter rackRESTConverter, RackService rackService) {
		super();
		this.rackRESTConverter = rackRESTConverter;
		this.rackService = rackService;
		logger.info("\n\n\nStarted");
	}

	@GetMapping("/{id}")
	public ResponseEntity<RackDTO> findById(@PathVariable("id") long id) {
		Optional<RackSO> so = this.rackService.findById(id);
		if (so.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(this.rackRESTConverter.convertSOToDTO(so.get()));
	}

}