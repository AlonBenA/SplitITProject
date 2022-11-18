package modules.policies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Terminal {
    @JsonProperty("Id")
    public int id;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("ApiKey")
    public String apiKey;
    @JsonProperty("TerminalPolicies")
    public TerminalPolicies terminalPolicies;
    @JsonProperty("LogoURL")
    public String logoURL;
    @JsonProperty("DefaultCulture")
    public DefaultCulture defaultCulture;
    @JsonProperty("Parameters")
    public Parameters parameters;
    @JsonProperty("IsCopyLinkEnabledInVpos3")
    public boolean isCopyLinkEnabledInVpos3;
    @JsonProperty("IsPhoneOrderEnabledInVpos3")
    public boolean isPhoneOrderEnabledInVpos3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public TerminalPolicies getTerminalPolicies() {
        return terminalPolicies;
    }

    public void setTerminalPolicies(TerminalPolicies terminalPolicies) {
        this.terminalPolicies = terminalPolicies;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    public DefaultCulture getDefaultCulture() {
        return defaultCulture;
    }

    public void setDefaultCulture(DefaultCulture defaultCulture) {
        this.defaultCulture = defaultCulture;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public boolean isCopyLinkEnabledInVpos3() {
        return isCopyLinkEnabledInVpos3;
    }

    public void setCopyLinkEnabledInVpos3(boolean copyLinkEnabledInVpos3) {
        isCopyLinkEnabledInVpos3 = copyLinkEnabledInVpos3;
    }

    public boolean isPhoneOrderEnabledInVpos3() {
        return isPhoneOrderEnabledInVpos3;
    }

    public void setPhoneOrderEnabledInVpos3(boolean phoneOrderEnabledInVpos3) {
        isPhoneOrderEnabledInVpos3 = phoneOrderEnabledInVpos3;
    }
}
