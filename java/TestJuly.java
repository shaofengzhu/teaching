public class TestJuly {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		int sum = a + b;
		int sub = a - b;
		int mul = a * b;
		int div = a / b;
		
		System.out.println(a + "+" + b + "=" + sum);
		System.out.println(a + "-" + b + "=" + sub);
		
	}
}
