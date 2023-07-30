package hotelSaver.com.hotelSaver.web.exceptions.types;

public class IllegalArgumentException extends RuntimeException{
    private String message;
    IllegalArgumentException(String message){
        super(message);
    }
}
