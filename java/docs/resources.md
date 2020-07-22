# Resources

1. https://introcs.cs.princeton.edu/java/home/

# Data Types

data type | number of bytes
--- | ---
byte | 1
char | 2
short | 2
int | 4
long | 8


If we have 
```java
int n = 73;
short s = n;
char ch = 73;
```

# Scanner
```java
import java.util.Scanner;
public class TestScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = a + b;
        System.out.println(c);
    }
}
```

```java
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
```
