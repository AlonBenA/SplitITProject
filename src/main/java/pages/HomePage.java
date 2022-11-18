package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class HomePage extends AbstractPage {

    private Logger logger = Logger.getLogger(HomePage.class.getName());

    String HOME_PAGE_URL = "https://vpos.sandbox.splitit.com/";
    String xpathNewPaymentButton = "//button[contains(text(),'New Payment')]";
    String xpathSignInButton = "//button[contains(text(),'Sign In')]";

    public HomePage goToPage(){
        driver.get(HOME_PAGE_URL);
        return this;
    }

    public HomePage pressNewPaymentButton(){
        waitForButton(xpathNewPaymentButton,"New Payment");
        driver.findElement(By.xpath(xpathNewPaymentButton)).click();
        return this;
    }

    public LoginPage pressOnSighInButton(){
        waitForButton(xpathSignInButton,"Sign In");
        driver.findElement(By.xpath(xpathSignInButton)).click();
        return new LoginPage(driver, wait, devTools);
    }
}
