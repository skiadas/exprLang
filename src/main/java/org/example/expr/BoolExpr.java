package org.example.expr;

import org.example.env.Env;
import org.example.type.Type;
import org.example.value.Value;

public class BoolExpr extends Expr {
    final boolean value;

    BoolExpr(boolean value) {
        this.value = value;
    }

    public Value eval(Env<Value> env) {
        return Value.bool(value);
    }

    public Type typeCheck(Env<Type> env) {
        return Type.Bool;
    }
}
