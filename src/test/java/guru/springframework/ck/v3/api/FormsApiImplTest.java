package guru.springframework.ck.v3.api;

import guru.springframework.ck.v3.model.Forms;
import guru.springframework.ck.v3.model.SubscriptionEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FormsApiImplTest {

    private FormsAPI formsAPI;

    @Before
    public void setup() {
        formsAPI = new FormsApiImpl(System.getenv("API_KEY"), System.getenv("API_SECRET"));
    }

    @Test
    public void testListForms() throws Exception {
        //when
        Forms forms = formsAPI.listForms();

        //then
        assertNotNull(forms);
        assertNotNull(forms.getForms());
    }

    @Test
    public void testAddSubscriberToForm() throws Exception {
        //when
        SubscriptionEntity subscriptionEntity =
          formsAPI.addSubscriberToForm("farid.iflex@gmail.com", "16156");

        //then
        assertNotNull(subscriptionEntity.getSubscription().getId());
        assertNotNull(subscriptionEntity.getSubscription().getSubscriber().getId());
    }

    @Test
    public void testAddSubscriberToEmailSequence() throws Exception {
        //when
        SubscriptionEntity subscriptionEntity =
          formsAPI.addSubscriberToEmailSequence("9819", "farid.iflex@gmail.com");

        //then
        assertNotNull(subscriptionEntity.getSubscription().getId());
        assertNotNull(subscriptionEntity.getSubscription().getSubscriber().getId());
    }

    @Test
    public void testAddSubscriberToEmailSequence_invalidEmail() throws Exception {
        //when
        boolean exceptionOccurred = false;
        try {
            formsAPI.addSubscriberToEmailSequence("9819", "farid.iflex#gmail.com");
        } catch (ConvertKitApiException ex) {
            exceptionOccurred = true;
        }
        assertTrue("ConvertKitApiException must have occurred as we passed an incorrect email id",
          exceptionOccurred);

    }

    @Test
    public void testTagSubscriber() throws Exception {
        //when
        SubscriptionEntity subscriptionEntity =
          formsAPI.tagSubscriber("21012", "farid.iflex@gmail.com");

        //then
        assertNotNull(subscriptionEntity.getSubscription().getId());
        assertNotNull(subscriptionEntity.getSubscription().getSubscriber().getId());
    }

    @Test
    public void testTagSubscriber_withInvalidTag() throws Exception {
        //when
        boolean exceptionOccured = false;
        try {
            formsAPI.tagSubscriber("99999999", "farid.iflex@gmail.com");
        } catch (ConvertKitApiException ex) {
            exceptionOccured = true;
        }
        assertTrue("ConvertKitApiException must have occurred as we passed an incorrect tag id",
          exceptionOccured);
    }

    @Test
    public void testRemoveTagsFromSubscriber() throws Exception {
        //given
        SubscriptionEntity subscriptionEntity =
          formsAPI.tagSubscriber("21012", "farid.iflex@gmail.com");
        assertNotNull(subscriptionEntity.getSubscription().getId());
        assertNotNull(subscriptionEntity.getSubscription().getSubscriber().getId());

        //then
        formsAPI.removeTagsFromSubscriber("94224863", "21012");
    }
}