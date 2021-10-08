package dev.solvia.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InstructorIsAlreadyExistException extends  RuntimeException{
    public InstructorIsAlreadyExistException(String message) {
        super(message);
    }
}

