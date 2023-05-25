package com.example.demo.core.utilities.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message); // Super RuntimeException class'ı oluyor. O da kendi super'ine yolluyor. Super; base class demektir.
    }
}
