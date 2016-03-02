package edu.alamo.java;

import java.util.Random;

public class PlayingCard implements PlayingCardIF {
	
	final static String[] suits = {"Hearts", "Spades", 
		                     "Diamonds", "Clubs"};
	final static String[] ranks = {"Ace", "2", "3", "4", "5",
	                         "6","7", "8", "9", "10",
	                         "J","Q", "K"
	                        };
	
    private String suit;
    private String rank;
    
    public PlayingCard() {
    // no rank or suit given so randomize a card
	Random rand = new Random();
	this.suit = suits[rand.nextInt(suits.length)];  
	this.rank = ranks[rand.nextInt(ranks.length)];
	
	//System.out.println(this.suit);
    }
    
    public PlayingCard(String suit, String rank) {
    	this.suit = suit;
    	this.rank = rank;
    }
    
    public static void main(String[] args) {
    	PlayingCardIF card1 = new PlayingCard();  // gives a random PlayingCard
    	System.out.println(card1);
    	PlayingCardIF card2 = new PlayingCard("Spades", "Ace");  // gives a random PlayingCard
    	System.out.println(card2);
    }

    /* (non-Javadoc)
	 * @see edu.acc.java.PlayingCardIF#toString()
	 */
	@Override
    public String toString() {
    	return this.rank + " of " + this.suit;
    }

	/* (non-Javadoc)
	 * @see edu.acc.java.PlayingCardIF#getSuit()
	 */
	@Override
	public String getSuit() {
		return suit;
	}

	/* (non-Javadoc)
	 * @see edu.acc.java.PlayingCardIF#setSuit(java.lang.String)
	 */
	@Override
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/* (non-Javadoc)
	 * @see edu.acc.java.PlayingCardIF#getRank()
	 */
	@Override
	public String getRank() {
		return rank;
	}

	/* (non-Javadoc)
	 * @see edu.acc.java.PlayingCardIF#setRank(java.lang.String)
	 */
	@Override
	public void setRank(String rank) {
		this.rank = rank;
	}
    
    
}