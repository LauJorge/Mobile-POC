package resources;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseSetup {

    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private static AndroidDriver androidDriver;


    @BeforeClass
     private void initDriver() {

        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "io.selendroid.testapp");
        capabilities.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");

    }

    @AfterClass
    public void tearDown() {
        androidDriver.quit();
    }

}
