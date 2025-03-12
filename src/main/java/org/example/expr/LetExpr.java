package org.example.expr;

// Expression: let x = a in b
// Evaluate a then compute b in an environment where
// x has the value

import org.example.env.Env;
import org.example.type.Type;
import org.example.value.Value;

public class LetExpr extends Expr {
    final String symbol;
    final Expr e1;
    final Expr e2;

    LetExpr(String symbol, Expr e1, Expr e2) {
        this.symbol = symbol;
        this.e1 = e1;
        this.e2 = e2;
    }

    public Value eval(Env<Value> env) {
        Value v = e1.eval(env);
        Env<Value> env2 = Env.extend(env);
        env2.setValue(symbol, v);
        return e2.eval(env2);
    }

    public Type typeCheck(Env<Type> env) {
        Type e1Type = e1.typeCheck(env);
        Env<Type> env2 = Env.extend(env);
        env2.setValue(symbol, e1Type);
        return e2.typeCheck(env2);
    }
}
