package org.example.value;

import org.example.env.Env;
import org.example.expr.FuncExpr;

public class ClosureValue extends Value {
    public final FuncExpr func;
    public final Env<Value> env;

    ClosureValue(FuncExpr func, Env<Value> env) {
        this.func = func;
        this.env = env;
    }
}
