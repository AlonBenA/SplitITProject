package modules.initiates;

public class CreditCardDetails {
    String CardCvv;
    String CardHolderFullName;
    String CardNumber;
    String CardExpMonth;
    String CardExpYear;

    public CreditCardDetails(String cardCvv, String cardHolderFullName, String cardNumber, String cardExpMonth, String cardExpYear) {
        CardCvv = cardCvv;
        CardHolderFullName = cardHolderFullName;
        CardNumber = cardNumber;
        CardExpMonth = cardExpMonth;
        CardExpYear = cardExpYear;
    }

    public String getCardCvv() {
        return CardCvv;
    }

    public void setCardCvv(String cardCvv) {
        CardCvv = cardCvv;
    }

    public String getCardHolderFullName() {
        return CardHolderFullName;
    }

    public void setCardHolderFullName(String cardHolderFullName) {
        CardHolderFullName = cardHolderFullName;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getCardExpMonth() {
        return CardExpMonth;
    }

    public void setCardExpMonth(String cardExpMonth) {
        CardExpMonth = cardExpMonth;
    }

    public String getCardExpYear() {
        return CardExpYear;
    }

    public void setCardExpYear(String cardExpYear) {
        CardExpYear = cardExpYear;
    }
}
