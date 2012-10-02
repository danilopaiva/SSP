/*
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
Ext.define('Ssp.controller.admin.journal.EditStepDetailViewController', {
    extend: 'Deft.mvc.ViewController',
    mixins: [ 'Deft.mixin.Injectable' ],
    inject: {
    	apiProperties: 'apiProperties',
    	formUtils: 'formRendererUtils',
    	model: 'currentJournalStepDetail',
    	store: 'journalDetailsStore'
    },
    config: {
    	containerToLoadInto: 'adminforms',
    	formToDisplay: 'journalstepdetailadmin'
    },
    control: {
    	'saveButton': {
			click: 'onSaveClick'
		},
		
		'cancelButton': {
			click: 'onCancelClick'
		}   	
    },
    
	init: function() {
		this.getView().getForm().loadRecord(this.model);
		return this.callParent(arguments);
    },
    
	onSaveClick: function(button) {
		var me = this;
		var record, id, jsonData, url;
		url = this.store.getProxy().url;
		this.getView().getForm().updateRecord();
		record = this.model;
		id = record.get('id');
		jsonData = record.data;
		successFunc = function(response, view) {
			me.displayMain();
		};
		
		if (id.length > 0)
		{
			// editing
			this.apiProperties.makeRequest({
				url: url+"/"+id,
				method: 'PUT',
				jsonData: jsonData,
				successFunc: successFunc 
			});
			
		}else{
			// adding
			this.apiProperties.makeRequest({
				url: url,
				method: 'POST',
				jsonData: jsonData,
				successFunc: successFunc 
			});		
		}
	},
	
	onCancelClick: function(button){
		this.displayMain();
	},
	
	displayMain: function(){
		var comp = this.formUtils.loadDisplay(this.getContainerToLoadInto(), this.getFormToDisplay(), true, {});
	}
});