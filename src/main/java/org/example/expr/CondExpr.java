package org.example.expr;

import org.example.env.Env;
import org.example.type.Type;

// Conditional: if-then-else, or rather a ? b : c
public class CondExpr extends Expr {
    final Expr cond; // the condition
    final Expr trueCase;
    final Expr falseCase;

    CondExpr(Expr cond, Expr trueCase, Expr falseCase) {
        this.cond = cond;
        this.trueCase = trueCase;
        this.falseCase = falseCase;
    }

    public <T, D> T accept(Visitor<T, D> visitor, D data) {
        return visitor.visit(this, data);
    }

    public Type typeCheck(Env<Type> env) {
        Type testType = cond.typeCheck(env);
        if (testType != Type.Bool) throw new RuntimeException("Test type should be bool");
        Type trueType = trueCase.typeCheck(env);
        Type falseType = falseCase.typeCheck(env);
        if (trueType != falseType) throw new RuntimeException("True and False branch types must match");
        return trueType;
    }
}
