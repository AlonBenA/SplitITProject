package utiles;

import modules.initiates.consumer.ConsumerDataRequest;
import modules.initiates.orderDetails.OrderDetailsRequest;
import modules.initiates.payment.PaymentRequest;

import java.util.HashMap;
import java.util.Map;

public class APIHelper {

    public static Map<String, Object> createTouchPoint() {
        Map<String, Object> touchPoint = new HashMap<>();
        touchPoint.put("Code", "VposCheckOut");
        touchPoint.put("Version", "2.0");
        return touchPoint;
    }

    public static OrderDetailsRequest createOrderDetailsRequest(String sessionID, String apiKey, int randomAmount) {
        OrderDetailsRequest orderDetailsRequest = new OrderDetailsRequest(sessionID, apiKey,
                randomAmount, "GBP",
                false, "InStore",
                "Alon_Ben_Abraham");
        return orderDetailsRequest;
    }

    public static PaymentRequest createPaymentRequest(String sessionID, String apiKey,String cardNumber,
                                                      String cardExpMonth, String cardExpYear) {
        PaymentRequest paymentRequest = new PaymentRequest( sessionID,  apiKey,
                "123", "Alon BA",
                cardNumber, cardExpMonth, cardExpYear,
       6, null);
        return paymentRequest;
    }

    public static ConsumerDataRequest createConsumerDataRequest(String sessionID, String apiKey, String email) {
        ConsumerDataRequest consumerDataRequest = new ConsumerDataRequest( sessionID,  apiKey, "en-US",
                email,"Alon","555555555", "71648475442718528463");
        return consumerDataRequest;
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static String getRandomCurrencyCode() {
        int number = getRandomNumber(0, 6);
        String currencyCode = "";
        switch (number) {
            case 0:
                currencyCode = "USD";
                break;
            case 1:
                currencyCode = "AUD";
                break;
            case 2:
                currencyCode = "EUR";
                break;
            case 3:
                currencyCode = "GBP";
                break;
            case 4:
                currencyCode = "CAD";
                break;
            case 5:
                currencyCode = "CHF";
                break;
        }
        return currencyCode;
    }
}
