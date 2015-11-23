package org.dalton.acsl4.matrix10;

import java.util.*;

public class Matrix_Encription {
	
	public static void decode(String input, int a, int b, int c, int d){
		
		if ((input.length()%2) == 1)
		{
			 StringBuffer st = new StringBuffer (input);
			 st.append(" ");
			 input = st.toString();
		}
		
		 StringBuffer finalOutput = new StringBuffer ("");		
	        char[] charArray = input.toCharArray();
	        int i=0;
	        int num = 0;
	        char ch = '*';
			int[] intArray = new int[(charArray.length)];      // allocates memory for 10 integers
			
			   while(i < charArray.length)
		        {
		        	ch = charArray[i];
					num = toInt(ch);
					//System.out. println(num);
					intArray[i] = num;
		        	i++;
		        }
			   int mult = (1 / ((a*d)-(b*c)));
			   int a1 = (d*mult);
			   int b1 = (-b*mult);
			   int c1 = (-c*mult);
			   int d1 = (a*mult);
			   i=0;
			   while(i < ((intArray.length)-1))
		        {
		        	int x = intArray[i];
		        	int y = intArray[i+1];
		        	
					//System.out. println(x);
					//System.out. println(y);

		        	int newX = (a1*x)+(b1*y);
		        //	System.out.println(newX);
					int newY = (c1*x)+(d1*y);
					//System.out.println(newY);
					char newCharX = '*';
					newCharX = toChar(newX);
					char newCharY = '*';
					newCharY = toChar(newY);
				    finalOutput.append(newCharX);
				    finalOutput.append(newCharY);

				    i = i+2;
		        }
		        System.out.println(finalOutput);

		
	}

	
	public static void encode(String input, int a, int b, int c, int d){
		
		if ((input.length()%2) == 1)
		{
			 StringBuffer st = new StringBuffer (input);
			 st.append(" ");
			 input = st.toString();
		}

	    StringBuffer finalOutput = new StringBuffer ("");		
        char[] charArray = input.toCharArray();
        int i=0;
        int num = 0;
        char ch = '*';
		int[] intArray = new int[(charArray.length)];      // allocates memory for 10 integers
		
		
		
		   while(i < charArray.length)
	        {
	        	ch = charArray[i];
				num = toInt(ch);
				//System.out.println(num);
				intArray[i] = num;
	        	i++;
	        }
	        i = 0;
	       while(i < ((intArray.length)-1))
	        {
	        	int x = intArray[i];
	        	int y = intArray[i+1];
	        	
	        	//System.out. println(x);
				//System.out. println(y);

	        	int newX = (a*x)+(b*y);
	        	//System.out.println(newX);
				int newY = (c*x)+(d*y);
				//System.out.println(newY);
				char newCharX = '*';
				newCharX = toChar(newX);
				//System.out.println(newCharX);
				char newCharY = '*';
				newCharY = toChar(newY);
				//System.out.println("jack" + newCharY);
				
			    finalOutput.append(newCharX);
			    finalOutput.append(newCharY);

			    i = i+2;
	        }
	        System.out.println(finalOutput);

	}
	
	public static char toChar(int num){
		 
		char t = '*';
		while (num > 27)
		{
			num = num%27;
		}
		while (num < 1)
		{
			num = num + 27;
		}
		while (num > 27 && num < 156)
		{
			num = num-27;
		}
		while (num <= 27)
		{
			num = num + 64;
		}
		while (num > 91)
		{
			num = num - 64;
		}
		
		if(num == 91)
		{
			num = 32;
		}
		
		t = (char) num;

		return t;
	}
	
	public static int toInt(char c){
		 
		int num = c;
		while (num > 27)
		{
			num = num - 64;
		}
		while (num < 1)
		{
			num = num + 64;
		}
		if(num == 32)
		{
			num = 27;
		}
	
		return num;
	}
	
	public static void getOutput(String func, String input, int a, int b, int c, int d){
	
		if(func.equals("E"))
		{
			encode(input, a, b, c, d);
		}
		if(func.equals("D"))
		{
			decode(input, a, b, c, d);
		}
	
	}

	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in); // new scanner
		String input = in.nextLine();
		String input2 = in.nextLine();
		String input3 = in.nextLine();
		String input4 = in.nextLine();
		String input5 = in.nextLine();

		////////////////////////////1st line////////////////////////////////
		
		String[] split = input.split(", ");
		  
		String func = split[0];
		String string = split[1];
		int a = Integer.parseInt(split[2]);
		int b = Integer.parseInt(split[3]);
		int c = Integer.parseInt(split[4]);
		int d = Integer.parseInt(split[5]);
    
	
		getOutput(func, string, a, b, c, d);
		
		////////////////////////////2nd line////////////////////////////////

		split = input2.split(", ");
		  
		func = split[0];
		string = split[1];
		a = Integer.parseInt(split[2]);
		b = Integer.parseInt(split[3]);
		c = Integer.parseInt(split[4]);
		d = Integer.parseInt(split[5]);
    
		getOutput(func, string, a, b, c, d);
		
		////////////////////////////3rd line////////////////////////////////

		split = input3.split(", ");
		  
		func = split[0];
		string = split[1];
		a = Integer.parseInt(split[2]);
		b = Integer.parseInt(split[3]);
		c = Integer.parseInt(split[4]);
		d = Integer.parseInt(split[5]);
    
		getOutput(func, string, a, b, c, d);
		
		////////////////////////////4th line////////////////////////////////

		split = input4.split(", ");
		  
		func = split[0];
		string = split[1];
		a = Integer.parseInt(split[2]);
		b = Integer.parseInt(split[3]);
		c = Integer.parseInt(split[4]);
		d = Integer.parseInt(split[5]);
    
		getOutput(func, string, a, b, c, d);
		
		////////////////////////////5th line////////////////////////////////

		split = input5.split(", ");
		  
		func = split[0];
		string = split[1];
		a = Integer.parseInt(split[2]);
		b = Integer.parseInt(split[3]);
		c = Integer.parseInt(split[4]);
		d = Integer.parseInt(split[5]);
    
		getOutput(func, string, a, b, c, d);
		
	}


}
