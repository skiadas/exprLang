package org.example.expr;

import org.example.env.Env;
import org.example.type.Type;

public class ApplyExpr extends Expr {
    final Expr func;
    final Expr arg;

    ApplyExpr(Expr func, Expr arg) {
        this.func = func;
        this.arg = arg;
    }

    public <T, D> T accept(Visitor<T, D> visitor, D data) {
        return visitor.visit(this, data);
    }

    public Type typeCheck(Env<Type> env) {
        return null;
    }
}
