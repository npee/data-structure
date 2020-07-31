package structures.exception;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException() {
        super("Element is not found");
    }

    public ElementNotFoundException(String message) {
        super("The target element is not in this " + message);
    }
}
