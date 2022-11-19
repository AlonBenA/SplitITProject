package modules.initiates.payment;

import modules.initiates.InitiateRequest;

import java.util.HashMap;
import java.util.Map;

public class PaymentRequest extends InitiateRequest {

    CreditCardDetails CreditCardDetails;
    Map<String, Object> PlanData;

    public PaymentRequest(String sessionID, String apiKey,
                          String cardCvv, String cardHolderFullName,
                          String cardNumber, String cardExpMonth,
                          String cardExpYear,
                          Integer numberOfInstallments, String firstInstallmentAmount) {
        super(sessionID, apiKey);
        this.PlanData = new HashMap<>();
        this.CreditCardDetails = new CreditCardDetails(cardCvv, cardHolderFullName, cardNumber, cardExpMonth, cardExpYear);
        createPayment(numberOfInstallments, firstInstallmentAmount);
    }

    private void createPayment(int numberOfInstallments, String firstInstallmentAmount) {
        PlanData.put("NumberOfInstallments", numberOfInstallments);
        PlanData.put("FirstInstallmentAmount", firstInstallmentAmount);
    }

    public modules.initiates.payment.CreditCardDetails getCreditCardDetails() {
        return CreditCardDetails;
    }

    public void setCreditCardDetails(modules.initiates.payment.CreditCardDetails creditCardDetails) {
        CreditCardDetails = creditCardDetails;
    }

    public Map<String, Object> getPlanData() {
        return PlanData;
    }

    public void setPlanData(Map<String, Object> planData) {
        PlanData = planData;
    }
}
