package org.studentsuccessplan.ssp.service.reference;

import java.util.List;
import java.util.UUID;

import org.studentsuccessplan.ssp.model.ObjectStatus;
import org.studentsuccessplan.ssp.model.reference.EducationGoal;
import org.studentsuccessplan.ssp.service.AuditableCrudService;
import org.studentsuccessplan.ssp.service.ObjectNotFoundException;

public interface EducationGoalService extends AuditableCrudService<EducationGoal> {

	@Override
	public List<EducationGoal> getAll(ObjectStatus status, Integer firstResult,
			Integer maxResults, String sort, String sortDirection);

	@Override
	public EducationGoal get(UUID id) throws ObjectNotFoundException;

	@Override
	public EducationGoal create(EducationGoal obj);

	@Override
	public EducationGoal save(EducationGoal obj) throws ObjectNotFoundException;

	@Override
	public void delete(UUID id) throws ObjectNotFoundException;

}
