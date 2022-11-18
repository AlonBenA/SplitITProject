import com.google.gson.Gson;
import modules.initiates.InitiateRequest;
import modules.policies.PoliciesRequest;
import modules.policies.PoliciesResponse;
import modules.Token;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MerchantChosePage;
import utiles.APIHelper;
import utiles.APIUtils;

import java.util.ArrayList;


public class Tests {

    private Gson gson;

    private Token token;

    @BeforeClass
    public void beforeClass() {
        gson = new Gson();
    }

    @AfterTest
    public void closeSession() {

    }

    @Test(priority = 1)
    public void UITest() {
        String email = "qa@splitit.com";
        String password = "A1qazxsw23434@";

        HomePage homePage = new HomePage().goToPage();
        homePage.pressNewPaymentButton();
        LoginPage loginPage = homePage.pressOnSighInButton();

        loginPage.enterEmail(email)
                .enterPassword(password);

        MerchantChosePage merchantChosePage = loginPage.clickOnLoginButton();
        merchantChosePage.pressOnContinueButton();
        ArrayList<String> responses = merchantChosePage.getPostNetworkResponses();
        if (responses.size() == 0) {
            Assert.fail("There is no responses ");
        }
        token = gson.fromJson(responses.get(0), Token.class);

        merchantChosePage.quitDriver();
    }

    @Test(priority = 2)
    public void APITest() {
        String cardNumber = "4111111111111111";
        String cardExpYear = "24";
        String cardExpMonth = "02";
        String email = "qa@mail.com";
        int randomAmount = APIHelper.getRandomNumber(1, 1000);
        String sessionID = token.getAccess_token();
        APIUtils apiUtils = new APIUtils();

        PoliciesRequest policiesRequest = new PoliciesRequest(sessionID);
        PoliciesResponse policiesResponse = apiUtils.createPoliciesResponse(policiesRequest);
        String apiKey = policiesResponse.getTerminals().get(0).getApiKey();

        // order details
        InitiateRequest initiateRequest = APIHelper.createOrderDetailsRequest(sessionID, apiKey, randomAmount);
        apiUtils.createInitiate(initiateRequest);

        // payment
        initiateRequest = APIHelper.createPaymentRequest(sessionID, apiKey, cardNumber,cardExpMonth,cardExpYear);
        apiUtils.createInitiate(initiateRequest);

        //consumer
        initiateRequest = APIHelper.createConsumerDataRequest(sessionID,apiKey,email);
        apiUtils.createInitiate(initiateRequest);
    }
}
