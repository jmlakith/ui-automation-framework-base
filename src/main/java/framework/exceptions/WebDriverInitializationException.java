package framework.exceptions;

public class WebDriverInitializationException extends Throwable {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public WebDriverInitializationException(String message) {
        this.message = message;
    }


}
