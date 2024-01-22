package ru.gb;

public class Pair<T, K> {
    private final T first;
    private final K second;
    
    public Pair(T first, K second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public K getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair(" + first + ", " + second + ")";
    }
}
