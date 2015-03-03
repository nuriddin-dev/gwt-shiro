package testapp.client.exceptions;

import java.io.Serializable;

public class CustomException extends Exception implements Serializable {
    public CustomException(String message) {
        super(message);
    }

    public CustomException() {
    }
}
