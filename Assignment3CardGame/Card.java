/**

 * 
 */


package Assignment3CardGame;
	
	

/**
 * @author 
 *
 */
public class Card implements Comparable<Card> {

	private final Rank RANK;
	private final Suit SUIT;
	
	
	/**
	 * 
	 */
	
	
	
	
	public Card(Rank rank, Suit suit) {
		// TODO Auto-generated constructor stub
		this.RANK = rank;
		this.SUIT = suit;
	}
	
	public int getRank() {
		return this.RANK.getPoints();
	}
	
	public Suit getSuit() {
		return this.SUIT;
	}
	/*
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Card o) {
		if (o.RANK.getPoints() > this.RANK.getPoints()) {
			return 1;
		} else if (o.RANK.getPoints() == this.RANK.getPoints()) {
			switch (o.SUIT.compareTo(this.SUIT)) {
			case 1:
				return 1;
			case 0:
				return 0;
			case -1:
				return -1;
			}
		}return -1;
	}
	public String toString() {
		String rankName = RANK.toString();
		String suitGraphic = SUIT.getDisplayName();
		
		return rankName + " of " + suitGraphic;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Card c = new Card(Rank.FOUR,Suit.SPADES);
		System.out.println(c.toString());
		Card b = new Card(Rank.ACE,Suit.CLUBS);
		System.out.println(b.toString());
		
	}

}
