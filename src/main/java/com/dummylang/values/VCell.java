package com.dummylang.values;

public class VCell implements IValue{
    IValue value;

    public VCell(IValue value){
        this.value = value;
    }

    public IValue get(){
        return value;
    }

    public void set(IValue value){
        this.value = value;
    }

    @Override
    public String toString(){
        return "Cell@"+this.hashCode();
    }
}
