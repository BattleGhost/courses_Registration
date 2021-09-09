package org.example.model.exceptions;

import java.io.IOException;

public class LoginIsAlreadyTakenException extends IOException {
    public LoginIsAlreadyTakenException() {
        super();
    }

    public LoginIsAlreadyTakenException(String message) {
        super(message);
    }
}
