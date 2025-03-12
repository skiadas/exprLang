package org.example.expr;

public interface Visitor<T, D> {
    T visit(BoolExpr expr, D data);
    T visit(CondExpr expr, D data);
    T visit(GreaterExpr expr, D data);
    T visit(LetExpr expr, D data);
    T visit(NumExpr expr, D data);
    T visit(PlusExpr expr, D data);
    T visit(VarExpr expr, D data);
}
