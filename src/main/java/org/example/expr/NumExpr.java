package org.example.expr;

import org.example.env.Env;
import org.example.type.Type;
import org.example.value.Value;

public class NumExpr extends Expr {
    final double value;

    NumExpr(double value) {
        this.value = value;
    }

    public Value eval(Env<Value> env) {
        return Value.dbl(value);
    }

    public Type typeCheck(Env<Type> env) {
        return Type.Dbl;
    }
}
