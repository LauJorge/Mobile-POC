package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class HomePage extends BasePage {

    private String pkgMain = "io.selendroid.testapp";
    private String nameKeys = "lau";
    private By closeBtnBy;
    private By phoneLauncherBy;
    private By checkboxBy;
    private By closeHomeBtnBy;
    private By okCloseBtnBy;
    private By noCloseBtnBy;
    private By txtFieldBy;



    private WebElement checkbox;
    private WebElement closeHomeBtn;
    private WebElement okCloseBtn;
    private WebElement noCloseBtn;
    private WebElement txtField;


    public HomePage() throws MalformedURLException {
        super();
        initializePage();
    }

    private void initializePage(){
        closeBtnBy = By.className("android.widget.Button");
        phoneLauncherBy = By.id("com.google.android.apps.nexuslauncher:id/workspace");
        checkboxBy = By.id("io.selendroid.testapp:id/input_adds_check_box");
        closeHomeBtnBy = By.className("android.widget.Button");
        txtFieldBy = By.id("io.selendroid.testapp:id/my_text_field");
        txtField = driver.findElement(txtFieldBy);
        checkbox = driver.findElement(checkboxBy);
        closeHomeBtn = driver.findElement(closeHomeBtnBy);
    }

    public boolean isCheck(){
        return checkbox.isEnabled();
    }

    public boolean isCheckAdd() {
        checkbox.click();
        return checkbox.isSelected();
    }


    public void closeHome() {
        closeHomeBtn.click();
        okCloseBtnBy = By.id("android:id/button1");
        okCloseBtn = driver.findElement(okCloseBtnBy);
        okCloseBtn.click();
    }

    public void cancelCloseApp() {
        closeHomeBtn.click();
        noCloseBtnBy = By.id("android:id/button2");
        noCloseBtn = driver.findElement(noCloseBtnBy);
        noCloseBtn.click();

    }

    public void enterName() {

       txtField.sendKeys(nameKeys);
    }

    public By getPhoneLauncherBy() {
        return phoneLauncherBy;
    }

    public String getPkgMain() {
        return pkgMain;
    }

    public String getNameKeys() {
        return nameKeys;
    }

}
