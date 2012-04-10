package org.studentsuccessplan.ssp.web.api.reference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.studentsuccessplan.ssp.model.reference.SelfHelpGuideGroup;
import org.studentsuccessplan.ssp.service.reference.SelfHelpGuideGroupService;
import org.studentsuccessplan.ssp.transferobject.reference.SelfHelpGuideGroupTO;

@PreAuthorize("hasRole('ROLE_USER')")
@Controller
@RequestMapping("/reference/selfHelpGuideGroup")
public class SelfHelpGuideGroupController extends
		AbstractAuditableReferenceController<SelfHelpGuideGroup, SelfHelpGuideGroupTO> {

	@Autowired
	protected SelfHelpGuideGroupController(SelfHelpGuideGroupService service) {
		super(service, SelfHelpGuideGroup.class, SelfHelpGuideGroupTO.class);
	}
}
