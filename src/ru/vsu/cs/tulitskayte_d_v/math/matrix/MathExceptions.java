package ru.vsu.cs.tulitskayte_d_v.math.matrix;

public class MathExceptions extends IllegalArgumentException{
    public MathExceptions(){
        super("Error in values!");
    }

    public MathExceptions(String message){
        super(message);
    }
}
