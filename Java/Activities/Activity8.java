package activities;

public class Activity8 {
    public static void main(String[] args) {
        try{
            Activity8.exceptionTest("Will print in Console");
            Activity8.exceptionTest(null);
            Activity8.exceptionTest("Won't execute");
        }catch(CustomException mae){
            System.out.println("Custom error message is:::"+mae.getMessage());
        }
    }

        static void exceptionTest(String str) throws CustomException {
            if(str==null){
                throw new CustomException("String is null");
                            }
            else{
                System.out.println(str);
            }
        }
}

class CustomException extends Exception{
    private String message = null;

    public CustomException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}