package guru.springframework.ck.v3.api;

import guru.springframework.ck.v3.model.Forms;
import guru.springframework.ck.v3.model.SubscriptionEntity;

/**
 * Created by jt on 11/16/16.
 */
public interface FormsAPI {

    Forms listForms();

    SubscriptionEntity addSubscriberToForm(String email, String formId)
      throws ConvertKitApiException;

    SubscriptionEntity addSubscriberToEmailSequence(String courseId, String email)
      throws ConvertKitApiException;

    SubscriptionEntity tagSubscriber(String tagId, String email) throws ConvertKitApiException;

    void removeTagsFromSubscriber(String subscriberId, String tagId) throws ConvertKitApiException;
}
