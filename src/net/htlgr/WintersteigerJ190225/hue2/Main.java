package net.htlgr.WintersteigerJ190225.hue2;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //HalloJavamitForEach halloJavamitForEach = new HalloJavamitForEach();
        //halloJavamitForEach.differentForEach();
        /*
        NumberTester numberTester = new NumberTester("C:\\Users\\jakob\\Documents\\3.Klasse\\Pos\\Lambda\\Numbers.txt");
        NumberTest oddEvenTester = number -> {
            if (number % 2 == 0) {
                return false;
            } else {
                return true;
            }
        };
        numberTester.setOddEvenTester(oddEvenTester);
        NumberTest isPrimeTester = number -> {
            if (oddEvenTester.testNumber(number)) {
                for (int i = 3; i <= number-1; i += 2) {
                    if (number % i == 0) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        };
        numberTester.setPrimeTester(isPrimeTester);
        NumberTest palindromeTester = number -> Integer.toString(number).equals(new StringBuilder(Integer.toString(number)).reverse().toString());
        numberTester.setPalindromeTester(palindromeTester);

        numberTester.testFile();
         */
        CalculationOperation rationalAdd, rationalSubstract,  rationalMultiply,  rationalDivide;

        rationalAdd = (x, y) -> {
            Number result = new Number();
            result.setA(x.getA() + y.getA());
            return result;
        };
        rationalSubstract = (x, y) -> {
            Number result = new Number();
            result.setA(x.getA() - y.getA());
            return result;
        };
        rationalMultiply = (x, y) -> {
            Number result = new Number();
            result.setA(x.getA() * y.getA());
            return result;
        };
        rationalDivide = ((x, y) -> {
            Number result = new Number();
            result.setA(x.getA() / y.getA());
            return result;
        });
        AbstractCalculator rationalCalculator = new RationalCalculator(rationalAdd,rationalSubstract,rationalMultiply,rationalDivide);

        CalculationOperation vectorAdd, vectorSubstract,  vectorMultiply,  vectorDivide;

        vectorAdd = (x, y) -> {
            Number result = new Number();
            result.setA(x.getA() + y.getA());
            result.setB(x.getB() + y.getB());
            return result;
        };
        vectorSubstract = (x, y) -> {
            Number result = new Number();
            result.setA(x.getA() - y.getA());
            result.setB(x.getB() - y.getB());
            return result;
        };

        //returns the Dot Product of two vectors
        vectorMultiply = (x, y) -> {
            Number result = new Number();
            double productA = x.getA() * y.getA();
            double productB = x.getB() * y.getB();
            result.setA(productA + productB);
            return result;
        };

        //dividing Vectors is impossible
        //TODO find a way to do the impossible
        vectorDivide = (x, y) -> {
          return null;
        };
        AbstractCalculator vectorCalculator = new RationalCalculator(vectorAdd,vectorSubstract,vectorMultiply,vectorDivide);
    }
}