package method;

import com.paulhammant.ngwebdriver.ByAngular;
import org.openqa.selenium.By;
import org.seleniumhq.selenium.fluent.FluentMatcher;
import org.seleniumhq.selenium.fluent.FluentWebElement;

public class ActivityMethods extends SelectElementByType implements BaseTest {

    /**
     * method to get activity status - displayed?
     *
     * @param accessName : String : Activity title
     * @return Boolean
     */
    public boolean isActivityWithTitleDisplayed(String accessName) {
        ngWebDriver.waitForAngularRequestsToFinish();
        return fluentWebDriver.lis(ByAngular.repeater("item in actyList")).first(new ActivityContainsTerm(accessName, "item.actyTitle")).getWebElement().isDisplayed();
    }

    /**
     * method to check activity presence with title
     *
     * @param accessName : String : Activity title
     * @param testCase   : Boolean : test case [true or false]
     */
    public void checkActivityWithTitlePresence(String accessName, boolean testCase) throws TestCaseFailed {
        ngWebDriver.waitForAngularRequestsToFinish();
        if (testCase) {
            if (!isActivityWithTitleDisplayed(accessName))
                throw new TestCaseFailed("Element Not Present");
        } else {
            try {
                if (isActivityWithTitleDisplayed(accessName))
                    throw new Exception("Present"); //since it is negative test and we found element
            } catch (Exception e) {
                if (e.getMessage().equals("Present")) //only raise if it present
                    throw new TestCaseFailed("Element Present");
            }
        }
    }

    /**
     * method to click activity
     *
     * @param accessName : String : Activity title
     */
    public void click_activity(String accessName) {
        fluentWebDriver.lis(ByAngular.repeater("item in actyList")).first(new ActivityContainsTerm(accessName, "item.actyTitle")).getWebElement().click();
    }

    /**
     * method to get gift remark - displayed?
     *
     * @param accessName : String : Gift remark
     * @return Boolean
     */
    public boolean isGiftWithRemarkDisplayed(String accessName) {
        ngWebDriver.waitForAngularRequestsToFinish();
        return fluentWebDriver.divs(By.className("pro_list pro_main ng-scope")).first(new GiftContainsTerm(accessName, "item.remark")).getWebElement().isDisplayed();
    }

    /**
     * method to check gift presence with remark
     *
     * @param accessName : String : Gift remark
     * @param testCase   : Boolean : test case [true or false]
     */
    public void checkGiftWithRemarkPresence(String accessName, boolean testCase) throws TestCaseFailed {
        ngWebDriver.waitForAngularRequestsToFinish();
        if (testCase) {
            if (!isGiftWithRemarkDisplayed(accessName))
                throw new TestCaseFailed("Element Not Present");
        } else {
            try {
                if (isGiftWithRemarkDisplayed(accessName))
                    throw new Exception("Present"); //since it is negative test and we found element
            } catch (Exception e) {
                if (e.getMessage().equals("Present")) //only raise if it present
                    throw new TestCaseFailed("Element Present");
            }
        }
    }

    /**
     * method to click gift with remark
     *
     * @param accessName : String : gift remark
     */
    public void click_gift(String accessName) {
        fluentWebDriver.divs(ByAngular.repeater("item in prodList")).first(new GiftContainsTerm(accessName, "item.remark")).getWebElement().click();
    }

    public void checkGiftButtonText(String actualValue, String accessName, boolean testCase) throws TestCaseFailed {
        ngWebDriver.waitForAngularRequestsToFinish();
        String elementText = getGiftButtonTextWithRemark(accessName);

        if (testCase) {
            if (!elementText.equals(actualValue))
                throw new TestCaseFailed("Text Not Matched");
        } else {
            if (elementText.equals(actualValue))
                throw new TestCaseFailed("Text Matched");
        }
    }

    public void checkGiftButtonGray(String accessName, boolean testCase) throws TestCaseFailed {
        ngWebDriver.waitForAngularRequestsToFinish();
        boolean result = isButtonGray(accessName);
        if (testCase) {
            if (!result)
                throw new TestCaseFailed("Button Not Enabled");
        } else {
            if (result)
                throw new TestCaseFailed("Button Enabled");
        }
    }

    private String getGiftButtonTextWithRemark(String accessName) {
        return fluentWebDriver.divs(By.className("pro_list pro_main ng-scope"))
                .first(new GiftContainsTerm(accessName, "item.remark"))
                .span(ByAngular.binding("buttonName(item)"))
                .getWebElement().getText();
    }

    private boolean isButtonGray(String accessName) {
        return fluentWebDriver.divs(By.className("pro_list pro_main ng-scope"))
                .first(new GiftContainsTerm(accessName, "item.remark"))
                .span(ByAngular.binding("buttonName(item)"))
                .getWebElement().getAttribute("class").indexOf("btn_gray") > -1;
    }

    public static class ActivityContainsTerm implements FluentMatcher {
        private String term;
        private String field;

        public ActivityContainsTerm(String term, String field) {
            this.term = term;
            this.field = field;
        }

        public boolean matches(FluentWebElement webElement, int ix) {
            return webElement.span(ByAngular.binding(field)).getWebElement().getText().indexOf(term) > -1;
        }

        @Override
        public String toString() {
            return "TextContainsTerm{term='" + term + "'}";
        }
    }

    public static class GiftContainsTerm implements FluentMatcher {
        private String term;
        private String field;

        public GiftContainsTerm(String term, String field) {
            this.term = term;
            this.field = field;
        }

        public boolean matches(FluentWebElement webElement, int ix) {
            return webElement.p(ByAngular.binding(field)).getWebElement().getText().indexOf(term) > -1;
        }

        @Override
        public String toString() {
            return "TextContainsTerm{term='" + term + "'}";
        }
    }
}
