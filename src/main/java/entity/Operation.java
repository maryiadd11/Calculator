package entity;

public class Operation {
    private static int incId = 1;
    private int id = incId++;

    String num1;
    String num2;
    String type;
    Double result;

    public Operation(String num1, String num2, String type, Double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
        this.result = result;
    }

    public Operation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", num1='" + num1 + '\'' +
                ", num2='" + num2 + '\'' +
                ", type='" + type + '\'' +
                ", result=" + result +
                '}';
    }
}
