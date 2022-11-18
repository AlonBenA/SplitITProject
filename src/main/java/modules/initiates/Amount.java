package modules.initiates;

public class Amount {

    int Value;
    String CurrencyCode;

    public Amount(int value, String currencyCode) {
        Value = value;
        CurrencyCode = currencyCode;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        CurrencyCode = currencyCode;
    }
}
