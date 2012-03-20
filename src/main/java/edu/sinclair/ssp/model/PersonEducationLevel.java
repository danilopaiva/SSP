package edu.sinclair.ssp.model;

import java.util.UUID;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.sinclair.ssp.model.reference.EducationLevel;

public class PersonEducationLevel {

	private UUID id;
	
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", nullable = false, insertable = false, updatable = false)
	private Person person;
	
	/**
	 * Associated person. Changes to this Person are not persisted.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "education_level_id", nullable = false, insertable = false, updatable = false)
	private EducationLevel educationLevel;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public EducationLevel getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
	}
	
	
}
