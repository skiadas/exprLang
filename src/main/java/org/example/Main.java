package org.example;

import org.example.env.Env;
import org.example.expr.*;
import org.example.type.Type;
import org.example.value.Value;

import static org.example.expr.Expr.*;

public class Main {

    public static void main(String[] args) {
        // let x = 3
        // in if x > 2 then (x + 1) else x
        Expr program =
                let("x",
                    num(3),
                    ifThenElse(
                            isGreater(var("x"), num(2)),
                            plus(var("x"), num(1)),
                            var("x")
                              ));
//        Value result = program.eval(Env.empty());
        EvalVisitor evalVisitor = new EvalVisitor();
//        evalVisitor.visit(program, Env.empty());
        Value result = program.accept(evalVisitor, Env.empty());

        Type type = program.typeCheck(Env.empty());
        System.out.println(type);
        System.out.println(result);
        Expr program2 =
                let("x",
                    num(3),
                    plus(
                            let("x",
                                plus(var("x"), num(1)),
                                plus(var("x"), num(3))),
                            var("x")
                        ));
        Value result2 = program2.accept(evalVisitor, Env.empty());

        Type type2 = program2.typeCheck(Env.empty());
        System.out.println(type2);
        System.out.println(result2);
    }
}