import com.google.gson.Gson;
import infra.datadrive.CsvDataProvider;
import infra.datadrive.DataProviderSource;
import infra.testng.Param;
import infra.testng.ParameterName;
import modules.initiates.InitiateRequest;
import modules.policies.PoliciesRequest;
import modules.policies.PoliciesResponse;
import modules.Token;
import org.apache.commons.lang3.StringUtils;
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

    private String apiKey;

    @BeforeClass
    public void beforeClass() {
        gson = new Gson();
        apiKey = "";
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

    @Test(priority = 2, testName= "APITest", dataProvider = "dp", dataProviderClass = CsvDataProvider.class)
    @DataProviderSource(name = "APITest")
    public void APITest(@Param(ParameterName.EMAIL) String email,
                        @Param(ParameterName.CARD_NUMBER) String cardNumber,
                        @Param(ParameterName.YEAR) String cardExpYear,
                        @Param(ParameterName.MOUTH) String cardExpMonth) {
        int randomAmount = APIHelper.getRandomNumber(1, 1000);
        String sessionID = token.getAccess_token();
        APIUtils apiUtils = new APIUtils();

        if(StringUtils.isEmpty(apiKey)){
            PoliciesRequest policiesRequest = new PoliciesRequest(sessionID);
            PoliciesResponse policiesResponse = apiUtils.createPoliciesResponse(policiesRequest);
            apiKey = policiesResponse.getTerminals().get(0).getApiKey();
        }
        
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
