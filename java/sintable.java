import java.util.*;
import java.io.*;

class sintable {
    public static void main(String[] args) {

        for (int i = 0; i <= 90; i++) {
            double degree = i;
            double result = f(degree);
            System.out.print(degree);
            System.out.print("   ");
            System.out.println(result);
        }
    }

    private static double f(double x) {
        return Math.sin(x / 180.0 * Math.PI);
    }
}