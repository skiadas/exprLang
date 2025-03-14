package org.example.expr;

import org.example.env.Env;
import org.example.type.Type;

public class FuncExpr extends Expr {
    final String param;
    final Expr body;

    FuncExpr(String param, Expr body) {
        this.param = param;
        this.body = body;
    }

    public <T, D> T accept(Visitor<T, D> visitor, D data) {
        return visitor.visit(this, data);
    }

    public Type typeCheck(Env<Type> env) {
        return null;
    }
}
