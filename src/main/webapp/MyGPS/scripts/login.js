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
(function() {
  var $, context;

  $ = jQuery;

  context = window.context || (window.context = {});

  $('#login-page').live('pagecreate', function(event) {
    var loginPage, viewModel;
    loginPage = this;
    viewModel = new mygps.viewmodel.LoginViewModel();
    window.viewModel = viewModel;
    $("body").loadTemplates({
      bannerTemplate: "/ssp/MyGPS/templates/banner.html",
      footerTemplate: "/ssp/MyGPS/templates/footer.html"
    }).done(function() {
      ko.applyBindings(viewModel, loginPage);
    });
    $('#login-page').live('pagebeforeshow', function() {
      window.viewModel = viewModel;
      viewModel.load();
    });
    $('#login-page').live('pageshow', function() {
      $('#login-page').ready(function() {
        return $('#j_username').focus();
      });
    });
  });

}).call(this);
