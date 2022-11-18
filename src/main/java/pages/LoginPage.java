package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.network.model.RequestWillBeSent;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class LoginPage extends AbstractPage {

    private Logger logger = Logger.getLogger(LoginPage.class.getName());

    String xpathEmailInput = "//input[@type='text']";
    String xpathPasswordInput = "//input[@type='password']";
    String xpathLoginButton = "//button[@value='login']";

    private ArrayList<RequestWillBeSent> postNetworkRequests;

    public LoginPage() {
        super();
        postNetworkRequests = new ArrayList<>();
    }

    public LoginPage(WebDriver driver, WebDriverWait wait, DevTools devTools) {
        super( driver, wait, devTools);
    }

    public LoginPage enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathEmailInput)));

        WebElement emailInputElement = driver.findElement(By.xpath(xpathEmailInput));
        System.out.println("Try to enter email " + email);
        emailInputElement.sendKeys(email);
        System.out.println("Email was entered." );
        return this;
    }

    public LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathPasswordInput)));
        WebElement passwordInputElement = driver.findElement(By.xpath(xpathPasswordInput));
        System.out.println("Try to enter password " + password);
        passwordInputElement.sendKeys(password);
        System.out.println("Password was entered." );

        return this;
    }

    public MerchantChosePage clickOnLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLoginButton)));
        System.out.println("Try to click on login button.");
        driver.findElement(By.xpath(xpathLoginButton)).click();
        System.out.println("Login Button was click." );
        return new MerchantChosePage(driver, wait, devTools);
    }
}
