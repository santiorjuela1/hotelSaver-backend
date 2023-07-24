package hotelSaver.com.hotelSaver.web.exceptions;

import com.fasterxml.jackson.databind.DatabindException;
import hotelSaver.com.hotelSaver.web.exceptions.types.BadRequestException;
import hotelSaver.com.hotelSaver.web.exceptions.types.NullPointerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class CustomisezResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(
            BadRequestException exception, WebRequest webRequest){

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
                webRequest.getDescription(true), HttpStatus.BAD_GATEWAY.getReasonPhrase());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public final ResponseEntity<ExceptionResponse> handleNullPointerException(NullPointerException nullPointerException, WebRequest webRequest){

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), nullPointerException.getMessage(),
                webRequest.getDescription(true), HttpStatus.N)
    }

}
