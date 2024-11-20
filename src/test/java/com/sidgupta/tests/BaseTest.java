package com.sidgupta.tests;

import com.sidgupta.util.Config;
import com.sidgupta.util.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    private WebDriver driver;

    public BaseTest() {
        Config.initialize();
    }

    public WebDriver getDriver() throws MalformedURLException {
        return Boolean.parseBoolean(Config.getProperty(Constants.GRID_ENABLED)) ? getRemoteDriver() : getLocalDriver();

    }

    private WebDriver getLocalDriver() {

        if (driver == null) {
            if (Config.getProperty(Constants.BROWSER).equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().browserVersion(Config.getProperty(Constants.CHROME_BROWSER_VERSION)).setup();
                driver = new ChromeDriver();
            }
            else {
                WebDriverManager.firefoxdriver().browserVersion(Config.getProperty(Constants.FIREFOX_BROWSER_VERSION)).setup();
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty(Constants.IMPLICIT_WAIT_DURATION))));
        }
        return driver;

    }

    private WebDriver getRemoteDriver() throws MalformedURLException {

        if (driver == null) {
            Capabilities capabilities = new ChromeOptions();

            if (Constants.FIREFOX.equalsIgnoreCase(Config.getProperty(Constants.BROWSER)))
                capabilities = new FirefoxOptions();

            String url = String.format(Config.getProperty(Constants.GRID_URL_FORMAT), Config.getProperty(Constants.GRID_HUB_HOST));
            log.info("URL : {}", url);

            driver = new RemoteWebDriver(new URL(url), capabilities);
        }
        return driver;
    }

}
