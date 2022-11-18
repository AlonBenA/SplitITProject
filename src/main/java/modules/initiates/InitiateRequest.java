package modules.initiates;

import utiles.APIHelper;

import java.util.HashMap;
import java.util.Map;

public class InitiateRequest {

    Map<String, Object> RequestHeader;

    public InitiateRequest() {
        RequestHeader = new HashMap<>();
    }

    public InitiateRequest(String sessionID, String apiKey) {
        RequestHeader = new HashMap<>();
        createNewBaseRequest( sessionID,  apiKey);
    }

    public Map<String, Object> getRequestHeader() {
        return RequestHeader;
    }

    public void setRequestHeader(Map<String, Object> requestHeader) {
        RequestHeader = requestHeader;
    }

    private void createNewBaseRequest(String sessionID, String apiKey) {
        RequestHeader.put("ApiKey", apiKey);
        RequestHeader.put("CultureName", "en-US");
        RequestHeader.put("SessionId", sessionID);

        RequestHeader.put("TouchPoint", APIHelper.createTouchPoint());
    }
}
