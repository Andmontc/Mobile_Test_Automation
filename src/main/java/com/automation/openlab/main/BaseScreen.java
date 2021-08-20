package com.automation.openlab.main;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.lang.String.format;

import java.text.Normalizer;
import java.time.Duration;

public class BaseScreen {
    private AndroidDriver<AndroidElement> driver;

    /**
     * Remove accents and special characters
     */
    public static String unAccent(String src) {
        return Normalizer
                .normalize(src, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

    /**
     * Instantiates a new Base screen.
     *
     * @param driver the driver
     */
    public BaseScreen(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

    /**
     * Gets driver.
     *
     * @return the driver
     */
    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    /**
     * Tap back function, click back in the device
     */
    public void tapBack() {
        driver.navigate()
                .back();
    }

    /**
     * Wait visibility function for the visibility of the element
     *
     * @param element the element
     */
    public void waitVisibility(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait invisibility boolean.
     *
     * @param element the element
     * @return the boolean
     */
    public Boolean waitInvisibility(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver,15);
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Click.
     *
     * @param element the element
     */
    public void click(AndroidElement element) {
        waitVisibility(element);
        element.click();
    }

    /**
     * Send keys.
     *
     * @param element  the element
     * @param sequence the sequence
     */
    public void sendKeys(AndroidElement element, String sequence) {
        waitVisibility(element);
        element.sendKeys(sequence);
    }

    /**
     * Gets text.
     *
     * @param element the element
     * @return the text
     */
    public String getText(AndroidElement element) {
        waitVisibility(element);
        return element.getText();
    }

    /**
     * Is element available boolean.
     *
     * @param element the element
     * @return the boolean
     */
    public boolean isElementAvailable(AndroidElement element) {
        waitVisibility(element);
        return true;
    }

    /**
     * Scroll to text.
     *
     * @param text the text
     */
    public void scrollToText(String text) {
        String automator = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + "new UiSelector().text(\"%s\"));";
        AndroidElement selectedCountry = (AndroidElement) driver.findElementByAndroidUIAutomator(format(automator, text));
        click(selectedCountry);
    }
}
