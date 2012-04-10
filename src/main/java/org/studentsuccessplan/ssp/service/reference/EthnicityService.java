package org.studentsuccessplan.ssp.service.reference;

import java.util.List;
import java.util.UUID;

import org.studentsuccessplan.ssp.model.ObjectStatus;
import org.studentsuccessplan.ssp.model.reference.Ethnicity;
import org.studentsuccessplan.ssp.service.AuditableCrudService;
import org.studentsuccessplan.ssp.service.ObjectNotFoundException;

public interface EthnicityService extends AuditableCrudService<Ethnicity> {

	@Override
	public List<Ethnicity> getAll(ObjectStatus status, Integer firstResult,
			Integer maxResults, String sort, String sortDirection);

	@Override
	public Ethnicity get(UUID id) throws ObjectNotFoundException;

	@Override
	public Ethnicity create(Ethnicity obj);

	@Override
	public Ethnicity save(Ethnicity obj) throws ObjectNotFoundException;

	@Override
	public void delete(UUID id) throws ObjectNotFoundException;

}
