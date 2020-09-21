package structures.exception;

//********************************************************************
//  EmptyStackException.java     Authors: Lewis/Chase
//
//  Represents the situation in which a stack is empty.
//********************************************************************

public class EmptyStackException extends RuntimeException {
    public EmptyStackException() {
        super("The stack is empty");
    }

    public EmptyStackException(String message) {
        super(message);
    }
}
