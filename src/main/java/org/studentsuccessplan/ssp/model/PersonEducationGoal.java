package org.studentsuccessplan.ssp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.studentsuccessplan.ssp.model.reference.EducationGoal;

/**
 * Students may have an Education Goal stored for use in notifications to
 * appropriate users, and for reporting purposes.
 * 
 * Students may have one associated Education Goal instance (one-to-one
 * mapping). Non-student users should never have any education goals associated
 * to them.
 * 
 * @author jon.adams
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PersonEducationGoal extends Auditable implements Serializable {

	private static final long serialVersionUID = -5687416606848336981L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "education_goal_id", nullable = true, insertable = false, updatable = false)
	private EducationGoal educationGoal;

	@Column(length = 50)
	@Size(max = 50)
	private String description;

	@Column(length = 50)
	@Size(max = 50)
	private String plannedOccupation;

	@Column(length = 128)
	@Size(max = 128)
	private String militaryBranchDescription;

	@Column()
	private int howSureAboutMajor;

	public PersonEducationGoal() {
		super();
	}

	public PersonEducationGoal(EducationGoal educationGoal) {
		super();
		this.educationGoal = educationGoal;
	}

	public EducationGoal getEducationGoal() {
		return educationGoal;
	}

	public void setEducationGoal(EducationGoal educationGoal) {
		this.educationGoal = educationGoal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHowSureAboutMajor() {
		return howSureAboutMajor;
	}

	public void setHowSureAboutMajor(int howSureAboutMajor) {
		this.howSureAboutMajor = howSureAboutMajor;
	}

	public String getPlannedOccupation() {
		return plannedOccupation;
	}

	public void setPlannedOccupation(String plannedOccupation) {
		this.plannedOccupation = plannedOccupation;
	}

	public String getMilitaryBranchDescription() {
		return militaryBranchDescription;
	}

	public void setMilitaryBranchDescription(String militaryBranchDescription) {
		this.militaryBranchDescription = militaryBranchDescription;
	}

	/**
	 * Overwrites simple properties with the parameter's properties.
	 * 
	 * @param source
	 *            Source to use for overwrites.
	 */
	public void overwrite(PersonEducationGoal source) {
		this.setDescription(source.getDescription());
		this.setPlannedOccupation(source.getPlannedOccupation());
		this.setHowSureAboutMajor(source.getHowSureAboutMajor());
		this.setMilitaryBranchDescription(source.getMilitaryBranchDescription());
	}
}
