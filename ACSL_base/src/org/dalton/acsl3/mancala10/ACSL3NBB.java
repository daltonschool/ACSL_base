package org.dalton.acsl3.mancala10;
/**
 * Nora Bresette Buccino
 * ACSL 3
 */

import java.util.Scanner;
public class ACSL3NBB {

	public static void main(String[] args)
	{
		int whichuser = 0; 
		Scanner scan = new Scanner(System.in); 
		int[] mancalaboard;             
		mancalaboard = new int[12];      
		mancalaboard[0] = 4;
		mancalaboard[1] = 4;
		mancalaboard[2] = 4;
		mancalaboard[3] = 4;
		mancalaboard[4] = 4;
		mancalaboard[5] = 4;
		mancalaboard[6] = 4;
		mancalaboard[7] = 4;
		mancalaboard[8] = 4;
		mancalaboard[9] = 4;
		mancalaboard[10] = 4;
		mancalaboard[11] = 4;
		int playerB = 0; 
		int playerA = 0; 
		for(int i = 0; i < 5; i++) 
		{			
			String userinput = scan.nextLine(); 
			String[] inputarray = userinput.split(", "); 
			int position = Integer.parseInt(inputarray[0]) -1; 
			boolean outputA = false;
			boolean outputB = false;
			int output = 0;
			if(inputarray[1].equals("A"))
			{

				outputA = true;
			}

			else if(inputarray[1].equals("B"))
			{
				outputB = true;
			}

			else
			{

				output = Integer.parseInt(inputarray[1]) -1 ; 
			}			
			int heldbyuser= 0; 
			boolean userisA; 

			if(whichuser%2 == 0) 
			{
				userisA = true;
			}
			else
			{
				userisA = false;
			}
			heldbyuser = mancalaboard[position]; 
			mancalaboard[position] = 0; 
			if (position <11)
			{
				position++;
			}
			else if (position ==11)
			{
				position = 0;
			}

			boolean game = true;
			while(game) 
			{
				while(heldbyuser > 0) 
				{
					mancalaboard[position] = mancalaboard[position] + 1; 
					heldbyuser = heldbyuser - 1; 


					if((mancalaboard[position] == 4 || mancalaboard[position] == 1) && heldbyuser == 0) 
					{
						if(outputA)
						{
							System.out.println(playerA);
						}

						else if(outputB)
						{
							System.out.println(playerB);
						}

						else
						{
							System.out.println(mancalaboard[output]);
						}

						game = false;
					}


					if(position == 11) 
					{

						if(!userisA)
						{
							if(heldbyuser > 0)
							{
								heldbyuser--; 
							}

							else
							{
								heldbyuser = mancalaboard[11] - 1; 
								mancalaboard[11] = 0;


							}
							playerB++; 


							if(heldbyuser == 0) 
							{
								if(outputA)
								{
									System.out.println(playerA); 
								}

								else if(outputB)
								{
									System.out.println(playerB);
								}

								else
								{
									System.out.println(mancalaboard[output]);
								}


								game = false;
							}
						}
					}

					if(userisA && position == 5)
					{


						if(heldbyuser > 0)
						{
							heldbyuser--; 
						}

						else
						{
							heldbyuser = mancalaboard[5] - 1; 
							mancalaboard[5] = 0;

						}

						playerA++; 


						if(heldbyuser == 0) 
						{
							if(outputA)
							{
								System.out.println(playerA);
							}

							else if(outputB)
							{
								System.out.println(playerB);

							}

							else
							{
								System.out.println(mancalaboard[output]);

							}

							game = false;
						}


					}

					if(heldbyuser == 0 && game)
					{

						{

							heldbyuser = mancalaboard[position]; 

							mancalaboard[position] = 0;

						}


					}
					if(position < 11)
					{
						position++;
					}

					else if(position ==11)
					{
						position =0;
					}
				}
			}
			whichuser++;
			game = true;
		}
	}
}