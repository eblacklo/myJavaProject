package edu.alamo.java;

import java.util.Random;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author JavaUser
 * 
 * 1) Implement a Deck class with an array of 52 unique PlayCard instances.
 * 2) Write a PlayCard[] deal(int numCardsInHand) method taking random cards from Deck.
 *    Note: make sure you don't return same card twice
 * 3) Write a main to test.
 */

public class Deck extends PlayingCard{
	
	PlayingCard[] deck = new PlayingCard[52];
	PlayingCard[] hand = new PlayingCard[52];
	//PlayCard[] deal(int, numcard);
	
	//public PlayCard[] getArray(){
	
	// Constructor to create deck array
	public Deck(){	
		int i = 0;
		//int y = 0;
		for(String s:PlayingCard.suits){
			//System.out.println(s);
			//i++;
			for (String r:PlayingCard.ranks){
				//System.out.println(r);
				
				// This is actually creating array of PlayCard objects.
				// example value: '2 of Spades'..... all 52 matching combinations.
				this.deck[i] = new PlayingCard(s,r);
				i++;
			}
		}
		
		//for (i=0;i<52;i++){
			//deck[] = i;
			// how to append i to array?
		//}
		
		System.out.println("These are the values of deck. There are total of 52 values.");
		for (int d=0; d< this.deck.length; d++){
			System.out.println(this.deck[d]);
		}
		System.out.println("   ");
		//return deck;
		
		
		}
	
   public int[] randomNum(int arrayLength){
	   int[] randomNum = new int[arrayLength];
	   
	   for (int i=0; i<arrayLength; i++){
		   Random rand = new Random();
		   randomNum[i] = rand.nextInt(arrayLength);
	   }
	   
	   return randomNum;
   }
   
   public PlayingCard[] hand(int[] randumNumArr){
	   
	   //PlayingCard[] hand = new PlayingCard[randumNumArr.length];
	   
	   for (int i=0; i<randumNumArr.length; i++){
		   this.hand[i] = this.deck[randumNumArr[i]];
	   }	   
	   return this.hand;
   }
   
   public PlayingCard[] deal(int numcard){
	   /* TODO create a new PlayingCard[] hand of the requested size 
	   +		 * TODO create a source of random numbers using Random class (read API)
	   +		 * TODO loop over hand array until full: 
	   +		 *      generate a new random number to select a card from deck array
	   +		 *      put the deck[index] card into a variable called candidate
	   +		 *      compare candidate to each card in hand -- if no match, add to hand
	   +		 *      if match, get another candidate and retry
	   +		 */
	   
	   /* http://stackoverflow.com/questions/10255411/how-to-increase-an-arrays-length
	    * Arrays in Java are of fixed size that is specified when they are declared. 
	    * To increase the size of the array you have to create a new array with a larger size 
	    * and copy all of the old values into the new array.
	    */
	   
	   // Good. this returns the first index value where null starts.
	   // use this index in order to assign new value to hand array.
	   int nullLoc = Arrays.asList(this.hand).indexOf(null);
	   System.out.println("The first null location index is: "+nullLoc);
	   // Arrays.asList creates the list of hand. Then contains check the existence of value.
	   if (!Arrays.asList(this.hand).contains(this.deck[numcard])){
		   System.out.println(this.deck[numcard]+" is going to be added to hand");
		   this.hand[(nullLoc)] = this.deck[numcard];
		   // this does not work since array in Java is a fixed when it is declared.
		   //this.hand[(this.hand.length+1)] = this.deck[numcard];
		   
	   }
	   else{
		   System.out.println(this.deck[numcard]+" is already exist in hand.");
	   }
	   
	   return this.hand;
  }
   
   public static void main(String[] args){
	   
	   /*
	   +		 * TODO create an instance of DeckTemplate
	   +		 * TODO print the entire deck
	   +		 * TODO test the deal() method a few times and print the hands
	   +		 */
	   
	   // this.deck is created through constructor.
	   Deck d = new Deck();
	   
	   // create collection of random numbers.
	   // This is the length of hand and I will make upto 45.
	   int[] randNum = d.randomNum(45);
	   System.out.println("These are the collection of random numbers");
	   for (int i=0; i<randNum.length; i++){
		   System.out.println(randNum[i]);
	   }
	   System.out.println("   ");
	   
	   // create hand upto index 52 since I need extra space to add new values
	   // after comparing the value against deck.
	   d.hand = d.hand(randNum);
	   System.out.println("These are the values of hand. There are 45 values and 7 nulls.");
	   for (int i=0; i<d.hand.length; i++){
		   System.out.println(d.hand[i]);
	   }
	   System.out.println("   ");
	   
	   // create collection of random numbers again here.
	   // this is the int value passed to deal method.
	   // This will go through deck. therefore I need random numbers of upto 52.
	   int[] randNum2 = d.randomNum(52);
	   
	   // test deal method using upto two number of random number.
	   for (int i=0; i<2; i++){
		   System.out.println("The random number value is: "+randNum2[i]);
		   d.hand = d.deal(randNum2[i]);
	   }
	   
	   /*
	    * The random number value is: 25
		* The first null location index is: 45
		* K of Spades is going to be added to hand
		* 
		* The random number value is: 32
		* The first null location index is: 46
		* 7 of Diamonds is going to be added to hand
		* 
		* New hand values after deal method -- looks good! 'K of Spades' and '7 of Diamonds' are added to hand!
	    */
	   
	   
	   // And now check if new value is really added ok to hand.
	   System.out.println("New hand values after deal method");
	   for (int i=0; i<d.hand.length; i++){
		   System.out.println(d.hand[i]);
	   }
	   
   }
	
}
