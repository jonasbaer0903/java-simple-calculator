package com.kaufland.hello;

import java.util.Scanner;

public class CommandLine {

    public static void main(String[] args) {
        String eingabe1;
        String eingabe2;
        String eingabeRechenart;

        eingabe1 = readLine("Gib Zahl 1 ein: ");
        eingabe2 = readLine("Gib Zahl 2 ein: ");
        eingabeRechenart = readLine("Gib Rechenart ein: ");

        double zahl1 = Double.parseDouble(eingabe1);
        double zahl2 = Double.parseDouble(eingabe2);

        double result = 0;

        if (eingabeRechenart.equals("+")) {
            result = add(zahl1, zahl2);
        } else if (eingabeRechenart.equals("-")) {
            result = subtract(zahl1, zahl2);
        } else if (eingabeRechenart.equals("/")) {
            result = devide(zahl1, zahl2);
        } else {
            result = multiply(zahl1, zahl2);
        }

        String resultk = Double.toString(result);

        System.err.println(resultk);
        System.err.println(resultk.replaceAll("\\.",","));
        System.out.println(resultk);
    }


    private static double add(double zahl1, double zahl2) {
        return zahl1 + zahl2;
    }

    private static double subtract(double zahl1, double zahl2) {
        return zahl1 - zahl2;
    }

    private static double devide(double zahl1, double zahl2) {
        return zahl1 / zahl2;
    }

    private static double multiply(double zahl1, double zahl2) {
        return zahl1 * zahl2;
    }

    private static String readLine(String printText) {
        Scanner reader = new Scanner(System.in);
        System.out.print(printText);
        String line = reader.next();
        return line;
    }
}
