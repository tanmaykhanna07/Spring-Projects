package com.company.license_manager.exceptions;

public class LicenseLimitExceededException extends RuntimeException{
    public LicenseLimitExceededException(String message){
        super(message);
    }
}
