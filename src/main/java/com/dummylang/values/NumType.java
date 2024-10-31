package com.dummylang.values;

public enum NumType{
    INT, FLOAT;

    public static NumType getType(String s){

        for (NumType n : NumType.values()){
            if(n.toString().compareTo(s.toUpperCase()) == 0) {
                return n;
            }
        }

        return null;
    }
}
