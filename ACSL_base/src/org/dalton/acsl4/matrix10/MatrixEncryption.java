package org.dalton.acsl4.matrix10;

//School: The Dalton School 
//School Code: 9010
//Name: Benjamin Tsoi	April, 23, 2011
import java.util.Scanner;
public class MatrixEncryption 
{
public static void main (String args[])
{
	String finalOutput[] = new String [5];//five lines of input so five lines of output
	int code [][] = new int [2][2];
	Scanner in = new Scanner (System.in);
	System.out.println("Welcome to Matrix Encryptor!");
	for(int i=0;i<5;i++)
	{
		System.out.println("Please type in the input for line "+(i+1)+".");
		String input = in.nextLine();
		String tempData []= input.split(", ");
		//manually store the 4 values provided in the input line into the 2X2 code array
		code [0][0] = Integer.parseInt(tempData [2]);	
		code [0][1] = Integer.parseInt(tempData [3]);
		code [1][0] = Integer.parseInt(tempData [4]);
		code [1][1] = Integer.parseInt(tempData [5]);
		char [] option = tempData[0].toCharArray();//either encode 'E' or decode 'D'
		char [] charData = tempData[1].toCharArray();//after the first comma is the data that the user wants to code
		char [] charData2 = tempData[1].toCharArray();//only needed to be used later to check for odd number of values
		int remainder;
		if (charData.length%2!=0)
		{
			remainder=1;
			//add a space to end of charData because there needs to be an even number of values to make 2X1 arrays
			charData = new char [charData2.length+1];
			for(int m=0; m<charData2.length; m++)
			{
				charData[m] = charData2[m];
			}
			charData [charData.length-1] = ' ';
		}
		else
		{
			remainder=0;
		}
		int numArray = (charData.length+remainder)/2;
		//character array to store all the whole line of code after it is encoded or decoded
		char finalcharArray [] = new char [numArray*2];
		//counter is essential because it increments the charData (for ex. from 1-10 for ten characters) since we only
		//deal with 2 characters at a time in a 1X2 matrix
		int counter=0;
		//the plan is to encode/decode each 1X2 individually an then storing it into finalcharArray before moving on
		for(int j=0; j<numArray; j++)
		{
			int tempArray []= new int [2];
			if (charData[counter]==' ')
			{
				tempArray[0]=27;//according to the rules, a space is given the value 27
			}
			if (charData[counter+1]==' ')
			{
				tempArray[1]=27;
			}
			if (charData[counter]!=' ')
			{
				//use ASCII (ex. A=65), but encoding/decoding works where A-Z are given values 1-26
				tempArray[0] = ((char) charData[counter])-64;
			}
			if (charData[counter+1]!=' ')
			{
				tempArray[1] = ((char) charData[counter+1])-64;
			}
			//this array holds the value of the encoded/decoded values before they are converted back to characters
			int finalnumArray [] = new int [2];
			if(option[0]=='E')
			{	
				//matrix multiplication using the 2X2 array of code and a 2X1 array section of data
				finalnumArray[0] = code[0][0]*tempArray[0]+code[0][1]*tempArray[1];
				finalnumArray[1] = code[1][0]*tempArray[0]+code[1][1]*tempArray[1];
				//System.out.println("finalnumArray[0]"+ finalnumArray[0]);
				//System.out.println("finalnumArray[1]"+ finalnumArray[1]);
			}
			else if(option[0]=='D')
			{		
				int convCode [][] = new int [2][2];
				//find the inverse of the code in order to decode
				//the value 1/(ad-bc), with a-d representing a value in the code				
				double num = 1.000/((code[0][0]*code[1][1])-(code[0][1]*code[1][0]));
				convCode [0][0] = (int)(num*code[1][1]);				
				convCode [0][1] = (int)(-1*num*code[0][1]);				
				convCode [1][0] = (int)(-1*num*code[1][0]);
				convCode [1][1] = (int)(num*code[0][0]);
				finalnumArray[0] = convCode[0][0]*tempArray[0]+convCode[0][1]*tempArray[1];
				finalnumArray[1] = convCode[1][0]*tempArray[0]+convCode[1][1]*tempArray[1];
				//System.out.println("finalnumArray[0]= "+finalnumArray[0]);
				//System.out.println("finalnumArray[1]= "+finalnumArray[1]);
			}
			//
			if(finalnumArray[0]>27)
			{
				finalcharArray[counter] = (char) ((finalnumArray[0]%27)+64);
			}
			if(finalnumArray[1]>27)
			{
				finalcharArray[counter+1] = (char) ((finalnumArray[1]%27)+64);
			}
			if(finalnumArray[0]<27&&finalnumArray[0]>0)
			{
				finalcharArray[counter] = (char) (finalnumArray[0]+64);
			}
			if(finalnumArray[1]<27&&finalnumArray[1]>0)
			{
				finalcharArray[counter+1] = (char) (finalnumArray[1]+64);
			}
			if(finalnumArray[0]==0||finalnumArray[0]==27)
			{
				finalcharArray[counter] = ' ';
			}
			if(finalnumArray[1]==0||finalnumArray[1]==27)
			{
				finalcharArray[counter+1] = ' ';
			}
			if(finalnumArray[0]<0)
			{
				finalcharArray[counter] = (char) ((finalnumArray[0]%27)+91);
			}
			if(finalnumArray[1]<0)
			{
				finalcharArray[counter+1] = (char) ((finalnumArray[1]%27)+91);
			}
			//the following four situations are only necessary to patch up errors that came up, A-Z in ASCII is 65-90,
			//and 64 and 91 are supposed to be spaces, so something wrong with my logic above regarding what is a space
			if(finalcharArray[counter]==64)
			{
				finalcharArray[counter]= ' ';
			}
			if(finalcharArray[counter+1]==64)
			{
				finalcharArray[counter+1]= ' ';
			}
			if(finalcharArray[counter]==91)
			{
				finalcharArray[counter]= ' ';
			}
			if(finalcharArray[counter+1]==91)
			{
				finalcharArray[counter+1]= ' ';
			}
			counter=counter+2;
		}
		//convert the finalcharArray into a string so it is easier to print and store into the finalOutput
		String str = new String (finalcharArray);
		finalOutput[i] = str;
	}	
	//print out all the values at the end
	for (int i=0; i<5; i++)
	{
		System.out.println((i+1)+". "+finalOutput[i]);
	}	
}
}