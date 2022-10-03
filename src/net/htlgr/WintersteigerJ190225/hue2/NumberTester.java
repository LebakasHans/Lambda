package net.htlgr.WintersteigerJ190225.hue2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberTester {
    private String filename;
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;

    public NumberTester(String filename) {
        this.filename = filename;
    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }

    public void testFile() {
        try {
            Scanner sc = null;

            sc = new Scanner(new File(filename));

            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                String[] s = line.split(" ");
                switch (Integer.parseInt(s[0])) {
                    case 1:
                        if (oddTester.testNumber(Integer.parseInt(s[1]))) {
                            System.out.println("ODD");
                            break;
                        } else {
                            System.out.println("EVEN");
                        }
                        break;
                    case 2:
                        if (primeTester.testNumber(Integer.parseInt(s[1]))) {
                            System.out.println("PRIME");
                            break;
                        } else {
                            System.out.println("NO PRIME");
                        }
                        break;
                    case 3:
                        if (palindromeTester.testNumber(Integer.parseInt(s[1]))) {
                            System.out.println("PALINDROME");
                            break;
                        } else {
                            System.out.println("NO PALINDROME");
                        }
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}