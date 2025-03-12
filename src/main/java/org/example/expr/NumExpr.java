package org.example.expr;

import org.example.env.Env;
import org.example.type.Type;
import org.example.value.Value;

public class NumExpr extends Expr {
    final double value;

    NumExpr(double value) {
        this.value = value;
    }

    public <T, D> T accept(Visitor<T, D> visitor, D data) {
        return visitor.visit(this, data);
    }

    public Value eval(Env<Value> env) {
        return Value.dbl(value);
    }

    public Type typeCheck(Env<Type> env) {
        return Type.Dbl;
    }
}
