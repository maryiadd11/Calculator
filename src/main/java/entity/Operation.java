package entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class Operation {

    private long id;
    private double num1;
    private double num2;
    private String type;
    private double result;
    private long userId;

    public Operation(String num1, String num2, String type, double result, long userId) {
        this.num1 = Double.parseDouble(num1);
        this.num2 = Double.parseDouble(num2);
        this.type = type;
        this.result = result;
        this.userId = userId;
    }

    public Operation(double num1, double num2, String type, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
        this.result = result;
    }

    public Operation(long id, double num1, double num2, String type, double result) {
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
        this.result = result;
    }

    public Operation(long id, String num1, String num2, String type, double result) {
        this.id = id;
        this.num1 = Double.parseDouble(num1);
        this.num2 = Double.parseDouble(num2);
        this.type = type;
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", type='" + type + '\'' +
                ", result=" + result +
                ", userId=" + userId +
                '}';
    }
}
