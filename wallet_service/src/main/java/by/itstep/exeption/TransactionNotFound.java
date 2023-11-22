package by.itstep.exeption;

public class TransactionNotFound extends RuntimeException{
    public TransactionNotFound(String message){
        super(message);
    }
}
