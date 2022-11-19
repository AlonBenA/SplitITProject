package modules.initiates.orderDetails;


import modules.initiates.InitiateRequest;

import java.util.HashMap;
import java.util.Map;

public class OrderDetailsRequest extends InitiateRequest {

    Map<String,Object> PlanData;

    public OrderDetailsRequest(String sessionID, String apiKey,
                               int value, String currencyCode,
                               boolean isFunded, String purchaseMethod,
                               String refOrderNumber) {
        super(sessionID, apiKey);
        this.PlanData = new HashMap<>();
        Amount amount = new Amount(value,currencyCode);
        createOrderDetails( amount,  isFunded,
                purchaseMethod,  refOrderNumber);
    }

    private void createOrderDetails(Amount amount, boolean isFunded,
                                    String PurchaseMethod, String RefOrderNumber){
        PlanData.put("Amount",amount);
        PlanData.put("IsFunded",isFunded);
        PlanData.put("PurchaseMethod",PurchaseMethod);
        PlanData.put("RefOrderNumber",RefOrderNumber);
    }

    public Map<String, Object> getPlanData() {
        return PlanData;
    }

    public void setPlanData(Map<String, Object> planData) {
        PlanData = planData;
    }
}
