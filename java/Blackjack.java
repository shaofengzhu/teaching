class Foo {
}
public class Blackjack {
	public static void main(String[] args) {
		System.out.println(Suit.HEARTS);
		Suit[] suits = Suit.values();
		for (int i = 0; i < suits.length; i++) {
			System.out.println(suits[i]);
		}
		
		Foo foo = new Foo();
		System.out.println(foo);
	}
}
