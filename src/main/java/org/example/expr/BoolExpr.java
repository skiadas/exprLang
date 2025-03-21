package org.example.expr;

import org.example.env.Env;
import org.example.type.Type;

public class BoolExpr extends Expr {
    final boolean value;

    BoolExpr(boolean value) {
        this.value = value;
    }

    public <T, D> T accept(Visitor<T, D> visitor, D data) {
        return visitor.visit(this, data);
    }

    public Type typeCheck(Env<Type> env) {
        return Type.Bool;
    }
}
