$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:features/TR_Login.feature");
formatter.feature({
  "name": "TR Login",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.scenario({
  "name": "Login with a valid username and pass in TR page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.step({
  "name": "Open browser and access TR page",
  "keyword": "Given "
});
formatter.match({
  "location": "TRLoginStepDefs.open_chrome_browser_and_enter_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter valid username/password",
  "keyword": "And "
});
formatter.match({
  "location": "TRLoginStepDefs.enter_valid_username_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Login button",
  "keyword": "When "
});
formatter.match({
  "location": "TRLoginStepDefs.click_on_Login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "TR Dashboard page is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "TRLoginStepDefs.tr_Dashboard_page_is_displayed()"
});
formatter.result({
  "status": "passed"
});
});