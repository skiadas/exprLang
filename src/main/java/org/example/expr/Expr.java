package org.example.expr;

import org.example.env.Env;
import org.example.type.Type;
import org.example.value.Value;

public abstract class Expr {
    public static Expr bool(boolean value) {
        return new BoolExpr(value);
    }
    public static Expr num(double value) {
        return new NumExpr(value);
    }
    public static Expr plus(Expr e1, Expr e2) {
        return new PlusExpr(e1, e2);
    }
    public static Expr var(String s) {
        return new VarExpr(s);
    }
    public static Expr let(String s, Expr e1, Expr e2) {
        return new LetExpr(s, e1, e2);
    }
    public static Expr isGreater(Expr e1, Expr e2) {
        return new GreaterExpr(e1, e2);
    }
    public static Expr ifThenElse(Expr e1, Expr e2, Expr e3) {
        return new CondExpr(e1, e2, e3);
    }
    public static Expr func(String param, Expr body) { return new FuncExpr(param, body); }
    public static Expr apply(Expr func, Expr arg) { return new ApplyExpr(func, arg); }

    public abstract <T, D> T accept(Visitor<T, D> visitor, D data);

    public abstract Type typeCheck(Env<Type> env);
}
