package org.example.env;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Env<T> {
    private Env<T> parent;
    private Map<String, T> map = new HashMap<>();

    private Env(Env<T> parent) {
        this.parent = parent;
    }

    public static <T> Env<T> empty() {
        return new Env<T>(null);
    }

    public static <T> Env<T> extend(Env<T> parent) {
        return new Env<T>(parent);
    }

    public boolean contains(String s) {
        if (map.containsKey(s)) return true;
        if (parent == null) return false;
        return parent.contains(s);
    }

    public Optional<T> getValue(String s) {
        if (map.containsKey(s)) return Optional.of(map.get(s));
        if (parent == null) return Optional.empty();
        return parent.getValue(s);
    }

    // If value exists in this, update it
    // Otherwise if value exists in ancestor, update there
    // Otherwise add to this
    public void setValue(String s, T v) {
        if (map.containsKey(s)) map.put(s, v);
        else if (contains(s)) parent.setValue(s, v);
        else map.put(s, v);
    }
}
