package guru.springframework.ck.v3.model;

/**
 * Created by jt on 11/17/16.
 */
public class Subscription {

    private Integer id;
    private String state;
    private String createdAt;
    private String source;
    private String referrer;
    private String subscribableId;
    private String subscribableType;
    private Subscriber subscriber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getSubscribableId() {
        return subscribableId;
    }

    public void setSubscribableId(String subscribableId) {
        this.subscribableId = subscribableId;
    }

    public String getSubscribableType() {
        return subscribableType;
    }

    public void setSubscribableType(String subscribableType) {
        this.subscribableType = subscribableType;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }
}
