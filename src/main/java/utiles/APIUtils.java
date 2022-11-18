package utiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import endPoints.SplitItEndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import modules.initiates.InitiateRequest;
import modules.policies.PoliciesRequest;
import modules.policies.PoliciesResponse;
import org.apache.http.HttpStatus;

public class APIUtils {

    Gson gson;
    ObjectMapper objectMapper;

    public APIUtils() {
        objectMapper = new ObjectMapper();
        gson = new Gson();
    }

    public PoliciesResponse createPoliciesResponse(PoliciesRequest policiesRequest) {
        Response response = null;
        String errorMessage = "Failed to get a new policies post response.";
        PoliciesResponse policiesResponse;
        try {
            String path = SplitItEndPoints.POLICIES_PATH.format();
            RequestSpecification requestSpecification = RestAssured.given()
                    .contentType(ContentType.JSON);

            System.out.println("Start policies post request for...");
            response = requestSpecification
                    .body(this.gson.toJson(policiesRequest))
                    .when()
                    .post(path);

            response.then().assertThat().statusCode(HttpStatus.SC_OK);

            policiesResponse = objectMapper.readValue(response.asString(), PoliciesResponse.class);

            System.out.println("Policies post request was successful.");
            return policiesResponse;
        } catch (AssertionError e) {
            throw new AssertionError(errorMessage + ". Wrong status code [" + response.statusCode() + "], expected [" + HttpStatus.SC_OK + "]\n", e);
        } catch (Exception e) {
            throw new RuntimeException(errorMessage, e);
        }
    }

    public void createInitiate(InitiateRequest initiateRequest) {
        Response response = null;
        String errorMessage = "Failed to POST a new initiate request.";
        try {
            String path = SplitItEndPoints.INITIATE_PATH.format();
            RequestSpecification requestSpecification = RestAssured.given()
                    .contentType(ContentType.JSON);

            System.out.println("Start initiate post request for...");
            String body = this.gson.toJson(initiateRequest);
            response = requestSpecification
                    .body(body)
                    .when()
                    .post(path);

            response.then().assertThat().statusCode(HttpStatus.SC_OK);

            System.out.println("Initiate post request was successful.");
        } catch (AssertionError e) {
            throw new AssertionError(errorMessage + ". Wrong status code [" + response.statusCode() + "], expected [" + HttpStatus.SC_OK + "]\n", e);
        } catch (Exception e) {
            throw new RuntimeException(errorMessage, e);
        }
    }
}
