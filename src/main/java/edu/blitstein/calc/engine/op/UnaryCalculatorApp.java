package edu.blitstein.calc.engine.op;

import edu.blitstein.calc.engine.op.UnaryCalculator;
import edu.blitstein.calc.exception.DivideByZeroException;
import edu.blitstein.calc.exception.UnknownOpException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UnaryCalculatorApp {

    public static void main(String[] args)
            throws DivideByZeroException {
        System.out.println("Calculator is on.");
        System.out.print("Format of each line: ");
        System.out.println("operator space number");
        System.out.println("For example: + 3");
        System.out.println("To end, enter the word stop.");
        System.out.print("Enter initial value: ");
        UnaryCalculator clerk = new UnaryCalculator();
        System.out.println("Starting with = " + clerk.getResult());

        String inputFileName = "src/main/java/myResources/" + args[0];
        String outputFileName = "src/main/java/myResources/" + args[1];

        Scanner input = null;
        PrintWriter pw = null;
        try {

            File file = new File(inputFileName);
            input = new Scanner(file);

            pw = new PrintWriter(outputFileName);
            pw.println("Calculator set to 0.0");

            while (input.hasNextLine()) {
                String op = input.next();
                if (op.equalsIgnoreCase("stop")) {
                    break;
                } else {
                    try {
                        double nextNum = input.nextDouble();
                        double result = clerk.evaluate(op, nextNum);
                        pw.println(op + " " + nextNum + " = " + result);
                    } catch (DivideByZeroException e) {
                        System.out.println(e.getMessage());
                    } catch (UnknownOpException e) {
                        System.out.println(e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }pw.println("Final result is: " + clerk.getResult());
            pw.println("Calculator program ending.");
        }catch(FileNotFoundException e){
            e.getMessage();
        }finally{
            if(pw != null){
                pw.close();
            }if(input != null){
                input.close();
            }
        }
    }
}



