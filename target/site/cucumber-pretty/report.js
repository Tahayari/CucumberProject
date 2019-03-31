$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/YouTubeSearch.feature");
formatter.feature({
  "name": "Yotube Search validations",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Youtube"
    }
  ]
});
formatter.scenario({
  "name": "Youtube Search possitive scenarios",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Youtube"
    }
  ]
});
formatter.step({
  "name": "Open chrome browser and enter url",
  "keyword": "Given "
});
formatter.match({
  "location": "YouTubeSearchStepDef.open_chrome_browser_and_enter_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter search creteria",
  "keyword": "When "
});
formatter.match({
  "location": "YouTubeSearchStepDef.enter_search_creteria()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on search button",
  "keyword": "Then "
});
formatter.match({
  "location": "YouTubeSearchStepDef.click_on_search_button()"
});
formatter.result({
  "status": "passed"
});
});