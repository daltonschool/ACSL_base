package org.dalton.acsl1.scrabble13;
import java.util.Scanner;
/**
 * @author Elana Simon
 * The Dalton School
 * 3055
 */

public class ACSL1_Scrabble13_ES {

	public static int valueCalc(int[][] letters1, int startPos, boolean direction){
		int wordMultiplier = 1;
		int wordScore = 0;	
		
		int[][]letters=new int[4][2];	//duplicates letters so that it doesn't affect the real array
		for (int i = 0; i < letters.length; i++) {
			letters[i][0]=letters1[i][0];
		}

		letters[0][1]=startPos;
		if(direction==true){letters[1][1]=startPos+1;letters[2][1]=startPos+2;letters[3][1]=startPos+3;}
		else {letters[1][1]=startPos+10;letters[2][1]=startPos+20;letters[3][1]=startPos+30;}

		for (int i = 0; i < letters.length; i++) {
			//		System.out.println("letter value : "+letters[i][0]+" at "+letters[i][1]);		
			
			switch(letters[i][1]){
			case 3: case 9: case 15: case 21: case 27: case 33: case 39: 
				//					System.out.println("letter*2 at "+letters[i][1]); 
				letters[i][0]*=2;break;
			case 5: case 10: case 20: case 25: case 30: case 35: case 40: 
				//					System.out.println("letter*3 at "+letters[i][1]); 
				letters[i][0]*=3;break;
			case 7: case 14: case 28: 
				//					System.out.println("word*2 at "+letters[i][1]); 
				wordMultiplier*=2;break;
			case 8: case 16: case 24: case 32: 
				//					System.out.println("word*3 at "+letters[i][1]);
				wordMultiplier*=3;
				break;
			}

			wordScore+=letters[i][0];
		//		System.out.println("letter value : "+letters[i][0]+" at "+letters[i][1]);		
		//		System.out.println("word multiplier is: "+wordMultiplier);
		}
		wordScore*=wordMultiplier;
		wordMultiplier=1;

		return wordScore;
	}


	public static void main (String[] args){
		int counter=0;
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		word = word.replaceAll(",","");
		word = word.replaceAll(" ","");
		
		while(counter<5){
			int MaxPoints = 0;
			String input = scanner.nextLine();
			input=input.replaceAll(" ", "");
			String[] splitInput = input.split(",");
			
			int StartPos = 1;
			boolean direction;	//horiz true, vert false
			int[][] letters = new int[4][2];

			for (int i = 0; i <= 3;i++) {
				switch(word.charAt(i)){
				case 'A': case 'E': letters[i][0]=1; break;
				case 'D': case 'R': letters[i][0]=2; break;
				case 'B': case 'M': letters[i][0]=3; break;
				case 'V': case 'Y': letters[i][0]=4; break;
				case 'J': case 'X': letters[i][0]=8; break;
				}
			}

			for (int i = 0; i < splitInput.length; i++) {
				StartPos=Integer.parseInt(splitInput[i]);
				if(splitInput[i+1].equals("H")){direction=true;}
				else {direction=false;}
				i++;
				MaxPoints=Math.max(MaxPoints, valueCalc(letters,StartPos, direction));
			}

			System.out.println(MaxPoints);
			counter++;
		}
	}
}