package org.dalton.acsl4.rummy12;

import java.util.*;

//Nick Joseph

public class ACSL4NJ {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] split = input.split(", ");
		Hand[] hand = new Hand [5];
		for(int h = 0; h<hand.length; h++){
			hand[h] = new Hand();
			for(int i = 0; i<split.length; i++)
			{
				hand[h].addCard(new Card(split[i]));
			}
		}
		String[] inputs = new String[5];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = scanner.nextLine();
			String[] inputCards = inputs[i].split(", ");
			for(int j = 0; j<inputCards.length&&!hand[i].finished(); j++){
				hand[i].pick(new Card(inputCards[j]));
			}
			System.out.println(hand[i].submitPrint());
		}
	}
}
class Card
{
	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 *  Takes "3S" and makes "4S" or takes "JS" and makes "QS"
	 * @param k - the previous card
	 * @param i - the number you want to increase the number on the card by
	 */
	public Card(Card k, int i){
		number = k.getNumber()+i;
		suit=k.getSuit();
	}
	/**
	 * Copies a card
	 * @param k - the previous card
	 */
	public Card (Card k){
		number = k.getNumber();
		suit = k.getSuit();
	}
	/**
	 * Creates a card from the String representing it
	 * @param s the String in the format of "3S"
	 */
	public Card(String s){
		number = "0A23456789TJQK".indexOf(s.charAt(0));
		suit = 3-"SHCD".indexOf(s.charAt(1)); //check this
	}
	/**
	 * Compares two cards
	 * @param compare - another card to compare to
	 * @return - True if they have the same suit and number, False if they don't
	 */
	public boolean equals(Card compare){
		if(this.suit==compare.suit && this.number==compare.number) return true;
		else return false;
	}
	/**
	 * 
	 * @return A string representing how the card should be printed ("3S" or "JD")
	 */
	public String print(){
		return "0A23456789TJQK".charAt(number)+""+"SHCD".charAt(3-suit);
	}
	private int suit; //the suit of the card represented as an int
	private int number; //the number of the card
}
class Hand{
	/**
	 * Sorts the hand according to its number, and if numbers are the same according to suit
	 */
	public void sortByNum(){
		Collections.sort(cards, new Comparator<Card>(){
			public int compare(Card a, Card b){
				if(a.getNumber()==b.getNumber()) return b.getSuit()-a.getSuit();
				else return a.getNumber()-b.getNumber();
			}
		});
	}
	/**
	 * sorts by number in reverse order, then according to suit (The way non set or run cards need to be pritned)
	 */
	public void sortByNumRev(){
		Collections.sort(cards, new Comparator<Card>(){
			public int compare(Card a, Card b){
				if(a.getNumber()==b.getNumber()) return b.getSuit()-a.getSuit();
				else return b.getNumber()-a.getNumber();
			}
		});
	}
	public Hand(){} //enables the default constructor to work
	/**
	 * 
	 * @param - original the previous hand
	 * @param c - the card to be added to the previous hand
	 */
	public Hand(Hand original, Card c)	{
		for (int i = 0; i < original.cards.size(); i++) {
			this.cards.add(original.cards.get(i));	
		}
		this.cards.add(c);
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	/**
	 * 
	 * @param card = the card to be removed from the hand
	 */
	public void removeCard(Card card){
		for(int i = 0; i<cards.size(); i++)
		{
			if(card.equals(cards.get(i))) cards.remove(i);
		}
	}
	public void addCard(Card card){
		this.cards.add(card);
	}
	public boolean contains(Card card){
		for(int i = 0; i<cards.size(); i++)
		{
			if(cards.get(i).equals(card)) return true;
		}
		return false;
	}
	/**
	 * 
	 * @return The hand formatted as it is supposed to be for output
	 */
	public String submitPrint()
	{
		Hand four = new Hand(); //hand to hold any set or run of four
		Hand[] threeRun = new Hand[2]; //hand to hold any runs of three (there can be two so its an array)
		threeRun[0] = new Hand(); 
		threeRun[1] = new Hand();
		int runCounter = 0;
		Hand[] threeSet = new Hand[2]; //hand to hold any sets of three (there can be two so its an array)
		threeSet[0] = new Hand();
		threeSet[1] = new Hand();
		int setCounter = 0;
		boolean gotFour = !has4(); //is True if the four has been found or if there is no four
		for(int k = 0; k<15; k++){ //Sometimes when remove is used the counter skips so this just loops fifteen times to fix that
			for(int i = 0; i<cards.size(); i++){ //goes through each card in the hand
				Card c = cards.get(i);
				Card plusOne = new Card(c,1);
				Card plusTwo = new Card(c,2);
				Card plusThree = new Card(c,3);
				if(contains(plusOne)&&contains(plusTwo)&&contains(plusThree)) { //checks if it is the lowest of a 4-run
					gotFour = true;
					four.addCard(c);
					four.addCard(plusOne);
					four.addCard(plusTwo);
					four.addCard(plusThree);
					cards.remove(c); //c is a direct pointer so it can be removed
					removeCard(plusOne); //these are newCards so the removeCard function needs to be used
					removeCard(plusTwo);
					removeCard(plusThree);
					four.sortByNum(); //sorts hand
				}
				int counter = 0; //counts how many of the current cards number there are
				for(int j = 0; j<cards.size(); j++){ //goes through the hand counting
					if(cards.get(j).getNumber()==c.getNumber()) counter++; //if they match increments counter
				}
				if(counter==4){ //if there are 4 cards with this card's number in the hand
					for(int j = 0; j<cards.size(); j++){ //goes through hand to find the four cards
						Card q=cards.get(j);
						if(q.getNumber()==c.getNumber()){ //for each card that matches, adds it to the four hand and removes it from the leftovers
							four.addCard(q);
							cards.remove(q);
							j--;
						}
					}
					four.sortByNum(); //sorts the cards by number
				}
				if(counter==3){ //if the card is in a 3-set
					for(int j = 0; j<cards.size(); j++){ //goes through hand to find the three cards
						Card q=cards.get(j);
						if(q.getNumber()==c.getNumber()){
							threeSet[setCounter].addCard(q);
							cards.remove(q);
							j--;
						}
					}
					threeSet[setCounter].sortByNum(); //sorts hand
					setCounter++; //increments setCounter in case there is another set of 3
				}
				if(contains(plusOne)&&contains(plusTwo)&&!contains(plusThree)&&gotFour){ //checks if it is a sequence of three, and only if the four sequence has been found
					threeRun[runCounter].addCard(c);
					threeRun[runCounter].addCard(plusOne);
					threeRun[runCounter].addCard(plusTwo);
					cards.remove(c);
					removeCard(plusOne);
					removeCard(plusTwo);
					threeRun[runCounter].sortByNum();
					runCounter++;
				}
			}
		}
		this.sortByNumRev(); //sorts the remainder in reverse order
		int firstRun,secondRun,firstSet,secondSet; //orders the runs and sets of 3 if there are multiples
		if(threeRun[0].getCards().size()==0){
			firstRun = 1;
			secondRun = 0;
		}
		else if(threeRun[1].getCards().size()==0 || threeRun[0].getCards().get(0).getNumber()<threeRun[0].getCards().get(0).getNumber()){
			firstRun = 0;
			secondRun = 1;
		}
		else{
			firstRun = 1;
			secondRun = 0;
		}
		if(threeSet[0].getCards().size()==0){
			firstSet = 1;
			secondSet = 0;
		}
		else if(threeSet[1].getCards().size()==0 || threeSet[0].getCards().get(0).getNumber()<threeSet[0].getCards().get(0).getNumber()){
			firstSet = 0;
			secondSet = 1;
		}
		else{
			firstSet = 1;
			secondSet = 0;
		}
		String res=four.print(); 
		res+=threeRun[firstRun].print();
		res+=threeRun[secondRun].print();
		res+=threeSet[firstSet].print();
		res+=threeSet[secondSet].print();
		res+=this.print(); //past 6 lines just add together the hands in order
		return res.substring(0, res.length()-2); //loses the final comma
	}
	/**
	 * 
	 * @return A string representing all the cards in the hand, separated by comma space
	 */
	public String print(){
		String res = "";
		for(Card c : this.cards) res+=c.print()+", ";
		return res;
	}
	/**
	 * 
	 * @param input - the index of the card you are checking if it is in a sequence
	 * @return true if it is in one, false if it isn't
	 */
	public boolean inSequence(int input){
		int numCounter = 0;
		boolean twoLess = false;
		boolean oneLess = false;
		boolean oneMore = false;
		boolean twoMore = false;
		for(int i = 0; i<cards.size(); i++){
			if(cards.get(i).getNumber()==cards.get(input).getNumber()) numCounter++;
			if(cards.get(i).getSuit()==cards.get(input).getSuit() && cards.get(i).getNumber()==cards.get(input).getNumber()-2) twoLess = true; 
			if(cards.get(i).getSuit()==cards.get(input).getSuit() && cards.get(i).getNumber()==cards.get(input).getNumber()-1) oneLess = true; 
			if(cards.get(i).getSuit()==cards.get(input).getSuit() && cards.get(i).getNumber()==cards.get(input).getNumber()+1) oneMore = true;
			if(cards.get(i).getSuit()==cards.get(input).getSuit() && cards.get(i).getNumber()==cards.get(input).getNumber()+2) twoMore = true; 
		}
		if(numCounter>=3) return true;
		if(twoLess&&oneLess || oneLess&&oneMore || oneMore&&twoMore) return true;
		return false;
	}
	/**
	 * removes the lowest value card from a hand (meant to be used on an 8 card hand after adding)
	 */
	public void remove(){
		int minNumber = Integer.MAX_VALUE;
		int minSuit = Integer.MAX_VALUE;
		int minIndex = Integer.MAX_VALUE;
		for(int i = 0; i<cards.size(); i++)
		{
			if(!inSequence(i)){

				if(cards.get(i).getNumber()<minNumber)
				{
					minIndex = i;
					minNumber = cards.get(i).getNumber();
					minSuit =  cards.get(i).getSuit();
				}
				else if(cards.get(i).getNumber()==minNumber && cards.get(i).getSuit()<minSuit)
				{
					minIndex = i;
					minNumber = cards.get(i).getNumber();
					minSuit =  cards.get(i).getSuit();
				}
			}
		}
		cards.remove(minIndex);
	}
	/**
	 * 
	 * @param c - the card to be checked
	 * @return true if the card will extend or create a set or run, false if it won't
	 */
	public boolean extendOrCreate(Card c){
		int numCounter = 0;
		boolean threeLess = false;
		boolean twoLess = false;
		boolean oneLess = false;
		boolean oneMore = false;
		boolean twoMore = false;
		boolean threeMore = false;
		for(int i = 0; i<cards.size(); i++){
			if(cards.get(i).getNumber()==c.getNumber()) numCounter++;
			if(cards.get(i).getSuit()==c.getSuit() && cards.get(i).getNumber()==c.getNumber()-2) twoLess = true; 
			if(cards.get(i).getSuit()==c.getSuit() && cards.get(i).getNumber()==c.getNumber()-3) threeLess = true; 
			if(cards.get(i).getSuit()==c.getSuit() && cards.get(i).getNumber()==c.getNumber()-1) oneLess = true; 
			if(cards.get(i).getSuit()==c.getSuit() && cards.get(i).getNumber()==c.getNumber()+1) oneMore = true;
			if(cards.get(i).getSuit()==c.getSuit() && cards.get(i).getNumber()==c.getNumber()+2) twoMore = true; 
			if(cards.get(i).getSuit()==c.getSuit() && cards.get(i).getNumber()==c.getNumber()+3) threeMore = true;
		}
		if(numCounter>=2 && (!has4()||numCounter==2)) return true;
		if((twoLess&&oneLess || oneLess&&oneMore || oneMore&&twoMore) && (!has4() || !(threeLess&&twoLess&&oneLess ||twoLess&&oneLess&&oneMore||oneLess&&oneMore&&twoMore||oneMore&&twoMore&&threeMore))) return true;
		return false;
	}
	/**
	 * This picks a card and adds it to the hand, then removes the card it is supposed to remove
	 * @param input The card being picked
	 */
	public void pick(Card input){
		if(extendOrCreate(input))
		{
			//			this.print();
			//			System.out.println("printed a hand");
			cards.add(input);
			remove();
		}
	}
	/**
	 * 
	 * @return True if the game is over, False if it isn't
	 */
	public boolean finished(){
		for(int i = 0; i<cards.size(); i++){
			if(!inSequence(i)) return false;
		}
		return true;
	}
	/**
	 * 
	 * @return True if there is a set or sequence of 4, False if there isn't
	 */
	public boolean has4(){
		for(Card c : cards)		{
			int numCounter = 0;
			boolean threeLess = false;
			boolean twoLess = false;
			boolean oneLess = false;
			boolean oneMore = false;
			boolean twoMore = false;
			boolean threeMore = false;
			for(int i = 0; i<cards.size(); i++){
				if(cards.get(i).getNumber()==c.getNumber()) numCounter++;
				if(cards.get(i).getSuit()==c.getSuit() && cards.get(i).getNumber()==c.getNumber()-2) twoLess = true; 
				if(cards.get(i).getSuit()==c.getSuit() && cards.get(i).getNumber()==c.getNumber()-3) threeLess = true; 
				if(cards.get(i).getSuit()==c.getSuit() && cards.get(i).getNumber()==c.getNumber()-1) oneLess = true; 
				if(cards.get(i).getSuit()==c.getSuit() && cards.get(i).getNumber()==c.getNumber()+1) oneMore = true;
				if(cards.get(i).getSuit()==c.getSuit() && cards.get(i).getNumber()==c.getNumber()+2) twoMore = true; 
				if(cards.get(i).getSuit()==c.getSuit() && cards.get(i).getNumber()==c.getNumber()+3) threeMore = true; 
			}
			if(numCounter>=4) return true;
			if(threeLess&&twoLess&&oneLess ||twoLess&&oneLess&&oneMore||oneLess&&oneMore&&twoMore||oneMore&&twoMore&&threeMore) return true;
		}
		return false;
	}
	private ArrayList<Card> cards = new ArrayList<Card>(); //the ArrayList of the cards in the hand
}