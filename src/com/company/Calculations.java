package com.company;

public class Calculations {
    private String firstNumber = "";
    private String secondNumber = "";
    private double result = 0;
    private String operation = "";
    private String rowString = "";

    public boolean resset() {

        firstNumber = "";
        secondNumber = "";
        operation = "";

        System.out.println("operation \"C\" - all data deleted.");
        return true;
    }

    public void addDigit(String symbolGenerator) {


        if (((symbolGenerator.charAt(0) >= '0' && symbolGenerator.charAt(0) <= '9')
                || symbolGenerator.charAt(0) == '.'
                || symbolGenerator.charAt(0) == '-') && operation == "") {

            if (symbolGenerator.charAt(0) == '.') {
                for (int i = 0; i < firstNumber.length(); i++) {
                    if (firstNumber.substring(i, i + 1).equals(".")) {
                        firstNumber = firstNumber;
                        return;
                    }
                }
            }

            if (symbolGenerator.charAt(0) == '-') {
                if (firstNumber.equals("-")) {
                    firstNumber = firstNumber;
                    return;
                } else if (!(firstNumber.equals("") || firstNumber.equals("-"))) {
                    operation = symbolGenerator;
                    System.out.println("Choised operation: " + operation);
                    return;
                }
            }

            firstNumber = firstNumber + symbolGenerator;
            symbolGenerator = "";
            System.out.println("first: " + firstNumber);

        } else if (firstNumber != "" && firstNumber != "." && firstNumber != "-" && secondNumber == "" && operation == "") {
            operation = symbolGenerator;
            System.out.println("Choised operation: " + operation);

        } else if (((symbolGenerator.charAt(0) >= '0' && symbolGenerator.charAt(0) <= '9')
                || symbolGenerator.charAt(0) == '.'
                || symbolGenerator.charAt(0) == '-') && operation != "" && symbolGenerator != "=") {


            if (symbolGenerator.charAt(0) == '.') {
                for (int i = 0; i < secondNumber.length(); i++) {
                    if (secondNumber.substring(i, i + 1).equals(".")) {
                        secondNumber = secondNumber;
                        return;
                    }
                }
            }

            if (symbolGenerator.charAt(0) == '-') {
                if (secondNumber.equals("-")) {
                    secondNumber = firstNumber;
                    return;
                }
            }


            secondNumber = secondNumber + symbolGenerator;
            symbolGenerator = "";
            System.out.println("second: " + secondNumber);

        }
    }

    public void equalsOperation() {

        if (secondNumber != "") {
            if (operation.equals("+")) {
                result = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
                System.out.println("your result:" + firstNumber + operation + secondNumber + " = " + result);
            }
            if (operation.equals("-")) {
                result = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
                System.out.println("your result:" + firstNumber + operation + secondNumber + " = " + result);
            }
            if (operation.equals("*")) {
                result = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
                System.out.println("your result:" + firstNumber + operation + secondNumber + " = " + result);
            }
            if (operation.equals("/")) {
                if (Double.parseDouble(secondNumber) == 0) {
                    System.out.println("sorry. Divide by 0 is not posible");
                } else {
                    result = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
                    System.out.println("your result:" + firstNumber + operation + secondNumber + " = " + result);
                }
            }
            firstNumber = "";
            secondNumber = "";
            operation = "";

            System.out.println(" you can make new operation.");
        }
    }

    public String getLabel() {

        rowString = firstNumber + operation + secondNumber;
        return rowString;
    }

    public double getResult() {
        return result;
    }
}
