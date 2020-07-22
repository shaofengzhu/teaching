# Java Questions

## Links
https://www.w3resource.com/java-exercises/basic/index.php

## Check string in a sentence
There is a sentence
```text
I read a book named "Red Bird" and it's interesting
```
Check whether it contains
```text
bird
```

## Print 1 to 20
Print number from 1 to 20 and every line is a number
```text
1
2
3
...
20
```

## Print 21 to 40
Print number from 21 to 40 and every line is a number
```text
21
22
23
24
...
40
```

## Print 21 to 40, and have separator after 25, 30, 35, 40
Print number from 21 to 40 and every line is a number
```text
21
22
23
24
25
-----
26
...
40
----
```

## Find sum of integer from 1 to 100

## Find average of integer from 1 to 100

## Find max integer in an array
If there is an array
```java
int[] data = {23, 12, 67, 5, 9};
```
Find the max number in it

## Find min integer in an array
If there is an array
```java
int[] data = {23, 12, 67, 5, 9};
```
Find the min number in it

## sin(x) table
XinXin will go to a field trip with her classmates, which is to figure out the width of a river. They are going to use Law of Sin, which is a/sin(A) = b/sin(B) = c/sin(C). We could see that they need to calculate sin(x). But a lot of XinXin's classmates do not have scientific calculators. XinXin asks KaiKai for help and KaiKai said that she will print a table for XinXin. The table will contains the value of sin(x) for all x from 0 to 90 degree.

| x degree | sin(x) |
| -------- | ------ |
| 1        | 0.01745240643728351 |
| 2        | 0.03489949670250097 |
| 3        | 0.05233595624294383 |
| 4        | 0.0697564737441253 |
|...       | ... |
| 90       | 1.0 |

## sin(x) derivative table
XinXin noticed that Caroline is learning Calculus and she also want to know the derivative. KaiKai told XinXin that she could provide XinXin a derivative table for sin(x) for all of x from 0 to 90 degree. Once XinXin has the table, XinXin could look up the derivative values for that table.

## sumaverage
Our friend bought one Amazon stock at the beginning of each month. In January, she bought one stock at the price 1501.1. In Feburary, she bought one stock at the price 1536.5 and so on. The following are the prices of the stock for the past a few months.
```java
double[] prices = {1501.1, 1536.5, 1420.6, 1634.9, 1700.8};
```
She heard that KaiKai is learning Java and she want to ask KaiKai to find the the total money she spent and the average price.

## multitable
Aunt Vivian knows that XinXin is good at math multiply and she asked how XinXin is good at it. XinXin told her that she once had a multiply table and she memorized it. Vivian also want to get such multitable for DianDian. As XinXin's dad is very busy, so Vivian asked KaiKai to help her to generate such multiply table.
```text
1 x 1 = 1
1 x 2 = 2   2 x 2 = 4
1 x 3 = 3   2 x 3 = 6   3 x 3 = 9
1 x 4 = 4   2 x 4 = 8   3 x 4 = 12  4 x 4 = 16
...
```

## sumaveragefromfile
Our friend bought one Amazon stock at the beginning of each month. In January, she bought one stock at the price 1501.1. In Feburary, she bought one stock at the price 1536.5 and so on. The following are the prices of the stock for the past a few months. The price are stored in a text file
```text
5
1501.1
1536.5
1420.6
1634.9
1700.8
```
where the first line is how many months she bought the stock and the rest lines are the price for each months.

She heard that KaiKai is learning Java and she want to ask KaiKai to find the the total money she spent and the average price.

To read a file, you could use some code like
```java
BufferedReader reader = new BufferedReader(new FileReader("sumaveragefromfile.in"));
        
String line;
line = reader.readLine();
```
To convert a string to integer, you could use some code like
```java
int intValue = Integer.parseInt(line);
```
To convert a string to double, you could use some code like
```java
double doubleValue = Double.parseDouble(line);
```

## print integer
We usually use `System.out.println(intValue)` to print an integer. A hacker hacked the system and the `System.out.println(intValue)` does not work as expected anymore. However, the `System.out.print(charValue)` still works. We are panic and we want to get your help so that we could print out an integer correctly. We count on you to stop the hacker. Would you please write a function that could print out integer value.

## findindex
A string is a sequence of characters. For example, "Hello, World". We want to find the index of 'W' in the string.

## sin(x) integral
Computer is not as smart as human and a computer only knows integral by sum. Let's use a computer way to calculate the integral of sin(x). We should check how accurate a computer could calcuate integral. Once we figure the integral of sin(x), we could calculate integral of sqrt(sin(x)).


