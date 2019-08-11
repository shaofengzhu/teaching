public class sumaverage{
    public static void main(String[] args) {
        double[] data = {1.1, 1.2, 1.3};

        double sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum = sum + data[i];
        }

        System.out.println("Sum=" + sum);

        double average = sum / data.length;
        System.out.println("Average=" + average);
    }
}