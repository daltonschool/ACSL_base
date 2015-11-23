package org.dalton.acsl1.scrabble13;
import java.util.Scanner;
import java.util.HashMap;

/*
 * Samuel Stone
 * ACSL Program 1 (ACSL Scrabble)
 * The Dalton School
 * School Code: 3305
 */
public class ACSL1_Scrabble13_SS 
{
	//Arrays of double/triple letter spots
	static int [] double_letters = new int[7];
	static int [] triple_letters = new int[7];

	
	public static boolean checkTiles(int number, int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			if(array[i] == number)
			{
				return true; 
			}
		}
		return false; 
	}
	
	public static void main(String[] args)
	{
		//Here I fill the double letters array with the values where double letter tiles are
		double_letters[0] = 3;
		double_letters[1] = 9;
		double_letters[2] = 15;
		double_letters[3] = 21;
		double_letters[4] = 27;
		double_letters[5] = 33;
		double_letters[6] = 39;

		//Here I fill the triple letters array with the values where triple letter tiles are
		triple_letters[0] = 5;
		triple_letters[1] = 10;
		triple_letters[2] = 20;
		triple_letters[3] = 25;
		triple_letters[4] = 30;
		triple_letters[5] = 35;
		triple_letters[6] = 40; 


		Scanner scan = new Scanner(System.in); //Scanner
		HashMap<String, Integer> map_values = new HashMap<String, Integer>(); //Using hashmap to associate words with point values

		//Create and fill Arrays of double word and triple word tiles below
		int[] double_words = new int[3];
		double_words[0] = 7;
		double_words[1] = 14;
		double_words[2] = 28;

		int[] triple_words = new int[4];
		triple_words[0] = 8;
		triple_words[1] = 16;
		triple_words[2] = 24;
		triple_words[3] = 32;


		int score = 0; //Hold score of each possibility
		int max = 0;  //Compare each possibility to the max possibility

		String[] brokenupword = scan.nextLine().split(","); //Split the first line of input at commas and make each thing a letter
		for (int i = 0; i < brokenupword.length; i++)
		{
			brokenupword[i] = brokenupword[i].trim(); //Trim the spaces so it is just letters
		}


		for (int i = 1; i < 6; i++) //Loop through the 5 inputs of locations, etc
		{
			score = 0; 
			max = 0; 
			String[] location_input = scan.nextLine().split(", "); //Split everything by comma space (so annoying that ACSL uses spaces in their programs...)
			//Assign the values given on the table

			map_values.put("J", 8);
			map_values.put("X", 8);
			map_values.put("V", 4);
			map_values.put("Y", 4);
			map_values.put("B", 3);
			map_values.put("M", 3);
			map_values.put("D", 2);
			map_values.put("R", 2);
			map_values.put("A", 1);
			map_values.put("E", 1);

			int starting_spot = 0; 

			int[] locations = new int[4]; 

			for (int j = 0; j < 3; j++) //Loop through the three possibilities of place and direction, then time to actually add the values!
			{
				starting_spot = Integer.parseInt(location_input[2*j]); //Skip to the spots (even # spots) in the array where the numbers are

				if (location_input[2*j + 1].equals("V")) //Finds where it is vertical after the starting spot
				{
					//					starting_spot = Integer.parseInt(location_input[2*j]); 
					locations[0] = starting_spot; 
					locations[1] = starting_spot + 10; //Skips down a column (eg from spot 2 to 12, because rows are 10 spots long this skips columns)
					locations[2] = starting_spot + 20; //See above
					locations[3] = starting_spot + 30; //See above

					for (int k = 0; k < 4; k++) //Loop through the four letters of the word, so we can add values of each letter 
					{
						int multiplier = 0;
						if (checkTiles(locations[k], double_letters) == true)//If tile is double letter, make mult 2
						{
							multiplier = 2;
						}
						else if (checkTiles(locations[k], triple_letters) == true)//If tile is TL, make mult 3
						{
							multiplier = 3;
						}
						else //normal mult = 1
						{
							multiplier = 1;
						}
						score += map_values.get(brokenupword[k])*multiplier; //Add the value of the letter * the multiplier of the tile
					}

					for (int a = 0; a < 4; a++) //Loop through four letters of word, so we can see if any are on DW or TW tiles
					{

						if(checkTiles(locations[a], double_words) == true) //Check DW, then mult x2
						{
							score = score * 2;
						}
						if(checkTiles(locations[a], triple_words) == true) //Check TW, then mult x2
						{
							score = score * 3;
						}
					}
					if(score > max)
					{
						max = score; //Take the max score of the 3 possibilities
					}
					score = 0;//Reset score before trying next placement possibility
				}
				else if(location_input[2*j + 1].equals("H"))//Finds where it is horizontal after the starting spot
				{ 
					locations[0] = starting_spot; 
					locations[1] = starting_spot + 1; //now since it is horizontal instead of vertical, just add 1 spot each time 
					locations[2] = starting_spot + 2; //above
					locations[3] = starting_spot + 3; //above
					for (int k = 0; k < 4; k++) //Loop through spots in the word
					{
						//Below code same as in vertical section, just check for double letters and triple letters
						int multiplier = 0;
						if (checkTiles(locations[k], double_letters) == true)//If tile is double letter, make mult 2
						{
							multiplier = 2;
						}
						else if (checkTiles(locations[k], triple_letters) == true)//If tile is TL, make mult 3
						{
							multiplier = 3;
						}
						else //normal mult = 1
						{
							multiplier = 1;
						}
						score += map_values.get(brokenupword[k])*multiplier;
					}
					//Below is same exact loop from above
					for (int a = 0; a < 4; a++) //Loop through four letters of word, so we can see if any are on DW or TW tiles
					{

						if(checkTiles(locations[a], double_words) == true) //Check DW, then mult x2
						{
							score = score * 2;
						}
						if(checkTiles(locations[a], triple_words) == true) //Check TW, then mult x2
						{
							score = score * 3;
						}
					}
					//Same as above
					if(score > max)
						max = score; 
					score = 0; 
				}

			}
			System.out.println(max); //print out max possible score
		}
	}

	
}