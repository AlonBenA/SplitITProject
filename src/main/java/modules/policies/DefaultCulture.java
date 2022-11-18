package modules.policies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultCulture {
    @JsonProperty("ParentName")
    public String parentName;
    @JsonProperty("CultureName")
    public String cultureName;
    @JsonProperty("DisplayName")
    public String displayName;
    @JsonProperty("IsoCountryName")
    public String isoCountryName;
    @JsonProperty("IsoLanguageName")
    public String isoLanguageName;
    @JsonProperty("LCID")
    public int lCID;
}
