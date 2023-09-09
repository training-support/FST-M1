package Activities;

class CustomException extends Exception {
    private String message;

    public CustomException(String msg) {
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

public class Activity8 {
    public static void main(String[] args){
        try {

            Activity8.exceptionTest("Will print to console");
            Activity8.exceptionTest(null);
        } catch(CustomException errorMsg) {
            System.out.println(errorMsg.getMessage());
        }
    }

    static void exceptionTest(String string1) throws CustomException {
        if(string1 == null) {
            throw new CustomException("String is null");
        } else {
            System.out.println(string1);
        }
    }
}
