package mockito;

// Calculator.java
public class Calculator {
    private MathUtil mathUtil;

    public Calculator(MathUtil mathUtil) {
        this.mathUtil = mathUtil;
    }

    public int addNumbers(int a, int b) {
        return mathUtil.add(a, b);
    }

    public int subtractNumbers(int a, int b) {
        return mathUtil.subtract(a, b);
    }
}

