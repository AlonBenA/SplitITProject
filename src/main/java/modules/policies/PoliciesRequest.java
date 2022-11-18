package modules.policies;

import utiles.APIHelper;

import java.util.HashMap;
import java.util.Map;

public class PoliciesRequest {
    boolean IncludeTerminalPolicies;
    Map<String,Object> RequestHeader;
    Map<String,Object> TerminalQueryCriteria;

    public PoliciesRequest(String sessionID) {
        RequestHeader = new HashMap<>();
        TerminalQueryCriteria = new HashMap<>();
        IncludeTerminalPolicies = false;
        createNewRequest(sessionID);
    }

    public void createNewRequest(String sessionID){
        RequestHeader.put("ApiKey","0");
        RequestHeader.put("CultureName","en-US");
        RequestHeader.put("SessionId",sessionID);

        RequestHeader.put("TouchPoint", APIHelper.createTouchPoint());

        TerminalQueryCriteria.put("MerchantId",35630);
        TerminalQueryCriteria.put("TerminalAPIKey",null);
        TerminalQueryCriteria.put("TerminalId",null);
    }


}
