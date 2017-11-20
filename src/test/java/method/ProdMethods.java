package method;

import com.paulhammant.ngwebdriver.ByAngular;
import org.seleniumhq.selenium.fluent.FluentMatcher;
import org.seleniumhq.selenium.fluent.FluentWebElement;

public class ProdMethods extends SelectElementByType implements BaseTest {
    /**
     * method to get prod status - displayed?
     *
     * @param accessName : String : Prod name
     * @return Boolean
     */
    public boolean isProdWithTitleDisplayed(String accessName) {
       return fluentWebDriver.lis(ByAngular.repeater("item in actyList")).first(new ProdTitleContainsTerm(accessName)).getWebElement().isDisplayed();
    }

    /**
     * method to check prod presence
     *
     * @param accessName : String : Prod name
     * @param testCase   : Boolean : test case [true or false]
     */
    public void checkActivityWithTitlePresence(String accessName, boolean testCase) throws TestCaseFailed {
        if (testCase) {
            if (!isProdWithTitleDisplayed(accessName))
                throw new TestCaseFailed("Element Not Present");
        } else {
            try {
                if (isProdWithTitleDisplayed(accessName))
                    throw new Exception("Present"); //since it is negative test and we found element
            } catch (Exception e) {
                if (e.getMessage().equals("Present")) //only raise if it present
                    throw new TestCaseFailed("Element Present");
            }
        }
    }

    /**
     * method to check prod presence
     *
     * @param accessName : String : Prod name
     */
    public void click(String accessName)
    {
        fluentWebDriver.lis(ByAngular.repeater("item in prodList")).first(new ProdTitleContainsTerm(accessName)).getWebElement().click();
    }
    public static class ProdTitleContainsTerm implements FluentMatcher {
        private String term;

        public ProdTitleContainsTerm(String term) {
            this.term = term;
        }

        public boolean matches(FluentWebElement webElement, int ix) {
            return webElement.span(ByAngular.binding("item prodTitle")).getWebElement().getText().indexOf(term) > -1;
        }

        @Override
        public String toString() {
            return "TextContainsTerm{term='" + term + "'}";
        }
    }
}
