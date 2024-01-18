package net.javaguides.springboot.exceptions;

// import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.OverridesAttribute;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ErrorDataDetails> handlerResourceNotFoundException(
                        ResourceNotFoundException exception,
                        WebRequest webRequest) {

                ErrorDataDetails errorDataDetails = new ErrorDataDetails(
                                LocalDateTime.now(),
                                exception.getMessage(),
                                webRequest.getDescription(false),
                                "USER_NOT_FOUND");

                return new ResponseEntity<>(errorDataDetails, HttpStatus.NOT_FOUND);

        }

        @ExceptionHandler(EmailAlreadyExistsException.class)
        public ResponseEntity<ErrorDataDetails> handlerEmailAlreadyExists(
                        EmailAlreadyExistsException exception,
                        WebRequest webRequest) {

                ErrorDataDetails errorDataDetails = new ErrorDataDetails(
                                LocalDateTime.now(),
                                exception.getMessage(),
                                webRequest.getDescription(false),
                                "USER_EMAIL_ALREADY_EXISTS");

                return new ResponseEntity<>(errorDataDetails, HttpStatus.BAD_REQUEST);

        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorDataDetails> handlerGlobalException(
                        Exception exception,
                        WebRequest webRequest) {

                ErrorDataDetails errorDataDetails = new ErrorDataDetails(
                                LocalDateTime.now(),
                                exception.getMessage(),
                                webRequest.getDescription(false),
                                "INTERANL_SERVER_ERROR");

                return new ResponseEntity<>(errorDataDetails, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                        HttpHeaders headers, HttpStatusCode status, WebRequest request) {
                                Map<String, String> errors = new HashMap<>();
                                        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
                        
                                        errorList.forEach((error) -> {
                                                String fieldName = ((FieldError) error).getField();
                                                String message = error.getDefaultMessage();
                                                errors.put(fieldName, message);
                                        });
                        
                                        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
}
