package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.network.Network;
import org.openqa.selenium.devtools.v104.network.model.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;

public class AbstractPage {

    private Logger logger = Logger.getLogger(AbstractPage.class.getName());

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected DevTools devTools;

    private static ArrayList<String> postNetworkResponses;

    public AbstractPage() {
        postNetworkResponses = new ArrayList<>();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        captureNetworkResponses();
    }

    public AbstractPage(WebDriver driver,WebDriverWait wait, DevTools devTools) {
        this.driver = driver;
        this.wait = wait;
        this.devTools = devTools;
    }

    private synchronized void captureNetworkResponses() {
        System.out.println("Start capture network responses for all pages.");
        devTools.send(Network.enable(Optional.of(100000000), Optional.empty(), Optional.empty()));

        devTools.addListener(Network.responseReceived(), responseReceived -> {
            addTokenNetworkResponsesToArray(responseReceived);
        });
    }

    private synchronized void addTokenNetworkResponsesToArray(ResponseReceived entry) {

        if(entry.getResponse().getUrl().contains( "connect/token" ) ) {
            RequestId[] requestIds = new RequestId[1];
            requestIds[0] = entry.getRequestId();
            String bodyOfResponse = devTools.send(Network.getResponseBody(requestIds[0])).getBody();
            postNetworkResponses.add(bodyOfResponse);
        }
    }

    public ArrayList<String> getPostNetworkResponses() {
        return this.postNetworkResponses;
    }

    public void waitForButton(String buttonXpath, String buttonName){
        System.out.println("Wait for button " + buttonName + " to be visible.");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(buttonXpath)));
        System.out.println("Button " + buttonName + " is visible.");
    }

    public void quitDriver() {
        driver.quit();
    }
}
