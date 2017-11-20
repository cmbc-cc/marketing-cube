package method;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import env.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import java.awt.image.DirectColorModel;

public class SelectElementByType
{
    protected WebDriver driver;
    protected FluentWebDriver fluentWebDriver;
    protected NgWebDriver ngWebDriver;
    protected WebDriverWait wait;
    public SelectElementByType() {
        driver = DriverUtil.getDefaultDriver();
        fluentWebDriver = DriverUtil.getFluentWebDriver();
        ngWebDriver = DriverUtil.getNgWebDriver();
        wait = new WebDriverWait(driver, 30);
    }
    /**Method to select element 'by' type
     * @param type : String : 'By' type
     * @param access_name : String : Locator value
     * @return By
     */
    public By getelementbytype(String type, String access_name)
    {
        switch(type)
        {
            case "id" : return By.id(access_name);
            case "name" : return By.name(access_name);
            case "class" : return By.className(access_name);
            case "xpath" : return By.xpath(access_name);
            case "css" : return By.cssSelector(access_name);
            case "linkText" : return By.linkText(access_name);
            case "partialLinkText" : return By.partialLinkText(access_name);
            case "tagName" : return By.tagName(access_name);
            case "binding": return ByAngular.binding(access_name);
            case "exactbinding": return ByAngular.exactBinding(access_name);
            case "buttonText": return ByAngular.buttonText(access_name);
            case "repeater": return ByAngular.repeater(access_name);
            case "model": return ByAngular.model(access_name);
            default : return null;

        }
		/*if(type.equals("id"))
			return By.id(access_name);
		else if (type.equals("name"))
			return By.name(access_name);
		else if (type.equals("class"))
			return By.className(access_name);
		else if (type.equals("xpath"))
			return By.xpath(access_name);
		else if (type.equals("css"))
			return By.cssSelector(access_name);
		else if(type.equals("linkText"))
			return By.linkText(access_name);
		else if(type.equals("partialLinkText"))
			return By.partialLinkText(access_name);
		else if(type.equals("tagName"))
			return By.tagName(access_name);
		else
			return null;*/
    }
}

