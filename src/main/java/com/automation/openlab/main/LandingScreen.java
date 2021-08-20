package com.automation.openlab.main;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class LandingScreen extends BaseScreen{
    private AndroidDriver driver;

    /**
     * Instantiates a new Welcome and privacy screen.
     *
     * @param driver the driver
     */
    public LandingScreen(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @AndroidFindBy(id = "com.android.permissioncontroller:id/continue_button")
    private AndroidElement continueButton;

    @AndroidFindBy(className ="android.widget.RelativeLayout")
    private List <AndroidElement> elements;

    public void clickContinue() {
        click(continueButton);
    }

    public String getBtnText() {
        return getText(continueButton);
    }

    public int numberOfElements() {
        int count = 0;
        for (AndroidElement element: elements) {
            count ++;
        }
        return count;
    }
}
