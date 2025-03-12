package org.example.expr;

import org.example.env.Env;
import org.example.value.Value;

public class EvalVisitor implements Visitor<Value, Env<Value>> {
    public Value visit(BoolExpr expr, Env<Value> env) {
        return null;
    }

    public Value visit(CondExpr expr, Env<Value> env) {
        return null;
    }

    public Value visit(GreaterExpr expr, Env<Value> env) {
        return null;
    }

    public Value visit(LetExpr expr, Env<Value> env) {
        return null;
    }

    public Value visit(NumExpr expr, Env<Value> env) {
        return null;
    }

    public Value visit(PlusExpr expr, Env<Value> env) {
        return null;
    }

    public Value visit(VarExpr expr, Env<Value> env) {
        return null;
    }
}
