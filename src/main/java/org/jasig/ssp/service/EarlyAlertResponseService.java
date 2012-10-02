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
package org.jasig.ssp.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.jasig.ssp.model.EarlyAlert;
import org.jasig.ssp.model.EarlyAlertResponse;
import org.jasig.ssp.model.Person;
import org.jasig.ssp.util.sort.PagingWrapper;
import org.jasig.ssp.util.sort.SortingAndPaging;

/**
 * EarlyAlertResponse service
 * 
 * @author jon.adams
 * 
 */
public interface EarlyAlertResponseService
		extends AuditableCrudService<EarlyAlertResponse> {
	/**
	 * Retrieve every response in the database filtered by the supplied status
	 * and early alert.
	 * 
	 * @param earlyAlert
	 * @param sAndP
	 *            Sorting and paging options
	 * @return All entities in the database filtered by the supplied status.
	 */
	PagingWrapper<EarlyAlertResponse> getAllForEarlyAlert(
			EarlyAlert earlyAlert,
			SortingAndPaging sAndP);

	Long getEarlyAlertResponseCountForCoach(Person coach, Date createDateFrom,
			Date createDateTo, List<UUID> studentTypeIds);

}