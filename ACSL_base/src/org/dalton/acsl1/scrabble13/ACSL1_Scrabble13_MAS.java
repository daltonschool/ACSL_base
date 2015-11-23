package org.dalton.acsl1.scrabble13;
import java.util.Scanner;

/**
 * 
 * @MichaelAgueroSinclair
 * Dalton School
 * 3305
 *
 */

public class ACSL1_Scrabble13_MAS {

	
	
	public static int score(int valOne, int valTwo, int valThree, int valFour, int spotOne, String direction)
	{
		int score = 0;
		int spotTwo;
		int spotThree;
		int spotFour;
		
		//find spot positions based on direction
		if(direction.equals("H")) {
			spotTwo = spotOne + 1;
			spotThree = spotOne + 2;
			spotFour = spotOne + 3;
		}
		else {
			spotTwo = spotOne + 10;
			spotThree = spotOne + 20;
			spotFour = spotOne + 30;
		}
		
		if(spotOne == 3 || spotOne == 9 || spotOne == 15 || spotOne == 21 || spotOne == 27 || spotOne == 33 || spotOne == 39)
		{
			valOne = valOne*2;
		}
		if(spotOne == 5 || spotOne == 10 || spotOne == 20 || spotOne == 25 || spotOne == 30 || spotOne == 35 || spotOne == 40)
		{
			valOne = valOne*3;
		}
		if(spotTwo == 3 || spotTwo == 9 || spotTwo == 15 || spotTwo == 21 || spotTwo == 27 || spotTwo == 33 || spotTwo == 39)
		{
			valTwo = valTwo*2;
		}
		if(spotTwo == 5 || spotTwo == 10 || spotTwo == 20 || spotTwo == 25 || spotTwo == 30 || spotTwo == 35 || spotTwo == 40)
		{
			valTwo = valTwo*3;
		}
		if(spotThree == 3 || spotThree == 9 || spotThree == 15 || spotThree == 21 || spotThree == 27 || spotThree == 33 || spotThree == 39)
		{
			valThree = valThree*2;
		}
		if(spotThree == 5 || spotThree == 10 || spotThree == 20 || spotThree == 25 || spotThree == 30 || spotThree == 35 || spotThree == 40)
		{
			valThree = valThree*3;
		}
		if(spotFour == 3 || spotFour == 9 || spotFour == 15 || spotFour == 21 || spotFour == 27 || spotFour == 33 || spotFour == 39)
		{
			valFour = valFour*2;
		}
		if(spotFour == 5 || spotFour == 10 || spotFour == 20 || spotFour == 25 || spotFour == 30 || spotFour == 35 || spotFour == 40)
		{
			valFour = valFour*3;
		}
		
		//add up
		score = valOne + valTwo + valThree + valFour;
		
		//check for DW
		if(spotOne == 7 || spotOne == 14 || spotOne == 28)
		{
			score = score*2;
		}
		if(spotTwo == 7 || spotTwo == 14 || spotTwo == 28)
		{
			score = score*2;
		}
		if(spotThree == 7 || spotThree == 14 || spotThree == 28)
		{
			score = score*2;
		}
		if(spotFour == 7 || spotFour == 14 || spotFour == 28)
		{
			score = score*2;
		}
		
		//check for TW
		if(spotOne == 8 || spotOne == 16 || spotOne == 24 || spotOne == 32)
		{
			score = score*3;
		}
		if(spotTwo == 8 || spotTwo == 16 || spotTwo == 24 || spotTwo == 32)
		{
			score = score*3;
		}
		if(spotThree == 8 || spotThree == 16 || spotThree == 24 || spotThree == 32)
		{
			score = score*3;
		}
		if(spotFour == 8 || spotFour == 16 || spotFour == 24 || spotFour == 32)
		{
			score = score*3;
		}
		return score;
	}
	

	public static int letter(char[] word, int position)
	{
		int letter = 0;
		
		if(word[position] == 'A'|| word[position] == 'E') {
			letter = 1;
		}
		if(word[position] == 'D'|| word[position] == 'R') {
			letter = 2;
		}
		if(word[position] == 'B'|| word[position] == 'M') {
			letter = 3;
		}
		if(word[position] == 'V'|| word[position] == 'Y') {
			letter = 4;
		}
		if(word[position] == 'J'|| word[position] == 'X') {
			letter = 8;
		}
		
		return letter;
	}
	
