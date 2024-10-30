package com.monke.values;

public class VInt implements IValue{
    int v;

    public VInt(int v){
        this.v = v;
    }


    @Override
    public String toString() {
        return  Integer.toString(v);
    }

    public Integer getValue(){
        return v;
    }
}
