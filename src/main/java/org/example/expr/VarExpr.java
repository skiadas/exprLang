package org.example.expr;

import org.example.env.Env;
import org.example.type.Type;
import org.example.value.Value;

import java.util.Optional;

public class VarExpr extends Expr {
    final String symbol;

    VarExpr(String symbol) {
        this.symbol = symbol;
    }

    public <T, D> T accept(Visitor<T, D> visitor, D data) {
        return visitor.visit(this, data);
    }

    public Value eval(Env<Value> env) {
        Optional<Value> vOpt = env.getValue(symbol);
        if (vOpt.isPresent()) return vOpt.get();
        throw new RuntimeException("Unknown variable: " + symbol);
    }

    public Type typeCheck(Env<Type> env) {
        Optional<Type> vOpt = env.getValue(symbol);
        if (vOpt.isPresent()) return vOpt.get();
        throw new RuntimeException("Unknown variable: " + symbol);
    }
}
