package tng3.base;

public class APIResponse {

    private boolean success;
    private Object payload;
    private Error error;


    public boolean getSuccess(){
        return success;
    }

    public Object getPayload(){
        return payload;
    }

    public Error getError() {
        return error;
    }

    public int getErrorCode() {
        return this.error.getCode();
    }

    public String getErrorMessage() {
        return this.error.getMessage();
    }




    public class Error {
        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

}
