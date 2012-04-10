package org.studentsuccessplan.ssp.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import org.studentsuccessplan.ssp.model.Person;

public class MockUser extends SspUser {

	private static final long serialVersionUID = 1L;

	public MockUser(Person p, String username,
			Collection<GrantedAuthority> authorities) {
		super(username, "password", true, true, true, true, authorities);
		this.setPerson(p);
	}
}
