/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.ssp.web.api.reference;

import javax.validation.Valid;

import org.jasig.ssp.factory.TOFactory;
import org.jasig.ssp.factory.reference.ConfigTOFactory;
import org.jasig.ssp.model.reference.Config;
import org.jasig.ssp.service.AuditableCrudService;
import org.jasig.ssp.service.ObjectNotFoundException;
import org.jasig.ssp.service.reference.ConfigService;
import org.jasig.ssp.transferobject.reference.ConfigTO;
import org.jasig.ssp.web.api.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Some basic methods for manipulating Config reference data.
 * <p>
 * Mapped to URI path <code>/1/reference/config</code>
 */
@Controller
@RequestMapping("/1/reference/config")
public class ConfigController
		extends
		AbstractAuditableReferenceController<Config, ConfigTO> {

	/**
	 * Auto-wired service-layer instance.
	 */
	@Autowired
	protected transient ConfigService service;

	/**
	 * Auto-wired transfer object factory.
	 */
	@Autowired
	protected transient ConfigTOFactory factory;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ConfigController.class);

	/**
	 * Constructor that initializes specific class instances for use by the
	 * common base class methods.
	 */
	protected ConfigController() {
		super(Config.class, ConfigTO.class);
	}

	@Override
	protected Logger getLogger() {
		return LOGGER;
	}

	@Override
	protected AuditableCrudService<Config> getService() {
		return service;
	}

	@Override
	protected TOFactory<ConfigTO, Config> getFactory() {
		return factory;
	}

	/**
	 * WARNING: Creating new Config entries is not supported and this controller
	 * action will throw an UnsupportedOperationException. Use liquibase scripts
	 * to insert new configuration entries instead.
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	ConfigTO create(@Valid @RequestBody final ConfigTO obj)
			throws ObjectNotFoundException,
			ValidationException {
		throw new UnsupportedOperationException();
	}
}