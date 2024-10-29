package com.monke.values;

public class VCell implements IValue{
    IValue value;
    final CellType type;

    public VCell(IValue value, CellType type){
        this.value = value;
        this.type = type;
    }

    public IValue get(){
        return value;
    }

    public void set(IValue value){
        this.value = value;
    }

    public boolean isDynamic() {
        return this.type.compareTo(CellType.CONST) != 0;
    }

    @Override
    public String toString(){
        return "Cell@"+this.hashCode();
    }
}
