package edu.blitstein.calc.engine.op;

import edu.blitstein.calc.engine.op.UnaryOperation;
import edu.blitstein.calc.engine.op.UnaryOperationFactory;
import edu.blitstein.calc.exception.DivideByZeroException;
import edu.blitstein.calc.exception.UnknownOpException;

public class UnaryCalculator {

    private double result;

    public UnaryCalculator() {
        this.result = 0.0;
    }

    public UnaryCalculator(double initialValue) {
        result = initialValue;
    }

    public void reset() {
        result = 0;
    }

    public void setResult(double newResult) {
        result = newResult;
    }

    public double getResult() {
        return result;
    }

    public double evaluate(String opString, double n1)
            throws DivideByZeroException, UnknownOpException {
        double answer;
        UnaryOperation op = UnaryOperationFactory.getOperation(opString);
        answer = op.apply(n1);
        return answer;
    }

}
