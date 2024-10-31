package com.dummylang.utils;

public enum VarType {
    VAR, CONST;

    public static VarType getType(String s) {
        s = s.toUpperCase();

        for( VarType c : VarType.values()){
            if (c.toString().compareTo(s) == 0){
                return c;
            }
        }

        return null;
    }
}
