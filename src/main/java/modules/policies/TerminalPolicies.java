package modules.policies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TerminalPolicies {

    @JsonProperty("AllowedNumberOfInstallments")
    public List<Integer> allowedNumberOfInstallments;
    @JsonProperty("Currencies")
    public List<Currency> currencies;
    @JsonProperty("MinAmount")
    public double minAmount;
    @JsonProperty("MaxAmount")
    public double maxAmount;
    @JsonProperty("TryFundPlanByDefault")
    public boolean tryFundPlanByDefault;
    @JsonProperty("HasAvailableCredit")
    public boolean hasAvailableCredit;
    @JsonProperty("DefaultPlanStrategy")
    public String defaultPlanStrategy;
    @JsonProperty("DelayedChargeVPOS")
    public boolean delayedChargeVPOS;
    @JsonProperty("TransactionLimits")
    public List<Object> transactionLimits;

    public TerminalPolicies(){
        allowedNumberOfInstallments = new ArrayList<>();
        currencies = new ArrayList<>();
        transactionLimits = new ArrayList<>();
    }
}
