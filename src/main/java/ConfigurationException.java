

public class ConfigurationException extends RuntimeException{
        String exceptionMessage;
        String cause;
        public ConfigurationException(String msgs){
            this.cause = msgs;
        }
        public String toString(){
            exceptionMessage = "Error in configuration file.please check the file for any error/Invalid Input";
            exceptionMessage += "Exception occured due to:" + this.cause;
            return exceptionMessage;
        }
    }