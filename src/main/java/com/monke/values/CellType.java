package com.monke.values;

public enum CellType{
    VAR, CONST;

    public static CellType getType(String s) {
        s = s.toUpperCase();

        for( CellType c : CellType.values()){
            if (c.toString().compareTo(s) == 0){
                return c;
            }
        }

        return null;
    }
}
