package modules.policies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseHeader {
    @JsonProperty("Succeeded")
    Boolean Succeeded;
    @JsonProperty("Errors")
    String Errors;
    @JsonProperty("TraceId")
    String TraceId;

    public Boolean getSucceeded() {
        return Succeeded;
    }

    public void setSucceeded(Boolean succeeded) {
        Succeeded = succeeded;
    }

    public String getErrors() {
        return Errors;
    }

    public void setErrors(String errors) {
        Errors = errors;
    }

    public String getTraceId() {
        return TraceId;
    }

    public void setTraceId(String traceId) {
        TraceId = traceId;
    }
}
