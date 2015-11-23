package org.dalton.acsl3.fanorona13;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ACSL3_Fanorona13_MR {
	/** Morris Reeves
	 *  The Dalton School
	 *  School Code: 3055
	 *  ACSL Contest 3: Fanorona
	 */

	public static void main(String[] args) 
	{
		String[] pieces = new String[24]; //stores all pieces
		Scanner scan = new Scanner(System.in);

		for(int input=0; input<5; input++) //runs through 5 lines of input
		{
			pieces = scan.nextLine().split(", ");
			int[] white = new int[Integer.parseInt(pieces[0])]; //stores white pieces
			int[] black = new int[pieces.length - white.length - 2]; //stores black pieces
			for(int i=0; i<white.length; i++)
			{
				white[i] = Integer.parseInt(pieces[i+1]);
			}

			for(int n=0; n<black.length; n++)
			{
				black[n] = Integer.parseInt(pieces[n + white.length + 2]);
			}

			List<String> whitemoves = new ArrayList<String>(); //POSSIBLE WHITE MOVES
			List<Integer> output = new ArrayList<Integer>(); //black pieces that can be taken

			List<Integer> southeast = Arrays.asList(5, 15, 21, 23, 25); //at these starting points, cannot move in indicated direction
			List<Integer> northeast = Arrays.asList(1, 3, 5, 15, 25);
			List<Integer> northwest = Arrays.asList(1, 3, 5, 11, 21);
			List<Integer> southwest = Arrays.asList(1, 11, 21, 23, 25);

			List<Integer> blackpieces = new ArrayList<Integer>(); //BLACK LOCATIONS
			for(int index = 0; index < black.length; index++)
			{
				blackpieces.add(black[index]);
			}

			List<Integer> whitepieces = new ArrayList<Integer>(); //WHITE LOCATIONS
			for(int index1 = 0; index1 < white.length; index1++)
			{
				whitepieces.add(white[index1]);
			}

			for(int a=0; a<white.length; a++) //go through white pieces, find POSSIBLE WHITE MOVES
			{
				int tmp = white[a];
				if(tmp>5 && !blackpieces.contains(tmp-5) && !whitepieces.contains(tmp-5)) whitemoves.add(String.valueOf(tmp-5) + ".NN"); //if place greater than 5 can always move up
				if(tmp<21 && !blackpieces.contains(tmp+5) && !whitepieces.contains(tmp+5)) whitemoves.add(String.valueOf(tmp+5) + ".SS"); //if place less than 21 can always move down
				if(tmp%5 !=0 && !blackpieces.contains(tmp+1) && !whitepieces.contains(tmp+1)) whitemoves.add(String.valueOf(tmp+1) + ".EE"); //EAST
				if(tmp%5 !=1 && !blackpieces.contains(tmp-1) && !whitepieces.contains(tmp-1)) whitemoves.add(String.valueOf(tmp-1) + ".WW"); //WEST
				if(tmp%2 !=0)
				{
					if(!southeast.contains(tmp) && !blackpieces.contains(tmp+6) && !whitepieces.contains(tmp+6)) whitemoves.add(String.valueOf(tmp+6) + ".SE"); //SOUTHEAST
					if(!northwest.contains(tmp) && !blackpieces.contains(tmp-6) && !whitepieces.contains(tmp-6)) whitemoves.add(String.valueOf(tmp-6) + ".NW"); //NORTHWEST
					if(!southwest.contains(tmp) && !blackpieces.contains(tmp+4) && !whitepieces.contains(tmp+4)) whitemoves.add(String.valueOf(tmp+4) + ".SW"); //SOUTHWEST
					if(!northeast.contains(tmp) && !blackpieces.contains(tmp-4) && !whitepieces.contains(tmp-4)) whitemoves.add(String.valueOf(tmp-4) + ".NE"); //NORTHEAST
				}
			}
			//System.out.println(whitemoves);

			for(int c=0; c<whitemoves.size(); c++) //loop through POSSIBLE WHITE MOVES, finding BLACK PIECES TO TAKE
			{
				output.addAll(Hunt(whitemoves.get(c), black));
			}
			//System.out.println(output);
			// assume String
			Iterator<Integer> it = output.iterator();
			if (it.hasNext()) {
			    System.out.print(it.next());
			}
			else System.out.print("NONE");
			while (it.hasNext()) {
			    System.out.print(", " + it.next());
			} 
			System.out.println();
		}
	}

	static List<Integer> Hunt (String placedirection, int[] black)
	{
		List<Integer> output = new ArrayList<Integer>();
		List<Integer> southeasttowards = Arrays.asList(5, 15, 21, 23, 25);
		List<Integer> southeast = Arrays.asList(7, 8, 9, 10, 12, 17, 22); //upon moving to these, a "move directly away to take" is not possible
		
		List<Integer> northeasttowards = Arrays.asList(1, 3, 5, 15, 25);
		List<Integer> northeast = Arrays.asList(2, 7, 12, 17, 18, 19, 20);
		
		List<Integer> northwesttowards = Arrays.asList(1, 3, 5, 11, 21);
		List<Integer> northwest = Arrays.asList(4, 9, 14, 16, 17, 18, 19);
		
		List<Integer> southwesttowards = Arrays.asList(1, 11, 21, 23, 25);
		List<Integer> southwest = Arrays.asList(6, 7, 8, 9, 14, 19, 24);
		int placeaftermove = Integer.parseInt(placedirection.substring(0, placedirection.indexOf(".")));

		if(placedirection.contains("NN"))
		{
			for(int z=0; z<black.length; z++) //loop through locations of black pieces
			{
				if(black[z] == placeaftermove - 5)
				{
					output.add(black[z]);
					for(int z1=0; z1<black.length; z1++)
					{
						if(black[z1] == placeaftermove - 10)
						{
							output.add(black[z1]);
							for(int z2=0; z2<black.length; z2++)
							{
								if(black[z2] == placeaftermove - 15)
								{
									output.add(black[z2]);
								}
							}
						}
					}
				}
				else if(black[z] == placeaftermove + 10)
				{
					output.add(black[z]);
					for(int z1=0; z1<black.length; z1++)
					{
						if(black[z1] == placeaftermove + 15)
						{
							output.add(black[z1]);
							for(int z2=0; z2<black.length; z2++)
							{
								if(black[z2] == placeaftermove + 20)
								{
									output.add(black[z2]);
								}
							}
						}
					}
				}
			}
		}

		if(placedirection.contains("SS"))
		{
			for(int z=0; z<black.length; z++) //loop through locations of black pieces
			{
				if(black[z] == placeaftermove + 5)
				{
					output.add(black[z]);
					for(int z1=0; z1<black.length; z1++)
					{
						if(black[z1] == placeaftermove + 10)
						{
							output.add(black[z1]);
							for(int z2=0; z2<black.length; z2++)
							{
								if(black[z2] == placeaftermove + 15)
								{
									output.add(black[z2]);
								}
							}
						}
					}
				}
				else if(black[z] == placeaftermove - 10)
				{
					output.add(black[z]);
					for(int z1=0; z1<black.length; z1++)
					{
						if(black[z1] == placeaftermove - 15)
						{
							output.add(black[z1]);
							for(int z2=0; z2<black.length; z2++)
							{
								if(black[z2] == placeaftermove - 20)
								{
									output.add(black[z2]);
								}
							}
						}
					}
				}
			}
		}

		if(placedirection.contains("EE"))
		{
			for(int z=0; z<black.length; z++) //loop through locations of black pieces
			{
				if(placeaftermove%5!=0 && black[z] == placeaftermove + 1) //impossible to take anything from rightmost column
				{
					output.add(black[z]);
					for(int z1=0; z1<black.length; z1++)
					{
						if(placeaftermove%5!=0 && black[z1] == placeaftermove + 2)
						{
							output.add(black[z1]);
							for(int z2=0; z2<black.length; z2++)
							{
								if(placeaftermove%5!=0 && black[z2] == placeaftermove + 3)
								{
									output.add(black[z2]);
								}
							}
						}
					}
				}
				else if(placeaftermove%5!=2 && black[z] == placeaftermove - 2) //impossible to move away from black at second column
				{
					output.add(black[z]);
					for(int z1=0; z1<black.length; z1++)
					{
						if(placeaftermove%5!=2 && black[z1] == placeaftermove - 3)
						{
							output.add(black[z1]);
							for(int z2=0; z2<black.length; z2++)
							{
								if(placeaftermove%5!=2 && black[z2] == placeaftermove - 4)
								{
									output.add(black[z2]);
								}
							}
						}
					}
				}
			}
		}

		if(placedirection.contains("WW"))
		{
			for(int z=0; z<black.length; z++) //locations of black pieces
			{
				if(placeaftermove%5!=1 && black[z] == placeaftermove - 1) //impossible to take anything from first column
				{
					output.add(black[z]);
					for(int z1=0; z1<black.length; z1++)
					{
						if(placeaftermove%5!=1 && black[z1] == placeaftermove - 2)
						{
							output.add(black[z1]);
							for(int z2=0; z2<black.length; z2++)
							{
								if(placeaftermove%5!=1 && black[z2] == placeaftermove - 3)
								{
									output.add(black[z2]);
								}
							}
						}
					}
				}
				else if(placeaftermove%5!=4 && black[z] == placeaftermove + 2)
				{
					output.add(black[z]);
					for(int z1=0; z1<black.length; z1++)
					{
						if(placeaftermove%5!=4 && black[z1] == placeaftermove + 3)
						{
							output.add(black[z1]);
							for(int z2=0; z2<black.length; z2++)
							{
								if(placeaftermove%5!=4 && black[z2] == placeaftermove + 4)
								{
									output.add(black[z2]);
								}
							}
						}
					}
				}
			}
		}

		if(placeaftermove%2!=0) //odd required for diagonal movement
		{
			if(placedirection.contains("SE"))
			{
				for(int z=0; z<black.length; z++) //loop through black pieces
				{
					if(!southeasttowards.contains(placeaftermove) && black[z] == placeaftermove + 6)
					{
						output.add(black[z]);
						for(int z1=0; z1<black.length; z1++)
						{
							if(black[z1] == placeaftermove + 12)
							{
								for(int z2=0; z2<black.length; z2++)
								{
									if(black[z2] == placeaftermove + 18)
									{
										output.add(black[z2]);
									}
								}
							}
						}
					}
					else if(!southeast.contains(placeaftermove) && black[z] == placeaftermove - 12)
					{
						output.add(black[z]);
						for(int z1=0; z1<black.length; z1++)
						{
							if(black[z1] == placeaftermove - 18)
							{
								for(int z2=0; z2<black.length; z2++)
								{
									if(black[z2] == placeaftermove - 24)
									{
										output.add(black[z2]);
									}
								}
							}
						}
					}
				}
			}

			if(placedirection.contains("NW"))
			{
				for(int z=0; z<black.length; z++) //loop through black pieces
				{
					if(!northwesttowards.contains(placeaftermove) && black[z] == placeaftermove - 6)
					{
						output.add(black[z]);
						for(int z1=0; z1<black.length; z1++)
						{
							if(black[z1] == placeaftermove - 12)
							{
								output.add(black[z1]);
								for(int z2=0; z2<black.length; z2++)
								{
									if(black[z2] == placeaftermove - 18)
									{
										output.add(black[z2]);
									}
								}
							}
						}
					}
					else if(!northwest.contains(placeaftermove) && black[z] == placeaftermove + 12)
					{
						output.add(black[z]);
						for(int z1=0; z1<black.length; z1++)
						{
							if(black[z1] == placeaftermove + 18)
							{
								output.add(black[z1]);
								for(int z2=0; z2<black.length; z2++)
								{
									if(black[z2] == placeaftermove + 24)
									{
										output.add(black[z2]);
									}
								}
							}
						}
					}
				}
			}
			
			if(placedirection.contains("SW"))
			{
				for(int z=0; z<black.length; z++) //loop through black pieces
				{
					if(!southwesttowards.contains(placeaftermove) && black[z] == placeaftermove + 4)
					{
						output.add(black[z]);
						for(int z1=0; z1<black.length; z1++)
						{
							if(black[z1] == placeaftermove + 8)
							{
								output.add(black[z1]);
								for(int z2=0; z2<black.length; z2++)
								{
									if(black[z2] == placeaftermove + 12)
									{
										output.add(black[z2]);
									}
								}
							}
						}
					}
					else if(!southwest.contains(placeaftermove) && black[z] == placeaftermove - 8)
					{
						output.add(black[z]);
						for(int z1=0; z1<black.length; z1++)
						{
							if(black[z1] == placeaftermove - 12)
							{
								output.add(black[z1]);
								for(int z2=0; z2<black.length; z2++)
								{
									if(black[z2] == placeaftermove - 16)
									{
										output.add(black[z2]);
									}
								}
							}
						}
					}
				}
			}
			
			if(placedirection.contains("NE")) //DONEii
			{
				for(int z=0; z<black.length; z++) //loop through black pieces
				{
					if(!northeasttowards.contains(placeaftermove) && black[z] == placeaftermove - 4)
					{
						output.add(black[z]);
						for(int z1=0; z1<black.length; z1++)
						{
							if(black[z1] == placeaftermove - 8)
							{
								output.add(black[z1]);
								for(int z2=0; z2<black.length; z2++)
								{
									if(black[z2] == placeaftermove - 12)
									{
										output.add(black[z2]);
									}
								}
							}
						}
					}
					else if(!northeast.contains(placeaftermove) && black[z] == placeaftermove + 8)
					{
						output.add(black[z]);
						for(int z1=0; z1<black.length; z1++)
						{
							if(black[z1] == placeaftermove + 12)
							{
								output.add(black[z1]);
								for(int z2=0; z2<black.length; z2++)
								{
									if(black[z2] == placeaftermove + 16)
									{
										output.add(black[z2]);
									}
								}
							}
						}
					}
				}
			}
		}
	return output;
	}
	
}


