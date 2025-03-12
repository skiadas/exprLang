package org.example.value;

public abstract class Value {
    public static Value bool(boolean v) {
        return new BooleanValue(v);
    }

    public static Value dbl(double v) {
        return new DoubleValue(v);
    }

    public double asDouble() {
        throw new RuntimeException("Cannot convert to double");
    }

    public boolean asBoolean() {
        throw new RuntimeException("Cannot convert to boolean");
    }
}
