import java.util.Scanner;
public class TestScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        while (scanner.hasNext()) {
            String s = scanner.next();
            count++;
            System.out.println(s);
        }

        System.out.println(count);
    }
}