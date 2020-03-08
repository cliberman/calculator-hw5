package edu.blitstein.calc.engine.op;

import edu.blitstein.calc.exception.UnknownOpException;

public enum UnaryOperation {
    ABS("absoluteValue") {
        public double apply(double x) {
            if (x<0) {
                x = x * -1.0;
            }
            return x;
        }
    },
    INVERT("invert"){
        public double apply(double x) {return 1.0/x;}
    },
    OFF("@"){
        public double apply(double x) {
            System.exit(0);
            return 0.0;
        }
    };

    private String op;

    UnaryOperation(String op) {
        this.op = op;
    }

    @Override
    public String toString() {
        return op;
    }

    public abstract double apply(double x) throws ArithmeticException;
}
