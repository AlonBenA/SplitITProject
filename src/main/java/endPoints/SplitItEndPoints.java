package endPoints;

import java.text.MessageFormat;

public enum SplitItEndPoints {

    INITIATE_PATH("https://webapi.sandbox.splitit.com/api/InstallmentPlan/Initiate?format=json"),
    POLICIES_PATH("https://webapi.sandbox.splitit.com/api/Terminal/GetPolicies?format=json");

    private String path;

    SplitItEndPoints(String path) {
        this.path = path;
    }

    public String uri() {
        return path;
    }

    public String format(Object... params) {
        int i = 0;
        Object[] tempParams = new Object[params.length];
        for (Object b : params) {
            tempParams[i++] = String.valueOf(b);
        }
        return MessageFormat.format(uri(), tempParams);
    }
}
