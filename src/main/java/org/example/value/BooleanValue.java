package org.example.value;

public class BooleanValue extends Value {
    public final Boolean value;

    BooleanValue(Boolean value) {
        this.value = value;
    }

    public boolean asBoolean() {
        return value;
    }
}
