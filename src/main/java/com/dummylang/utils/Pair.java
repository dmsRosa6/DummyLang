package com.dummylang.utils;

public class Pair<K,T> {

    private final K first;
    private final T second;

    public Pair(K first, T second){
        this.first = first;
        this.second = second;
    }

    public K getFirst(){
        return this.first;
    }

    public T getSecond(){
        return this.second;
    }
}
