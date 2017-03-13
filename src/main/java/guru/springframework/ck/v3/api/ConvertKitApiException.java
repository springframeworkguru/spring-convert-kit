package guru.springframework.ck.v3.api;

/**
 * Created by Mohd Farid on 04/03/17.
 */
public class ConvertKitApiException extends Exception {
    public ConvertKitApiException() {
    }

    public ConvertKitApiException(String message) {
        super(message);
    }

    public ConvertKitApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConvertKitApiException(Throwable cause) {
        super(cause);
    }

    public ConvertKitApiException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
