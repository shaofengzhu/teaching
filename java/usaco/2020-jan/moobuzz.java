import java.io.*;
import java.util.*;
public class moobuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("moobuzz.in"));
        PrintWriter output = new PrintWriter(new FileWriter("moobuzz.out"));
        StringTokenizer st = new StringTokenizer(input.readLine());
        long numberPosition = Long.parseLong(st.nextToken());

        int[] numbers = new int[15];
        int countIn15 = 0;
        for (int i = 1; i <= 15; i++) {
            boolean sayMoo = i % 3 == 0 || i % 5 == 0 || i % 15 == 0;
            if (!sayMoo) {
                countIn15++;
            }
            numbers[i -1] = countIn15;
        }

        long result = (numberPosition / countIn15) * 15;
        long remainder = numberPosition % countIn15;
        if (remainder == 0) {
            result -= 1;
        }
        else {
            for (int i = 0; i < numbers.length; i++) {
                if (remainder == numbers[i]) {
                    result += i + 1;
                    break;
                }
            }
        }

        output.println(result);

        input.close();
        output.close();
    }
}
