package guru.springframework.ck.v3.api;

import guru.springframework.ck.v3.model.Forms;
import guru.springframework.ck.v3.model.SubscriptionEntity;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jt on 11/16/16.
 */

public class FormsApiImpl implements FormsAPI {

    private final String apiKey;
    private final String apiSecret;

    private static final String BASE_URL = "https://api.convertkit.com";
    private static final String FORMS_API = BASE_URL + "/v3/forms";
    private static final String COURSES_API = BASE_URL + "/v3/courses";
    private static final String TAGS_API = BASE_URL + "/v3/tags";
    private static final String SUBSCRIBERS_API = BASE_URL + "/v3/subscribers";

    private static final Logger LOG = Logger.getLogger(FormsApiImpl.class);

    public FormsApiImpl(String apiKey, String apiSecret) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    @Override
    public Forms listForms() {
        RestTemplate restTemplate = new RestTemplate();
        String urlToGETList = FORMS_API + "?api_key=" + apiKey;
        ResponseEntity<Forms> forms = restTemplate.getForEntity(urlToGETList, Forms.class);

        return forms.getBody();
    }

    @Override
    public SubscriptionEntity addSubscriberToForm(String email, String formId)
      throws ConvertKitApiException {
        String url = FORMS_API + "/" + formId + "/subscribe";
        SubscriptionEntity subscriptionEntity = makePOSTCallToAPIWithEmail(url, email);
        return subscriptionEntity;
    }

    @Override
    public SubscriptionEntity addSubscriberToEmailSequence(String courseId, String email)
      throws ConvertKitApiException {
        String url = COURSES_API + "/" + courseId + "/subscribe";
        SubscriptionEntity subscriptionEntity = makePOSTCallToAPIWithEmail(url, email);
        return subscriptionEntity;
    }

    @Override
    public SubscriptionEntity tagSubscriber(String tagId, String email)
      throws ConvertKitApiException {
        String url = TAGS_API + "/" + tagId + "/subscribe";
        SubscriptionEntity subscriptionEntity = makePOSTCallToAPIWithEmail(url, email);
        return subscriptionEntity;
    }

    @Override
    public void removeTagsFromSubscriber(String subscriberId, String tagId)
      throws ConvertKitApiException {
        String url =
          SUBSCRIBERS_API + "/" + subscriberId + "/tags/" + tagId + "?api_secret=" + apiSecret;
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.delete(url);
        } catch (RestClientException ex) {
            throw new ConvertKitApiException("RestClientException occurred while making REST call",
              ex);
        }
    }

    private SubscriptionEntity makePOSTCallToAPIWithEmail(String url, String email)
      throws ConvertKitApiException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("api_key", apiKey);
        map.add("email", email);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);

        ResponseEntity<SubscriptionEntity> subscriptionResponseEntity;
        try {
            subscriptionResponseEntity =
              restTemplate.postForEntity(url, request, SubscriptionEntity.class);
        } catch (RestClientException ex) {
            throw new ConvertKitApiException("RestClientException occurred while making REST call",
              ex);
        }
        return subscriptionResponseEntity.getBody();
    }
}
