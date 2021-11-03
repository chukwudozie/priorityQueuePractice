package Exceptions;

public class LibraryException extends RuntimeException {
//    private  String message;
//
//    @Override
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }

    public LibraryException(String message){
        super(message);
//        this.message = message;
    }
}
