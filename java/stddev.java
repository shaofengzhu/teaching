import java.util.Scanner;

public class stddev {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        int count = 0;
        while(scanner.hasNextInt())
        {
            sum = sum + scanner.nextInt();
            count = count + 1;
        }

        System.out.println("sum=" + sum);
        System.out.println("avg=" + sum / count);
    }
}