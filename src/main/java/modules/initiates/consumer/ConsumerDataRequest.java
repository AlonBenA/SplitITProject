package modules.initiates.consumer;

import modules.initiates.InitiateRequest;

public class ConsumerDataRequest extends InitiateRequest {

    ConsumerData ConsumerData;
    String InstallmentPlanNumber;

    public ConsumerDataRequest(String sessionID, String apiKey,
                               String cultureName, String email, String fullName, String phoneNumber,
                               String installmentPlanNumber) {
        super(sessionID, apiKey);
        ConsumerData = new ConsumerData( cultureName,  email,  fullName,  phoneNumber);
        this.InstallmentPlanNumber = installmentPlanNumber;
    }

    public ConsumerData getConsumerData() {
        return ConsumerData;
    }

    public void setConsumerData(ConsumerData consumerData) {
        ConsumerData = consumerData;
    }

    public String getInstallmentPlanNumber() {
        return InstallmentPlanNumber;
    }

    public void setInstallmentPlanNumber(String installmentPlanNumber) {
        InstallmentPlanNumber = installmentPlanNumber;
    }
}
