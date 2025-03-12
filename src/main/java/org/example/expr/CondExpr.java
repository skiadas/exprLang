package org.example.expr;

import org.example.env.Env;
import org.example.type.Type;
import org.example.value.BooleanValue;
import org.example.value.Value;

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

    public Value eval(Env<Value> env) {
        boolean test = cond.eval(env).asBoolean();
        if (test) return trueCase.eval(env);
        else return falseCase.eval(env);
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
