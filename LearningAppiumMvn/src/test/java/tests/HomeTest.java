package tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.net.URL;

public class HomeTest {

    private AndroidDriver<WebElement> driver;
    HomePage hp;


    @BeforeClass
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "io.selendroid.testapp");
        capabilities.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void StartSessionTest() {
        String activity = driver.currentActivity();
        String pkg = driver.getCurrentPackage();
        Assert.assertEquals(activity, ".HomeScreenActivity");
        Assert.assertEquals(pkg, "io.selendroid.testapp");
    }


    @Test()
    public void cancelCloseAppTest() {
        driver.findElement(By.className("android.widget.Button")).click();
        driver.findElement(By.id("android:id/button2")).click();
        String pkg = driver.getCurrentPackage();
        Assert.assertEquals(pkg, "io.selendroid.testapp");
    }

    @Test
    public void enterNameTest() {
        String keys = "lau";
        driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys(keys);
        Assert.assertEquals(keys, "lau");
    }

    @Test
    public void displayTextViewTest() {
        driver.findElement(By.id("io.selendroid.testapp:id/visibleButtonTest")).click();
        boolean textDisplayed = driver.findElement(By.id("io.selendroid.testapp:id/visibleTextView")).isDisplayed();

        Assert.assertTrue(textDisplayed);
    }

    @Test
    public void checkAcceptAddsTest() {
        boolean check = driver.findElement(By.id("io.selendroid.testapp:id/input_adds_check_box")).isEnabled();

        Assert.assertTrue(check);

    }

    @Test
    public void uncheckAcceptAddsTest() {
        driver.findElement(By.id("io.selendroid.testapp:id/input_adds_check_box")).click();
        boolean check = driver.findElement(By.id("io.selendroid.testapp:id/input_adds_check_box")).isSelected();
        Assert.assertFalse(check);

    }

    @Test()
    public void closeAppTest() {
        driver.findElement(By.className("android.widget.Button")).click();
        driver.findElement(By.id("android:id/button1")).click();
        //hp.closeHome();

        String pkg = driver.getCurrentPackage();
        Assert.assertEquals(pkg, "com.google.android.apps.nexuslauncher");
    }

}
