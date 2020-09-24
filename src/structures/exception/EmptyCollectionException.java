package structures.exception;

//********************************************************************
//  EmptyCollectionException.java     Authors: Lewis/Chase
//
//  Represents the situation in which a collection is empty.
//********************************************************************

public class EmptyCollectionException extends RuntimeException {
    public EmptyCollectionException(String collection) {
        super("The " + collection + " is empty.");
    }
}
