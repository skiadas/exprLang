package org.example.expr;

import org.example.env.Env;
import org.example.value.Value;

import java.util.Optional;

public class EvalVisitor implements Visitor<Value, Env<Value>> {
    public Value visit(BoolExpr expr, Env<Value> env) {
        return Value.bool(expr.value);
    }

    public Value visit(CondExpr expr, Env<Value> env) {
        boolean test = expr.cond.eval(env).asBoolean();
        if (test) return expr.trueCase.eval(env);
        else return expr.falseCase.eval(env);
    }

    public Value visit(GreaterExpr expr, Env<Value> env) {
        double v1 = expr.e1.eval(env).asDouble();
        double v2 = expr.e2.eval(env).asDouble();
        return Value.bool(v1 > v2);
    }

    public Value visit(LetExpr expr, Env<Value> env) {
        Value v = expr.e1.eval(env);
        Env<Value> env2 = Env.extend(env);
        env2.setValue(expr.symbol, v);
        return expr.e2.eval(env2);
    }

    public Value visit(NumExpr expr, Env<Value> env) {
        return Value.dbl(expr.value);
    }

    public Value visit(PlusExpr expr, Env<Value> env) {
        double v1 = expr.e1.eval(env).asDouble();
        double v2 = expr.e2.eval(env).asDouble();
        return Value.dbl(v1 + v2);
    }

    public Value visit(VarExpr expr, Env<Value> env) {
        Optional<Value> vOpt = env.getValue(expr.symbol);
        if (vOpt.isPresent()) return vOpt.get();
        throw new RuntimeException("Unknown variable: " + expr.symbol);
    }
}
