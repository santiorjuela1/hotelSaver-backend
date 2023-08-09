package hotelSaver.com.hotelSaver.web.exceptions.types;

public class NotFoundException extends RuntimeException{
    private String message;

    public NotFoundException(String message){
        super(message);
    }
}
