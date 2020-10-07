package homework11;

import javax.management.RuntimeErrorException;

public class NegativeInteger extends RuntimeException{

    public NegativeInteger(String errorMessage) {
        super(errorMessage);
    }
}
