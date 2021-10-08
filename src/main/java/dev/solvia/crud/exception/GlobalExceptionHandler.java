package dev.solvia.crud.exception;



import dev.solvia.crud.model.Logger;
import dev.solvia.crud.service.LoggerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final LoggerService loggerService;

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Logger> handleException(ResourceNotFoundException resourceNotFoundException) {
        Logger response = prepareErrorResponse(HttpStatus.NOT_FOUND, resourceNotFoundException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InstructorIsAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Logger> handleException(InstructorIsAlreadyExistException instructorIsAlreadyExistException) {
        Logger response = prepareErrorResponse(HttpStatus.BAD_REQUEST, instructorIsAlreadyExistException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Logger prepareErrorResponse(HttpStatus httpStatus, String message) {
        Logger response = new Logger();
        response.setThrowStatusCode(httpStatus.value());
        response.setThrowMessage(message);
        response.setThrowDate(LocalDate.now());
        return loggerService.save(response);

    }

}