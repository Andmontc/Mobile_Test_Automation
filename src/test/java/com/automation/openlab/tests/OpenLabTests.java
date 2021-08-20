package com.automation.openlab.tests;

import com.automation.openlab.main.LandingScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenLabTests extends BaseTest{

    @Test
    public void clickContinue() {
        LandingScreen welcome = new LandingScreen(driver);
        Assert.assertEquals(welcome.getBtnText(), "CONTINUE", "Different texts");
        Assert.assertEquals(welcome.numberOfElements(), 2, "Different numbers of elements");
        welcome.clickContinue();
    }

}
