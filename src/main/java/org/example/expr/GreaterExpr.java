package org.example.expr;

import org.example.env.Env;
import org.example.type.Type;
import org.example.value.DoubleValue;
import org.example.value.Value;

public class GreaterExpr extends Expr {
    final Expr e1;
    final Expr e2;

    GreaterExpr(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public Value eval(Env<Value> env) {
        double v1 = e1.eval(env).asDouble();
        double v2 = e2.eval(env).asDouble();
        return Value.bool(v1 > v2);
    }

    public Type typeCheck(Env<Type> env) {
        Type e1Type = e1.typeCheck(env);
        Type e2Type = e2.typeCheck(env);

        if (e1Type != Type.Dbl || e2Type != Type.Dbl)
            throw new RuntimeException("Can only compare numbers");
        return Type.Bool;
    }
}
