package com.dummylang.values;

public class VFloat implements IValue{

    float value;

    public VFloat(float value){
        this.value = value;
    }

    public float getValue(){
        return value;
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }
}
