package org.dalton.acsl3.mancala10;

import java.util.Scanner;

/**
 * Cara Haas
 * The Dalton School
 * 9075
 */

public class Contest3Final {

	public static void main(String[] args) {
		Scanner takeIn = new Scanner(System.in);

		int[] bowls=new int[12];
		int bowlA=0;
		int bowlB=0;
		int hand=0;
		int Adrop=-1;
		int Bdrop=-1;

		for(int i=0; i<12; i++)
		{
			bowls[i]=4;
		}


		for(int AorB=0; AorB<5; AorB++)//A when even, B when odd
		{
			String first=takeIn.nextLine();
			String[] comingIn=new String[2];
			comingIn=first.split(", ");
			int bowlOne=Integer.parseInt(comingIn[0]);
			String returning=comingIn[1];
			int location=bowlOne-1;	
			int lastLoc=location;
			int turn=0;
			boolean addLoc=false;

			while((bowls[location]!=1||turn==0)&&((bowls[location]!=4&&Adrop!=location&&Bdrop!=location)||turn==0))
			{
				hand=bowls[location];
				bowls[location]=0;

				if(hand==0)
				{
					break;
				}
				else if(turn==0)
				{
					if(location==11)
					{
						if((AorB==1 || AorB==3)&&hand!=0)
						{
							bowlB++;
							hand--;
						}

						location=0;
					}
					else if(location==5)
					{
						if((AorB==0||AorB==2||AorB==4)&&hand!=0)
						{
							bowlA++;
							hand--;
						}
						location++;
					}
					else
					{
						location++;
					}
				}

				while(hand>0)
				{
					if(addLoc==true)
					{
						if(location==11)
						{
							location=0;
						}
						else
						{	
							location++;
						}
					}

					if(location==6&&(AorB==0||AorB==2||AorB==4)&&Adrop!=location && turn!=0)
					{
						bowlA++;
						hand--;
						Adrop=location;
						lastLoc=location;
					}
					else if(location==0&&(AorB==1||AorB==3)&&Bdrop!=location && turn!=0)
					{
						bowlB++;
						hand--;
						Bdrop=location;
						lastLoc=location;
					}
					else if(location==11)
					{
						bowls[location]=bowls[location]+1;
						lastLoc=location;
						hand--;
						location=0;
						Adrop=-1;
						Bdrop=-1;
					}
					else
					{
						bowls[location]=bowls[location]+1;
						lastLoc=location;
						hand--;
						location++;
						Adrop=-1;
						Bdrop=-1;
					}
					turn++;

					addLoc=false;
				}

				location=lastLoc;
				addLoc=true;
			}
			
			if(returning.equals("A"))
			{
				System.out.println(bowlA);
			}
			else if(returning.equals("B"))
			{
				System.out.println(bowlB);
			}
			else
			{
				int ret=Integer.parseInt(returning)-1;
				System.out.println(bowls[ret]);
			}
		}
	}
}
