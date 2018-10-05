package pages;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.pages.PageObject;

public class MobilePageObject extends PageObject {
    public MobilePageObject(AppiumDriver driver) {
        super(driver);
    }
    //https://github.com/ricardorlg/serenityappiumbug/issues/1
    //WhenUsingCustomLogicForElementsInit.java, PageObject.java
    /*public MobilePageObject(final WebDriver driver) {
        super(driver, new Predicate<PageObject>() {
            @Override
            public boolean apply(PageObject page) {

                PageFactory
                        .initElements(new AppiumFieldDecorator( ((WebDriverFacade) page.getDriver()).getProxiedDriver(),
                                page.getImplicitWaitTimeout()), page);
                return true;
            }

        });

    }

*/
}