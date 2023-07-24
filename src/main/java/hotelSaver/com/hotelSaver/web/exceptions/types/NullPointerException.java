package hotelSaver.com.hotelSaver.web.exceptions.types;

public class NullPointerException extends RuntimeException{
    private String message;
    NullPointerException(String message){
        super(message);
    }
}
