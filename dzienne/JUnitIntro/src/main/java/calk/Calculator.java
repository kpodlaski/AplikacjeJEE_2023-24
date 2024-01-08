package calk;

public class Calculator {

    public double multiply(double a, double b,
            int significanceLevel){
        double factor = Math.pow(10,
                significanceLevel+3);
        double a1 = ((int) (a*factor))/ factor;
        double b1 = ((int)(b*factor))/ factor;
        return a1*b1;
    }

    public double division(double a, double b){
        if (Math.abs(b)<.000001)
            throw new ArithmeticException(
                    "Division by zero");
        if (a<0){
            return a/b;
        }
        return a/b;
    }

    public double exp(double x, double delta){
        double result = 1;
        double a = 1;
        double b = 1;
        for (int iter = 1; iter<33; iter++) {
            a *= x;
            b *= iter;
            result += a / b;
        }
        return result;
    }
}
