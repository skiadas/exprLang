package org.example.expr;

import org.example.env.Env;
import org.example.value.ClosureValue;
import org.example.value.Value;

import java.util.Optional;

public class EvalVisitor implements Visitor<Value, Env<Value>> {
    public Value visit(BoolExpr expr, Env<Value> env) {
        return Value.bool(expr.value);
    }

    public Value visit(CondExpr expr, Env<Value> env) {
        boolean test = expr.cond.accept(this, env).asBoolean();
        if (test) return expr.trueCase.accept(this, env);
        else return expr.falseCase.accept(this, env);
    }

    public Value visit(GreaterExpr expr, Env<Value> env) {
        double v1 = expr.e1.accept(this, env).asDouble();
        double v2 = expr.e2.accept(this, env).asDouble();
        return Value.bool(v1 > v2);
    }

    public Value visit(LetExpr expr, Env<Value> env) {
        Value v = expr.e1.accept(this, env);
        Env<Value> env2 = Env.extend(env);
        env2.setValue(expr.symbol, v);
        return expr.e2.accept(this, env2);
    }

    public Value visit(NumExpr expr, Env<Value> env) {
        return Value.dbl(expr.value);
    }

    public Value visit(PlusExpr expr, Env<Value> env) {
        double v1 = expr.e1.accept(this, env).asDouble();
        double v2 = expr.e2.accept(this, env).asDouble();
        return Value.dbl(v1 + v2);
    }

    public Value visit(VarExpr expr, Env<Value> env) {
        Optional<Value> vOpt = env.getValue(expr.symbol);
        if (vOpt.isPresent()) return vOpt.get();
        throw new RuntimeException("Unknown variable: " + expr.symbol);
    }

    public Value visit(FuncExpr expr, Env<Value> env) {
        return Value.closure(expr, env);
    }

    public Value visit(ApplyExpr expr, Env<Value> env) {
        Expr func = expr.func;
        Expr arg = expr.arg;
        Value funcValue = func.accept(this, env);
        Value argValue = arg.accept(this, env);
        ClosureValue closure = (ClosureValue) funcValue;
        FuncExpr actualFunc = closure.func;
        Env<Value> env2 = closure.env;
        String param = actualFunc.param;
        Expr body = actualFunc.body;
        // extend env2 with param=argValue
        Env<Value> env3 = Env.extend(env2);
        env3.setValue(param, argValue);
        return body.accept(this, env3);
    }
}
