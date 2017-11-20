package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import method.BaseTest;

public class MarketingCubeStepDefinitions implements BaseTest {
    //Step to navigate to ng app with specified URL
    @Given("^I navigate to page \"([^\"]*)\"$")
    public void wx_navigate_to(String link) {
        navigationObj.navigateTo(link);
    }

    //step to click on activity
    @Then("^I click on activity having title \"(.*?)\"$")
    public void click_on_activity(String accessName) {
        activityObj.click_activity(accessName);
    }

    //step to check activity present or not
    @Then("^activity having title \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
    public void check_activity_presence(String accessName, String present) throws Exception {
        activityObj.checkActivityWithTitlePresence(accessName, present.isEmpty());
    }

    // step to check gift btn_dh text
    @Then("^gift having remark \"(.*?)\" should\\s*((?:not)?)\\s+have button as \"(.*?)\"$")
    public void check_gift_btn_dh_text(String accessName, String present, String value) throws Exception {
        activityObj.checkGiftButtonText(value, accessName, present.isEmpty());
    }

    // step to check gift btn_dh text
    @Then("^button as \"(.*?)\" of gift having remark \"(.*?)\" should\\s*((?:not)?)\\s+be (enabled|disabled)")
    public void check_gift_dh_btn_disable_or_not(String value, String accessName, String present, String state) throws Exception {
        boolean flag = state.equals("disabled");
        if(!present.isEmpty())
        {
            flag = !flag;
        }
        activityObj.checkGiftButtonGray(accessName, flag);
    }

    //step to check gift present or not
    @Then("^gift having remark \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
    public void check_gift_presence(String accessName, String present) throws Exception {
        activityObj.checkGiftWithRemarkPresence(accessName, present.isEmpty());
    }

    // step to click on gift
    @Then("^I click on gift having remark \"(.*?)\"$")
    public void click_on_gift(String accessName) {
        activityObj.click_gift(accessName);
    }
}
