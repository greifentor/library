package de.ollie.library.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * A ORM mapping and database access class for racks.
 * 
 * @author ollie
 *
 */
@Accessors(chain = true)
@Data
@Entity(name = "Rack")
@Table(name = "RACK")
public class RackDBO {

	@Id
	@Column(name = "ID")
	private long id;
	@Column(name = "NAME")
	private String name;

}