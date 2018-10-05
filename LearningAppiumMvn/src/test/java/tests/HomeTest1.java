package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.net.MalformedURLException;

public class HomeTest1 {

    private HomePage hp;

    @BeforeClass
    public void init() {
        try {
            this.hp = new HomePage();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void enterNameTest() {
        hp.enterName();
        Assert.assertEquals(hp.getNameKeys(), "lau");
    }

    @Test
    public void acceptAddsTest() {
        Assert.assertTrue(hp.isCheck());
    }

    @Test
    public void removeCheckAdd(){
        Assert.assertFalse(hp.isCheckAdd());
    }

    @Test
    public void cancelCloseApp() {
        hp.cancelCloseApp();
        Assert.assertEquals(hp.getPkgMain(), "io.selendroid.testapp");
    }

    @Test()
    public void closeApp() {
        hp.closeHome();
        Assert.assertEquals(hp.getPhoneLauncherBy(), (By.id("com.google.android.apps.nexuslauncher:id/workspace")));
    }

}
