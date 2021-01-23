## Old
We used to write code like
```java
public class swap {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("swap.in"));
        PrintWriter out = new PrintWriter(new FileWriter("swap.out"));


        StringTokenizer st = new StringTokenizer(in.readLine());
        out.println(10;)

        in.close();
        out.close();
    }    
}

```

To run it, we use
```console
java swap
```
and we could see the results in the `swap.out` file.


## New
The new rule may require to read from `System.in` and write to `System.out`. We just need to change our code to
```java
public class swap {
    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new FileReader("swap.in"));
        // PrintWriter out = new PrintWriter(new FileWriter("swap.out"));

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        out.println(10;)

        in.close();
        out.close();
    }    
}
```

Please note that it will be very tedius to type in all of the input. The best way to run the code is to put all of the input into the `swap.in` file, then use append `<swap.in` in the command line. The key is the character `<` symbol to use the file for System.in
```console
java swap <swap.in
```

and we will see the output from command line.

## Best practice
When we need to debug the code, it's still better to change to the old way. Before you submit, please change to the new way by comment out and un-comment out the lines.
