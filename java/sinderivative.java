import java.util.*;
import java.io.*;

class sinderivative {
    public static void main(String[] args) {

        for (int i = 0; i <= 90; i++) {
            double degree = i;
            double x = i * Math.PI / 180.0;
            double result = derivative(x);
            System.out.print(degree);
            System.out.print("   ");
            System.out.println(result);
        }
    }

    private static double f(double x) {
        return Math.sin(x);
    }

    private static double derivative(double x) {
        double deltaX = 0.000001;
        double deltaF = f(x + deltaX) - f(x);
        return deltaF / deltaX;
    }
}