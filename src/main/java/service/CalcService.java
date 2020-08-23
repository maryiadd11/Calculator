package service;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CalcService {

    String num1;
    String num2;
    String type;

    public double run() {
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

    private double sum (double a, double b) {
        return a+b;
    }

    private double minus (double a, double b) {
        return a-b;
    }

    private double multiply (double a, double b) {
        return a*b;
    }

    private double divide (double a, double b) {
        return a/b;
    }
}
