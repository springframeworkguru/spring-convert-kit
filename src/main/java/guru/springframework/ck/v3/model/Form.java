package guru.springframework.ck.v3.model;

/**
 * Created by jt on 11/16/16.
 */
public class Form {
    private Integer id;
    private String name;
    private String createdAt;
    private String type;
    private String url;
    private String embedJs;
    private String embedUrl;
    private String title;
    private String description;
    private String signUpButtonText;
    private String successMessage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmbedJs() {
        return embedJs;
    }

    public void setEmbedJs(String embedJs) {
        this.embedJs = embedJs;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSignUpButtonText() {
        return signUpButtonText;
    }

    public void setSignUpButtonText(String signUpButtonText) {
        this.signUpButtonText = signUpButtonText;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
}
