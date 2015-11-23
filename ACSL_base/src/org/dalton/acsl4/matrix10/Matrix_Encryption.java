package org.dalton.acsl4.matrix10;

import java.util.*;

/*
 * 
 * 
 * Sam Broner
 * ASCL 4
 *  9075 
 */
public class Matrix_Encryption {

	/**
	 * Test Code:
	 * E, MATH ROCKS, 0, 1, 1, 1
	 * 
	 * D, ANHARRCRSC, 0, 1, 1, 1
	 * 
	 * E, ANNEMADOFF, 0, 1, 1, 1
	 * 
	 * D, NOESANOSFL, 0, 1, 1, 1
	 * 
	 * D, GORDONCAMPBELL, 1, 0, 1, 1
	 * 
	 * E, GHRMOZCYMCBCL, 1, 0, 1, 1
	 * 
	 * E, A B C D E, 1, 1, 1, 1
	 * 
	 * E, HELLO, 0, 1, 1, 0
	 * 
	 * E, S P A C E S, 1, 2, 3, 4
	 * 
	 * E, HELLO WORLD, 3, 2, 2, 1
	 * 
	 * D, GUFIRCRGXULH, 3, 2, 2, 1
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 5; i++)
		{
			System.out.print(i+1 + ". ");
			Scanner in = new Scanner(System.in);
			String str = in.nextLine();// taking scanner

			String [] parts = str.split(", ", 3);
			String output = "";

		//	System.out.println("Encrypt or Decrypt: " + parts[0] + " The String: " + parts[1] + " The Code: " + parts[2]);

			String [] encoding_matrix = parts[2].split(", ");
			int a = Integer.parseInt(encoding_matrix[0]);
			int b = Integer.parseInt(encoding_matrix[1]);
			int c = Integer.parseInt(encoding_matrix[2]);
			int d = Integer.parseInt(encoding_matrix[3]);



			int message_length = parts[1].length();

		//	System.out.println("Length pre-Mod: " + message_length);
			if(message_length%2 == 1)
			{

				parts[1] = parts[1] + " ";
				//System.out.println(parts[1] + "|");

				message_length++;
			}

			int [] finalencoded = new int [message_length + 1];

			//System.out.println("Length post-Mod: " + message_length);

			char [] array = parts[1].toCharArray();


			int[] message = new int[message_length];

			for(int k = 0; k < message_length; k ++ )
			{

				if(!Character.isSpaceChar(array[k]))
				{
					message[k] = Character.getNumericValue(array[k]) - 9;
				}
				else
				{
					message[k] = 27;
				}

			}

			int [] encodeda = new int [message_length];
			int [] encodedb = new int [message_length];
			int [] encodedc = new int [message_length];
			int [] encodedd = new int [message_length];



			if (parts[0].equals("E"))
			{
				for(int k = 0; k < message_length; k ++ )
				{

					encodeda[k] = message[k]*a;
					encodedb[k] = message[k]*b;
					encodedc[k] = message[k]*c;
					encodedd[k] = message[k]*d;



			//		System.out.println("A: " + encodeda[k] + " C: "+ encodedb[k] + " B: " + encodedc[k] + " D: " + encodedd[k]);
				}

				for(int k = 0; k < message_length; k ++ )
				{
					if(k+1<message_length)
					{
						finalencoded[k] = encodeda[k] + encodedb[k+1];
						k++;


						finalencoded[k] = encodedc[k-1] + encodedd[k];
					}
					else
					{
						finalencoded[k] = encodeda[k] + 27*b;

						finalencoded[k+1] = encodedc[k] + 27*d;
					}

					//	System.out.println("Final Encoded Even: " + finalencoded[k-1] + "  Final Encoded Odd: " + finalencoded[k]);

				}

			}
			else if(parts[0].equals("D"))
			{

				for(int k = 0; k < message_length; k ++ )
				{

					encodeda[k] = message[k]*d/(a*d-b*c);
					encodedb[k] = message[k]*-b/(a*d-b*c);
					encodedc[k] = message[k]*-c/(a*d-b*c);
					encodedd[k] = message[k]*a/(a*d-b*c);


					//	System.out.println("A: " + encodeda[k] + " C: "+ encodedb[k] + " B: " + encodedc[k] + " D: " + encodedd[k]);
				}

				for(int k = 0; k < message_length; k ++ )
				{
					if(k+1<message_length)
					{
						finalencoded[k] = encodeda[k] + encodedb[k+1];
						k++;


						finalencoded[k] = encodedc[k-1] + encodedd[k];
					}
					else
					{
						finalencoded[k] = encodeda[k] + 27*b;

						finalencoded[k+1] = encodedc[k] + 27*d;
					}

					//		System.out.println("Final Encoded Even: " + finalencoded[k-1] + "  Final Encoded Odd: " + finalencoded[k]);

				}

			}




			for(int k = 0; k < message_length; k ++ )
			{
				while(!(28>finalencoded[k]&& finalencoded[k]>0))
				{
					if(finalencoded[k]> 27)
					{
						finalencoded[k] = finalencoded[k]%27;
					}
					if(finalencoded[k]<1)
					{
						finalencoded[k] = finalencoded[k] + 27;
					}
				}

			}

			for(int k = 0; k < message_length; k ++ )
			{

				//	System.out.println("Final Numbers: " + finalencoded[k]);

			}

			char [] fin = new char [message_length];

			for(int k = 0; k < message_length; k ++ )
			{

				if(finalencoded[k] != 27)
				{
					fin[k]= (char)(finalencoded[k]+64);
				}
				else
				{
					fin[k] = ' ';
				}

				output = new String(fin);




			}
			System.out.print("	" + output);
			System.out.println("");
		}// big "5" for
	}// main

}// class
