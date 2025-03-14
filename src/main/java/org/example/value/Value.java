package org.example.value;

import org.example.env.Env;
import org.example.expr.FuncExpr;

public abstract class Value {
    public static Value bool(boolean v) {
        return new BooleanValue(v);
    }

    public static Value dbl(double v) {
        return new DoubleValue(v);
    }

    public static Value closure(FuncExpr func, Env<Value> env) {
        return new ClosureValue(func, env);
    }

    public double asDouble() {
        throw new RuntimeException("Cannot convert to double");
    }

    public boolean asBoolean() {
        throw new RuntimeException("Cannot convert to boolean");
    }
}
