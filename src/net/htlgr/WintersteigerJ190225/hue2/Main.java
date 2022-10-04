package net.htlgr.WintersteigerJ190225.hue2;

import java.util.Scanner;

public class Main {
    private static AbstractCalculator rationalCalculator;
    private static AbstractCalculator vectorCalculator;
    private static AbstractCalculator complexCalculator;

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
        setUpCalculators();

        Scanner sc = new Scanner(System.in);
        int next;
        AbstractCalculator calculator = null;
        double input;
        Number firstNumber = new Number();
        Number secondNumber = new Number();
        Number result = null;
        do{
            System.out.println("Choose calculator");
            System.out.println("1 - Rational calculator");
            System.out.println("2 - Vector calculator");
            System.out.println("3 - Complex calculator");
            System.out.println("4 - Exit program");
            next = sc.nextInt();
            int calcNumber = next;
            if (next == 4){
                break;
            }
            do {
            switch (calcNumber){
                case 1:
                    System.out.println("Enter first number:");
                    firstNumber.setA(sc.nextDouble());
                    System.out.println("Enter second number:");
                    secondNumber.setA(sc.nextDouble());
                    break;
                case 2:
                    System.out.println("Enter first number of first Vector:");
                    firstNumber.setA(sc.nextDouble());
                    System.out.println("Enter second number of first Vector:");
                    firstNumber.setB(sc.nextDouble());
                    System.out.println("Enter first number of second Vector:");
                    secondNumber.setA(sc.nextDouble());
                    System.out.println("Enter second number of second Vector:");
                    secondNumber.setB(sc.nextDouble());
                    break;
                case 3:
                    System.out.println("Enter real number of first complex Number");
                    firstNumber.setA(sc.nextDouble());
                    System.out.println("Enter imaginary number of first complex Number");
                    firstNumber.setB(sc.nextDouble());
                    System.out.println("Enter real number of second complex Number");
                    secondNumber.setA(sc.nextDouble());
                    System.out.println("Enter imaginary number of second complex Number");
                    secondNumber.setB(sc.nextDouble());
                    break;
            }

                showInvoiceTypes();
                next = sc.nextInt();
                if (next == 5){
                    continue;
                }
                calculator = getNumbersAndCalc(sc, calcNumber, calculator, firstNumber, secondNumber);
            }while (next == 5);
            result = calculate(next, calculator, firstNumber, secondNumber);
            showResult(result);
        }while (true);
    }

    private static void showResult(Number result) {
        System.out.println("--------------------------");
        System.out.println("Solution :");
        System.out.println("a = " + result.getA());
        System.out.println("b = " + result.getB());
        System.out.println("--------------------------");
    }

    private static Number calculate(int next, AbstractCalculator calculator, Number firstNumber, Number secondNumber) {
        Number result = null;
        switch (next) {
            case 1:
                result = calculator.add(firstNumber, secondNumber);
                break;
            case 2:
                result = calculator.subtract(firstNumber, secondNumber);
                break;
            case 3:
                result = calculator.multiply(firstNumber, secondNumber);
                break;
            case 4:
                result = calculator.divide(firstNumber, secondNumber);
                break;
        }
        return result;
    }

    private static AbstractCalculator getNumbersAndCalc(Scanner sc, int next, AbstractCalculator calculator, Number firstNumber, Number secondNumber) {
        switch (next){
            case 1:
                calculator = rationalCalculator;
                break;
            case 2:
                calculator = vectorCalculator;
                break;
            case 3:
                calculator = complexCalculator;
                break;
        }
        return calculator;
    }

    private static void showInvoiceTypes() {
        System.out.println("Choose Operation:");
        System.out.println("1 - Add");
        System.out.println("2 - Subtract");
        System.out.println("3 - Multiply");
        System.out.println("4 - Divide");
        System.out.println("5 - New Numbers");
    }

    private static void setUpCalculators(){
        CalculationOperation rationalAdd, rationalSubtract,  rationalMultiply,  rationalDivide;

        rationalAdd = (x, y) -> {
            Number result = new Number();
            result.setA(x.getA() + y.getA());
            return result;
        };
        rationalSubtract = (x, y) -> {
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
        rationalCalculator = new RationalCalculator(rationalAdd,rationalSubtract,rationalMultiply,rationalDivide);

        CalculationOperation vectorAdd, vectorSubtract,  vectorMultiply,  vectorDivide;

        vectorAdd = (x, y) -> {
            Number result = new Number();
            result.setA(x.getA() + y.getA());
            result.setB(x.getB() + y.getB());
            return result;
        };
        vectorSubtract = (x, y) -> {
            Number result = new Number();
            result.setA(x.getA() - y.getA());
            result.setB(x.getB() - y.getB());
            return result;
        };

        vectorMultiply = (x, y) -> {
            Number result = new Number();
            double productA = x.getA() * y.getA();
            double productB = x.getB() * y.getB();
            result.setA(productA - productB);
            return result;
        };

        //dot Product
        vectorDivide = (x, y) -> {
            Number result = new Number();
            double productA = x.getA() * y.getA();
            double productB = x.getB() * y.getB();
            result.setA(productA + productB);
            return result;
        };
        vectorCalculator = new RationalCalculator(vectorAdd,vectorSubtract,vectorMultiply,vectorDivide);

        CalculationOperation complexAdd, complexSubtract, complexMultiply, complexDivide;

        complexAdd = (x, y) -> {
            Number result = new Number();
            result.setA(x.getA() + y.getA());
            result.setB(x.getB() + y.getB());
            return result;
        };

        complexSubtract = (x, y) -> {
            Number result = new Number();
            result.setA(x.getA() - y.getA());
            result.setB(x.getB() - y.getB());
            return result;
        };

        complexMultiply = (x, y) -> {
            Number result = new Number();
            result.setA(x.getA() * y.getA() - x.getB() * y.getB());
            result.setB(x.getA() * y.getB() + x.getB() * y.getA());
            return result;
        };

        complexDivide = (x, y) -> {
            Number result = new Number();
            result.setA(((x.getA() * y.getA()) + (x.getB() * y.getB()))/(Math.pow(y.getA(),2) + Math.pow(y.getB(), 2)));
            result.setB(((x.getB() * y.getA()) - (x.getA() * y.getB()))/(Math.pow(y.getA(),2) + Math.pow(y.getB(), 2)));
            return result;
        };
        complexCalculator = new ComplexCalculator(complexAdd, complexSubtract, complexMultiply, complexDivide);
    }
}