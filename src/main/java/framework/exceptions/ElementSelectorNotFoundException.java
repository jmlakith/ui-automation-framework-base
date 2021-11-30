package framework.exceptions;

public class ElementSelectorNotFoundException extends Throwable {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public ElementSelectorNotFoundException(String message) {
        this.message = message;
    }
}
