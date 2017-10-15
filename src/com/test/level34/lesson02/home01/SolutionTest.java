package com.test.level34.lesson02.home01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SolutionTest extends Assert {
    private com.javarush.test.level34.lesson02.home01.Solution solution = new com.javarush.test.level34.lesson02.home01.Solution();
    private static List<Test> tests = new ArrayList<>();
    private ByteArrayOutputStream byteConsole;
    private PrintStream backConsole;


    private class Test {
        String expression;
        String result;
        int count;

        Test(String expression, String result, int count) {
            this.expression = expression;
            this.result = result;
            this.count = count;
        }
    }

    @Before
    public void before() {
        tests.add(new Test("sin(2*(-5+1.5*4)+28)", "0.5", 6));
        tests.add(new Test("tan(45)", "1", 1));
        tests.add(new Test("0.305", "0.3", 0));
        tests.add(new Test("0.3051", "0.31", 0));
        tests.add(new Test("1+(1+(1+1)*(1+1))*(1+1)+1", "12", 8));
        tests.add(new Test("tan(44+sin(89-cos(180)^2))", "1", 6));
        tests.add(new Test("-2+(-2+(-2)-2*(2+2))", "-14", 8));
        tests.add(new Test("sin(80+(2+(1+1))*(1+1)+2)", "1", 7));
        tests.add(new Test("1+4/2/2+2^2+2*2-2^(2-1+1)", "6", 11));
        tests.add(new Test("2^10+2^(5+5)", "2048", 4));
        tests.add(new Test("1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1", "72.96", 8));
        tests.add(new Test("0.000025+0.000012", "0", 1));
        tests.add(new Test("-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)", "-3", 16));
        tests.add(new Test("cos(3 + 19*3)", "0.5", 3));
        tests.add(new Test("2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)", "8302231.36", 14));
        tests.add(new Test("(-1 + (-2))", "-3", 3));
        tests.add(new Test("-sin(2*(-5+1.5*4)+28)", "-0.5", 7));
        tests.add(new Test("sin(100)-sin(100)", "0", 3));
        tests.add(new Test("(-2)^(-2)", "0.25", 3));
        tests.add(new Test("89-cos(180)^2", "88", 3));
        tests.add(new Test("sin(2*(-5+1.5*4)+28)", "0.5", 6));
        tests.add(new Test("tan(45)", "1", 1));
        tests.add(new Test("tan(-45)", "-1", 2));
        tests.add(new Test("0.305", "0.3", 0));
        tests.add(new Test("0.3051", "0.31", 0));
        tests.add(new Test("(0.3051)", "0.31", 0));
        tests.add(new Test("1+(1+(1+1)*(1+1))*(1+1)+1", "12", 8));
        tests.add(new Test("tan(44+sin(89-cos(180)^2))", "1", 6));
        tests.add(new Test("-2+(-2+(-2)-2*(2+2))", "-14", 8));
        tests.add(new Test("sin(80+(2+(1+1))*(1+1)+2)", "1", 7));
        tests.add(new Test("1+4/2/2+2^2+2*2-2^(2-1+1)", "6", 11));
        tests.add(new Test("2^10+2^(5+5)", "2048", 4));
        tests.add(new Test("1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1", "72.96", 8));
        tests.add(new Test("0.000025+0.000012", "0", 1));
        tests.add(new Test("-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)", "-3", 16));
        tests.add(new Test("cos(3 + 19*3)", "0.5", 3));
        tests.add(new Test("2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)", "8302231.36", 14));
        tests.add(new Test("(-1+(-2))", "-3", 3));
        tests.add(new Test("-sin(2*(-5+1.5*4)+28)", "-0.5", 7));
        tests.add(new Test("sin(100)-sin(100)", "0", 3));
        tests.add(new Test("-(-22+22*2)", "-22", 4));
        tests.add(new Test("-2^(-2)", "-0.25", 3));
        tests.add(new Test("-(-2^(-2))+2+(-(-2^(-2)))", "2.5", 10));
        tests.add(new Test("(-2)*(-2)", "4", 3));
        tests.add(new Test("(-2)/(-2)", "1", 3));
        tests.add(new Test("sin(-30)", "-0.5", 2));
        tests.add(new Test("cos(-30)", "0.87", 2));
        tests.add(new Test("tan(-30)", "-0.58", 2));
        tests.add(new Test("0.005 ", "0.01", 0));
        tests.add(new Test("0.0049 ", "0", 0));
        tests.add(new Test("0+0.304", "0.3", 1));
        tests.add(new Test("sin(2*(-5+1.5*4)+28) - 1", "-0.5", 7));
        tests.add(new Test("tan(45)", "1", 1));
        tests.add(new Test("sin(100)-sin(100)", "0", 3));
        tests.add(new Test("sin(2*(-5+1.5*4)+43)-cos(2*(-5+1.5*4)+43)", "-0", 13));
        tests.add(new Test("0.000025+0.000012", "0", 1));
        tests.add(new Test("2+8*(9/4-1.5)^(1+1)", "6.5", 6));


        byteConsole = new ByteArrayOutputStream();
        backConsole = System.out;
        System.setOut(new PrintStream(byteConsole));
    }

    @After
    public void after() {
        System.setOut(backConsole);
    }

    @org.junit.Test
    public void recursion() throws Exception {
        for (Test test : tests) {
            solution.recursion(test.expression, 0);
            System.out.flush();
            String expected = test.result + " " + test.count;
            String result = byteConsole.toString().replace(System.lineSeparator(), "");
            byteConsole.reset();

            boolean isPassed = expected.equals(result);
            System.err.printf("%-67s | expected: %-13s | result: %-13s | %s\n"
                    , test.expression
                    , expected
                    , result
                    , isPassed ? "passed" : "not passed");
            assertTrue(isPassed);
        }
    }
}
