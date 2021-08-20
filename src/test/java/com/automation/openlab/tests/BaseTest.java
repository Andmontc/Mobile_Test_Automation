package com.automation.openlab.tests;

import com.automation.openlab.main.DesiredCapabilitiesConfig;
import com.automation.openlab.main.LandingScreen;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    /**
     * The constant driver.
     */
    protected static AndroidDriver driver;

    protected LandingScreen welcome;

    /**
     * Mobile application start.
     *
     * @throws MalformedURLException the malformed url exception
     */
    @BeforeMethod(alwaysRun = true)
    public void mobileApplicationStart() throws MalformedURLException {
        DesiredCapabilitiesConfig capabilities = new DesiredCapabilitiesConfig();
        DesiredCapabilities capabilitiesConfig = capabilities.configCapabilities();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesConfig);
        welcome = new LandingScreen(driver);
    }

    /**
     * Mobile application end.
     */
    @AfterMethod(alwaysRun = true)
    public void mobileApplicationEnd() {
        driver.quit();
    }
}
