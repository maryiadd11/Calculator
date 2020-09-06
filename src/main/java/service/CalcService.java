package service;

public class CalcService {

    public static double run (String num1, String num2, String type) {
        double result = 0;
        switch (type) {
            case "sum":
                result = sum(Double.parseDouble(num1), Double.parseDouble(num2));
                break;
            case "minus":
                result = minus(Double.parseDouble(num1), Double.parseDouble(num2));
                break;
            case "multiply":
                result = multiply(Double.parseDouble(num1), Double.parseDouble(num2));
                break;
            case "divide":
                result = divide(Double.parseDouble(num1), Double.parseDouble(num2));
                break;
        }
        return result;
    }

    private static double sum(double a, double b) {
        return a+b;
    }

    private static double minus (double a, double b) {
        return a-b;
    }

    private static double multiply (double a, double b) {
        return a*b;
    }

    private static double divide (double a, double b) {
        return a/b;
    }
}
