package com.automation.openlab.main;

import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesConfig {
    /**
     * The Capabilities.
     */
    DesiredCapabilities capabilities = new DesiredCapabilities();

    /**
     * Config capabilities desired capabilities.
     *
     * @return the desired capabilities
     */
    public DesiredCapabilities configCapabilities(){
        try {
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appPackage", "com.pixelart.odl");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("app","C:\\Users\\oscar.montes\\IdeaProjects\\Mobile_OpenLab_Test_Automation\\src\\test\\resources\\Open Device Lab_v2.5.3_apkpure.com.apk");
            capabilities.setCapability("appActivity", "com.pixelart.odl.AllODL");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return capabilities;
    }
}
