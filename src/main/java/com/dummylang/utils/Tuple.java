package com.dummylang.utils;

public class Tuple<K,T,S> {

    private final K first;
    private final T second;
    private final S third;

    public Tuple(K first, T second, S third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public K getFirst(){
        return this.first;
    }

    public T getSecond(){
        return this.second;
    }

    public S getThird(){
        return this.third;
    }
}
