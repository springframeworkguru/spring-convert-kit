package guru.springframework.ck.v3.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jt on 11/17/16.
 */
public class AddSubscriberToForm {

    private String apiKey;
    private String email;


    public String getApiKey() {
        return apiKey;
    }

    @JsonProperty("api_key")
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
