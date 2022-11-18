package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MerchantChosePage extends AbstractPage {

    String xpathContinueButton = "//button[contains(text(),'Continue')]";

    public MerchantChosePage() {
        super();
    }

    public MerchantChosePage(WebDriver driver, WebDriverWait wait, DevTools devTools) {
        super( driver, wait, devTools);
    }

    public LoginPage pressOnContinueButton(){
        waitForButton(xpathContinueButton,"Continue");
        driver.findElement(By.xpath(xpathContinueButton)).click();
        return new LoginPage(driver, wait, devTools);
    }
}
