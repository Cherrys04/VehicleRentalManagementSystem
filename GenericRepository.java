package com.vehiclerental.collection;

import java.util.ArrayList;
import java.util.List;

public class GenericRepository<T> {
    private List<T> items = new ArrayList<>();
    public void add(T item) { items.add(item); }
    public List<T> getAll() { return items; }
    public int size() { return items.size(); }
    public void clear() { items.clear(); }
}