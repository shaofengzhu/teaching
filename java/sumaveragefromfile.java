import java.util.*;
import java.io.*;

class sumaveragefromfile{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("sumaveragefromfile.in"));
        
        String line;
        line = reader.readLine();

        int count = Integer.parseInt(line);
        double sum = 0.0;
        for (int i = 0; i < count; i++)
        {
            line = reader.readLine();
            double price = Double.parseDouble(line);
            sum = sum + price;
        }

        System.out.println(sum);
        reader.close();
    }
}