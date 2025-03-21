package org.example.expr;

import org.example.env.Env;
import org.example.type.Type;

public class GreaterExpr extends Expr {
    final Expr e1;
    final Expr e2;

    GreaterExpr(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public <T, D> T accept(Visitor<T, D> visitor, D data) {
        return visitor.visit(this, data);
    }

    public Type typeCheck(Env<Type> env) {
        Type e1Type = e1.typeCheck(env);
        Type e2Type = e2.typeCheck(env);

        if (e1Type != Type.Dbl || e2Type != Type.Dbl)
            throw new RuntimeException("Can only compare numbers");
        return Type.Bool;
    }
}
