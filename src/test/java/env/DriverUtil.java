package env;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ErrorHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by tom on 24/02/17.
 */
public class DriverUtil {
    public static long DEFAULT_WAIT = 20;
    protected static WebDriver driver;
    protected static FluentWebDriver fluentWebDriver;
    protected static NgWebDriver ngWebDriver;
    private static Thread CLOSE_DRIVER = new Thread() {
        @Override
        public void run() {
            closeDriver();
        }

    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_DRIVER);
    }

    public static WebDriver getDefaultDriver() {
        if (driver != null) {
            return driver;
        }
        //System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "./geckodriver");
        DesiredCapabilities capabilities = null;
        capabilities = DesiredCapabilities.firefox();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);
        driver = chooseDriver(capabilities);
        driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT,
                TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * Get web driver for AngularJS application
     *
     * @return ngWebdriver
     */
    public static NgWebDriver getNgWebDriver() {
        if (ngWebDriver != null) {
            return ngWebDriver;
        }
        ngWebDriver = new NgWebDriver((JavascriptExecutor) getDefaultDriver());
        return ngWebDriver;
    }

    /**
     * Get Fluent web driver
     *
     * @return fluentWebdriver
     */
    public static FluentWebDriver getFluentWebDriver() {
        if (fluentWebDriver != null) {
            return fluentWebDriver;
        }
        fluentWebDriver = new FluentWebDriver(getDefaultDriver());
        return fluentWebDriver;
    }

    /**
     * By default to web driver will be PhantomJS
     * <p>
     * Override it by passing -DWebDriver=Chrome to the command line arguments
     *
     * @param capabilities
     * @return
     */
    private static WebDriver chooseDriver(DesiredCapabilities capabilities) {
        String preferredDriver = System.getProperty("browser", "chrome");
        String preferredDevice = System.getProperty("device", "iPhone 6");
        boolean headless = System.getProperty("Headless", "true").equals("false");

        switch (preferredDriver.toLowerCase()) {
            case "chrome":
                final ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless");
                }
//                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", preferredDevice);

//                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

                ChromeDriver driver = new ChromeDriver(chromeOptions);
                ErrorHandler handler = new ErrorHandler();
                handler.setIncludeServerErrors(false);
                driver.setErrorHandler(handler);
                return driver;
            case "phantomjs":
                return new PhantomJSDriver(capabilities);
            default:
                //return new PhantomJSDriver(capabilities);
                FirefoxOptions options = new FirefoxOptions();
                //capabilities.s
                if (headless) {
                    options.addArguments("-headless", "-safe-mode");
                }
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
                final FirefoxDriver firefox = new FirefoxDriver();
                return firefox;
        }
    }

    public static WebElement waitAndGetElementByCssSelector(WebDriver driver, String selector,
                                                            int seconds) {
        By selection = By.cssSelector(selector);
        return (new WebDriverWait(driver, seconds)).until( // ensure element is visible!
                ExpectedConditions.visibilityOfElementLocated(selection));
    }

    public static void closeDriver() {
        if (driver != null) {
            try {
                driver.close();
                driver.quit(); // fails in current geckodriver! TODO: Fixme
            } catch (NoSuchMethodError nsme) { // in case quit fails
            } catch (NoSuchSessionException nsse) { // in case close fails
            } catch (SessionNotCreatedException snce) {
            } // in case close fails
            driver = null;
        }
    }

    public static void cleanCookies() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }

    public static void clearStorage() {
        if (driver != null) {
            WebStorage webStorage = (WebStorage) driver;
            webStorage.getLocalStorage().clear();
        }
    }
}

