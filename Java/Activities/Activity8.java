package activities;

public class Activity8 {
    public static void main(String[] args){
        try {
            // Method call with correct input
            Activity8.exceptionTest("Will print to console");
            // Method call with incorrect input
            Activity8.exceptionTest(null); // Exception is thrown here
            Activity8.exceptionTest("Won't execute");
        } catch(CustomException mae) {
            System.out.println("Inside catch block: " + mae.getMessage());
        }
    }
    static void exceptionTest(String S) throws CustomException{
        if(S==null) {
            throw new CustomException("String value is null");
        }else{
            System.out.println(S);
        }

    }

    public static class CustomException extends Exception{
        private String message;

        public CustomException(String S){
            message=S;
        }

        @Override
        public String getMessage() {
            return message;
        }

    }
}
