package com.ToDo.TODO.Exception;

public class ResourcNotFoundException extends RuntimeException{
    public ResourcNotFoundException (String message){
        super(message);
    }
    public ResourcNotFoundException (){
        super("Task not found");
    }

}
