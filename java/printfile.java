import java.io.*;
class printfile{
    public static void main(String[] args) throws IOException
    {
        FileReader reader = new FileReader("ride.java");
        
        BufferedReader buffer = new BufferedReader(reader);
        
        String line;

        while (    (line=buffer.readLine())    != null)
        {
            System.out.println(line);
            System.out.println(line);
        }

        buffer.close();
    }
}