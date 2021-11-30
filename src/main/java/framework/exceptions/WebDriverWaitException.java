package framework.exceptions;

public class WebDriverWaitException extends Throwable {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public WebDriverWaitException(String message) {
        this.message = message;
    }

}