	public static int greatest(int value1, int value2, int value3)
	{
		int greatest = 0;
		
		if(value1 >= value2 && value1 >= value3)
		{
			greatest = value1;

		}
		if(value2 >= value1 && value2 >= value3)
		{
			greatest = value2;
		
		}
		if (value3 >= value1 && value3 >= value2)
		{
			greatest = value3;
	
		}
		return greatest;
	}
	
	
	public static void main(String args[])
	{
		
		Scanner keyboard = new Scanner(System.in);

		//create char array with word
		String wordString = keyboard.nextLine();
		wordString = wordString.replaceAll("\\s*,\\s*","");
		char[] word = new char[4];
		for (int i = 0; i < word.length; i++) {
			word[i] = wordString.charAt(i);
		}
		
		//find initial value of each letter
		int letOne = letter(word, 0);
		int letTwo = letter(word, 1);
		int letThree = letter(word, 2);
		int letFour = letter(word, 3);
		
		//first input
	    String[] t = keyboard.nextLine().split("\\s*,\\s*");
	    int first = Integer.parseInt(t[0]);
	    int second = Integer.parseInt(t[2]);
	    int third = Integer.parseInt(t[4]);
	   
	    int value1 = score(letOne,letTwo,letThree,letFour,first,t[1]);
	    int value2 = score(letOne,letTwo,letThree,letFour,second,t[3]);
	    int value3 = score(letOne,letTwo,letThree,letFour,third,t[5]);
	    
	    System.out.println(greatest(value1,value2,value3));
	    
	    //second input
	    String[] b = keyboard.nextLine().split("\\s*,\\s*");
	    int firstb = Integer.parseInt(b[0]);
	    int secondb = Integer.parseInt(b[2]);
	    int thirdb = Integer.parseInt(b[4]);
	   
	    int value1b = score(letOne,letTwo,letThree,letFour,firstb,b[1]);
	    int value2b = score(letOne,letTwo,letThree,letFour,secondb,b[3]);
	    int value3b = score(letOne,letTwo,letThree,letFour,thirdb,b[5]);
	    
	    System.out.println(greatest(value1b,value2b,value3b));
	    
	    //third input
	    String[] c = keyboard.nextLine().split("\\s*,\\s*");
	    int firstc = Integer.parseInt(c[0]);
	    int secondc = Integer.parseInt(c[2]);
	    int thirdc = Integer.parseInt(c[4]);
	   
	    int value1c = score(letOne,letTwo,letThree,letFour,firstc,c[1]);
	    int value2c = score(letOne,letTwo,letThree,letFour,secondc,c[3]);
	    int value3c = score(letOne,letTwo,letThree,letFour,thirdc,c[5]);
	    
	    System.out.println(greatest(value1c,value2c,value3c));
	    
	    //fourth input
	    String[] d = keyboard.nextLine().split("\\s*,\\s*");
	    int firstd = Integer.parseInt(d[0]);
	    int secondd = Integer.parseInt(d[2]);
	    int thirdd = Integer.parseInt(d[4]);
	   
	    int value1d = score(letOne,letTwo,letThree,letFour,firstd,d[1]);
	    int value2d = score(letOne,letTwo,letThree,letFour,secondd,d[3]);
	    int value3d = score(letOne,letTwo,letThree,letFour,thirdd,d[5]);
	    
	    System.out.println(greatest(value1d,value2d,value3d));
	    
	    //fifth input
	    String[] e = keyboard.nextLine().split("\\s*,\\s*");
	    int firste = Integer.parseInt(e[0]);
	    int seconde = Integer.parseInt(e[2]);
	    int thirde = Integer.parseInt(e[4]);
	   
	    int value1e = score(letOne,letTwo,letThree,letFour,firste,e[1]);
	    int value2e = score(letOne,letTwo,letThree,letFour,seconde,e[3]);
	    int value3e = score(letOne,letTwo,letThree,letFour,thirde,e[5]);
	    
	    System.out.println(greatest(value1e,value2e,value3e));
		
	}
	
}
