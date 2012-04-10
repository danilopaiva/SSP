package org.studentsuccessplan.ssp.web.api.reference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.studentsuccessplan.ssp.model.reference.StudentStatus;
import org.studentsuccessplan.ssp.service.reference.StudentStatusService;
import org.studentsuccessplan.ssp.transferobject.reference.StudentStatusTO;

@PreAuthorize("hasRole('ROLE_USER')")
@Controller
@RequestMapping("/reference/studentStatus")
public class StudentStatusController extends
		AbstractAuditableReferenceController<StudentStatus, StudentStatusTO> {

	@Autowired
	protected StudentStatusController(StudentStatusService service) {
		super(service, StudentStatus.class, StudentStatusTO.class);
	}
}
