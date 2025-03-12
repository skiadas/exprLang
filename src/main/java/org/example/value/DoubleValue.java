package org.example.value;

public class DoubleValue extends Value {
    public final double value;

    DoubleValue(double value) {
        this.value = value;
    }

    public double asDouble() {
        return value;
    }
}
