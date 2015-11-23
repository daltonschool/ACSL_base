package org.dalton.acsl4.matrix10;

/**
 * Anne Madoff
 * The Dalton School
 * ACSL
 * 9075
 */
import java.util.Scanner;//imports scanner

public class acslMatrixEncryption 
{
	public static void main(String[] args) 
	{//opens main

		Scanner input = new Scanner(System.in);//creates new Scanner
		int counter = 0;
		int[] encodingMatrix = new int[4];
		int[] invEncodingMatrix = new int[4];
		char[] numberMatchUp = new char[28];
		String finalmessage = "";

		numberMatchUp[0] = '*';
		numberMatchUp[1] = 'A';
		numberMatchUp[2] = 'B';
		numberMatchUp[3] = 'C';
		numberMatchUp[4] = 'D';
		numberMatchUp[5] = 'E';
		numberMatchUp[6] = 'F';
		numberMatchUp[7] = 'G';
		numberMatchUp[8] = 'H';
		numberMatchUp[9] = 'I';
		numberMatchUp[10] = 'J';
		numberMatchUp[11] = 'K';
		numberMatchUp[12] = 'L';
		numberMatchUp[13] = 'M';
		numberMatchUp[14] = 'N';
		numberMatchUp[15] = 'O';
		numberMatchUp[16] = 'P';
		numberMatchUp[17] = 'Q';
		numberMatchUp[18] = 'R';
		numberMatchUp[19] = 'S';
		numberMatchUp[20] = 'T';
		numberMatchUp[21] = 'U';
		numberMatchUp[22] = 'V';
		numberMatchUp[23] = 'W';
		numberMatchUp[24] = 'X';
		numberMatchUp[25] = 'Y';
		numberMatchUp[26] = 'Z';
		numberMatchUp[27] = ' ';

		while(counter<5)
		{
			String[] messyInput = input.nextLine().split(",");
			messyInput[1] = messyInput[1].substring(1,messyInput[1].length());
			messyInput[2] = messyInput[2].substring(1,messyInput[2].length());
			messyInput[3] = messyInput[3].substring(1,messyInput[3].length());
			messyInput[4] = messyInput[4].substring(1,messyInput[4].length());
			messyInput[5] = messyInput[5].substring(1,messyInput[5].length());

			//create encoding matrix
			encodingMatrix[0] = Integer.parseInt(messyInput[2]);
			encodingMatrix[1] = Integer.parseInt(messyInput[3]);
			encodingMatrix[2] = Integer.parseInt(messyInput[4]);
			encodingMatrix[3] = Integer.parseInt(messyInput[5]);
			//create inverse encoding matrix
			invEncodingMatrix[0] = (1/(encodingMatrix[0]*encodingMatrix[3]-encodingMatrix[1]*encodingMatrix[2]))*encodingMatrix[3];
			invEncodingMatrix[1] = (1/(encodingMatrix[0]*encodingMatrix[3]-encodingMatrix[1]*encodingMatrix[2]))*-encodingMatrix[1];
			invEncodingMatrix[2] = (1/(encodingMatrix[0]*encodingMatrix[3]-encodingMatrix[1]*encodingMatrix[2]))*-encodingMatrix[2];
			invEncodingMatrix[3] = (1/(encodingMatrix[0]*encodingMatrix[3]-encodingMatrix[1]*encodingMatrix[2]))*encodingMatrix[0];

			//create char array for message
			char[] charArray = messyInput[1].toCharArray(); 

			int lengthForForLoop = 0;
			if(charArray.length%2==1)
			{
				char[] finalCharArray = new char[charArray.length+1];
				finalCharArray[finalCharArray.length-1] = ' ';
				for(int x = 0; x<finalCharArray.length-1; x++)
				{
					finalCharArray[x] = charArray[x];
				}
				lengthForForLoop = finalCharArray.length/2;
				charArray = finalCharArray;
			}
			else if(charArray.length%2==0)
			{
				char[] finalCharArray = new char[charArray.length];
				for(int x = 0; x<finalCharArray.length; x++)
				{
					finalCharArray[x] = charArray[x];
				}
				lengthForForLoop = finalCharArray.length/2;
				charArray = finalCharArray;
			}

			int[] messageMatrix = new int[2];
			int[] afterCodeMatrix = new int[2];
			for(int x = 0; x<charArray.length-1;)
			{
				//create 2x1 message matrix
				for(int i = 0; i<28; i++)
				{
					//System.out.println(charArray[x]+","+numberMatchUp[i]);
					if(charArray[x]==numberMatchUp[i])
					{
						messageMatrix[0] = i;
						//System.out.println("success @ line 107 : " + i);
					}

					if(charArray[x+1]==numberMatchUp[i])
					{
						messageMatrix[1] = i;
						//System.out.println("success @ line 113: " + i);
					}
				}

				//System.out.println(messageMatrix[0] +"," + messageMatrix[1]);
				if(messyInput[0].equalsIgnoreCase("E"))
				{
					afterCodeMatrix[0]=encodingMatrix[0]*messageMatrix[0]+encodingMatrix[1]*messageMatrix[1];
					afterCodeMatrix[1]=encodingMatrix[2]*messageMatrix[0]+encodingMatrix[3]*messageMatrix[1];

					int q=0;
					while(q <15)
					{
						if(afterCodeMatrix[0]>27)
						{
							afterCodeMatrix[0]= afterCodeMatrix[0]%27;
						}
						if(afterCodeMatrix[1]>27)
						{
							afterCodeMatrix[1]= afterCodeMatrix[1]%27;
						}
						if(afterCodeMatrix[0]<=0)
						{
							afterCodeMatrix[0]+=27;
						}
						if(afterCodeMatrix[1]<=0)
						{
							afterCodeMatrix[1]+=27;
						}
						q++;
					}

					//System.out.println("afterCodeMatrix[0]= " +afterCodeMatrix[0]+ "afterCodeMatrix[1]= "+ afterCodeMatrix[1]);
					String addoutput1 = "";
					String addoutput2 = "";
					for(int i = 1; i<28; i++)
					{
						//System.out.println(afterCodeMatrix[0]+","+i);
						if(afterCodeMatrix[0]==i)
						{
							//System.out.println("success 128, numberMatchUp[i]= " + numberMatchUp[i]+ "afterCodeMatrix[0]= " +afterCodeMatrix[0]);
							addoutput1 = Character.toString(numberMatchUp[i]);
							//System.out.println(addoutput1);
						}

						if(afterCodeMatrix[1]==i)
						{
							//System.out.println("success 136, numberMatchUp[i]= " + numberMatchUp[i] + "afterCodeMatrix[1]= " +afterCodeMatrix[1]);
							addoutput2 = Character.toString(numberMatchUp[i]);
							//System.out.println(addoutput2);
						}
					}

					finalmessage = finalmessage + addoutput1 + addoutput2;

				}

				else if(messyInput[0].equalsIgnoreCase("D"))
				{
					//System.out.println("messageMatrix: " + messageMatrix[0] + "," + messageMatrix[1]);

					afterCodeMatrix[0]=invEncodingMatrix[0]*messageMatrix[0]+invEncodingMatrix[1]*messageMatrix[1];
					afterCodeMatrix[1]=invEncodingMatrix[2]*messageMatrix[0]+invEncodingMatrix[3]*messageMatrix[1];

					//System.out.println(invEncodingMatrix[0]+","+messageMatrix[0]+","+invEncodingMatrix[1]+","+messageMatrix[1]);
					//System.out.println(invEncodingMatrix[2]+","+messageMatrix[0]+","+invEncodingMatrix[3]+","+messageMatrix[1]);
					//System.out.println("invEncodingMatrix: " +invEncodingMatrix[0] + "," + invEncodingMatrix[1]+ "," + invEncodingMatrix[2]+ "," + invEncodingMatrix[3]);

					int q=0;
					while(q <15)
					{
						if(afterCodeMatrix[0]>27)
						{
							afterCodeMatrix[0]= afterCodeMatrix[0]%27;
						}
						if(afterCodeMatrix[1]>27)
						{
							afterCodeMatrix[1]= afterCodeMatrix[1]%27;
						}
						if(afterCodeMatrix[0]<=0)
						{
							afterCodeMatrix[0]+=27;
						}
						if(afterCodeMatrix[1]<=0)
						{
							afterCodeMatrix[1]+=27;
						}
						q++;
					}

					String addoutput1 = "";
					String addoutput2 = "";
					//System.out.println("afterCodeMatrix[0]= " + afterCodeMatrix[0]+" afterCodeMatrix[1]= "+ afterCodeMatrix[1]);

					for(int i = 1; i<28; i++)
					{
						if(afterCodeMatrix[0]==i)
						{
							//System.out.println("success 128, numberMatchUp[i]= " + numberMatchUp[i]+ " afterCodeMatrix[0]= " +afterCodeMatrix[0]);
							addoutput1 = Character.toString(numberMatchUp[i]);
							//System.out.println(addoutput1);
						}

						if(afterCodeMatrix[1]==i)
						{
							//System.out.println("success 136, numberMatchUp[i]= " + numberMatchUp[i] + " afterCodeMatrix[1]= " +afterCodeMatrix[1]);
							addoutput2 = Character.toString(numberMatchUp[i]);
							//System.out.println(addoutput2);
						}
					}

					finalmessage = finalmessage + addoutput1 + addoutput2;

				}

				x+=2;
			}
			counter++;
			System.out.println(finalmessage);
			finalmessage = "";
		}
	}
}
