package modules.policies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
    @JsonProperty("Symbol")
    public String symbol;
    @JsonProperty("Id")
    public int id;
    @JsonProperty("Code")
    public String code;
    @JsonProperty("Description")
    public String description;
}
