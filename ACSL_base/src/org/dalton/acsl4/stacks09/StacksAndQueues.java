package org.dalton.acsl4.stacks09;

//School: The Dalton School 
//School Code: 9010
//Name: Benjamin Tsoi
import java.util.Scanner;
public class StacksAndQueues 
{
public static StringBuffer pop(StringBuffer buf, int stackQueue, int operation)
{
	int number = buf.length();
	if(stackQueue==1)
	{
		for(int i=buf.length(); i>number-operation; i--)
		{
			buf.deleteCharAt(i-1);//not really number because it starts at 0, stack it pops from the end of the stack so POP 3 is 3-1 for ABCDE
		}
		//System.out.println("buf after pop: "+buf);
	}
	else if(stackQueue==2)
	{
		for(int i=0; i<operation; i++)
		{
			buf.deleteCharAt(0);
		}
		//System.out.println("buf after pop: "+buf);
	}
	return buf;
}
public static StringBuffer push(StringBuffer buf, int stackQueue, String pushChar)
{	
	if(stackQueue==1)
	{
		buf.append(pushChar);
	}
	else if(stackQueue==2)
	{
		buf.append(pushChar);//doesn't matter what is in that position, just need to create another spot
		/*String now;
		String after;
		for(int i=0; i<buf.length()-1; i++)
		{
			//need to shift everything down by 1, but as of now, all turn into A except for the first spot
			now = Character.toString(buf.charAt(i));
			after = Character.toString(buf.charAt(i+1));
			
			buf.replace(i+1, i+2, now);
			//buf.length() = buf.length()+1;
				
		}*/
		//buf.replace(0, 1, pushChar);
	}
	//System.out.println("buf after push: "+buf);
	return buf;
}
public static StringBuffer dup(StringBuffer buf, int stackQueue, int operation)
{
	//create string or char array that is temporary, find how many items (operation) and then loop through buf and store those items
	//that are chars into the array, then call the push method and loop through the string or char array pushing those into buf
	//String
	//char [] temp = {'A'};
	String pushChar;
	for (int i=0; i<operation; i++)
	{
		//temp[0] = buf.charAt(i);
		pushChar = Character.toString(buf.charAt(i));
		push(buf, stackQueue, pushChar);
	}
	return buf;
}
public static StringBuffer swp(StringBuffer buf, int operation)//swp is the same for stack and queue
{
	//use the previous push, pop, and replace methods after storing the info in temporary variables or arrays/stringbuffer I think stringbuffer is better
	//StringBuffer
	String temp1;
	String temp2;
	for (int i=0; i<operation; i++)
	{
		temp1 = Character.toString(buf.charAt(operation-1-i));
		temp2 = Character.toString(buf.charAt(buf.length()-1-i));
		buf.replace(operation-1-i, operation-i, temp2);
		//System.out.println("here= "+buf);
		buf.replace(buf.length()-1-i, buf.length()-i, temp1);
		//System.out.println("After Swap="+buf);
	}
	return buf;
}
public static int swh(int stackQueue)
{
	if(stackQueue==1)
	{
		stackQueue=2;
	}
	else if(stackQueue==2)
	{
		stackQueue=1;
	}
	return stackQueue;
}
public static StringBuffer crc(StringBuffer buf, int stackQueue, int operation)
{
	//use the previous push, pop, and replace methods after storing the info in temporary variables or arrays/stringbuffer I think stringbuffer is better
	//StringBuffer
	//char [] temp = null;
	int j = 0;
	int tempLength = buf.length();
	if(stackQueue==1)
	{
		//String pushChar;
		//for (int i=tempLength-1; i<operation-1; i--)//i<operation-1 is wrong. tweak just this part I think
		for (int i=0; i<operation; i++)//THIS WORKS
		{
			//temp[0] = buf.charAt(i);
			buf.insert(j, buf.charAt(tempLength-1));
			buf.deleteCharAt(tempLength);
			//j++;
			//pushChar = Character.toString(buf.charAt(i));
			//push(buf, stackQueue, pushChar);
		}
	}
	else if(stackQueue==2)
	{
		for (int i=0; i<operation; i++)//THIS WORKS
		{
			buf.insert(tempLength, buf.charAt(j));
			buf.deleteCharAt(j);
		}
	}
	return buf;
}
public static StringBuffer ins(StringBuffer buf, int stackQueue, int location, String insChar)
{
	if(stackQueue==1)
	{
		buf.insert(buf.length()-location+1, insChar);
	}
	else if (stackQueue==2)
	{
		buf.insert(location-1, insChar);
	}
	return buf;
}
//it does not matter f it is a stack or queue
public static StringBuffer pin(StringBuffer buf, int stackQueue, String pinChar)
{
	buf.insert(0, pinChar);
	return buf;
}
public static StringBuffer srtA(StringBuffer buf, int stackQueue)
{
	String str = buf.toString();
	System.out.println("here");
	char[] content = str.toCharArray();
    java.util.Arrays.sort(content);
    String sorted = new String(content);
	//StringBuffer bufTemp = new StringBuffer(sorted);
    //System.out.println(bufTemp);
    //buf = bufTemp;
    buf = new StringBuffer(sorted);
    System.out.println("buf in method = "+buf);
	return buf;
}
public static StringBuffer srtD(StringBuffer buf, int stackQueue)
{
	String str = buf.toString();
	System.out.println("here2");
	char[] content = str.toCharArray();
    java.util.Arrays.sort(content);
    String sorted = new String(content);
    StringBuffer bufTemp = new StringBuffer(sorted);
    int temp = buf.length()-1;
    String temp2;
    System.out.println(bufTemp);
    for(int i=0; i<buf.length(); i++)
    {
    	temp2 = Character.toString(bufTemp.charAt(temp));
    	buf.replace(i, i+1, temp2);
    	temp--;
    }
    System.out.println(buf);	
	return buf;
}
public static void prt(StringBuffer buf, int stackQueue, int operation)
{
	//System.out.println("operation= "+operation);
	//System.out.println("buf= "+buf);
	int number = buf.length();
	if(stackQueue==1)
	{
		for(int i=number-operation; i<buf.length(); i++)//for(int i=buf.length()-1; i>number-operation-1; i--)//i>number-operation; i--)
		{
			if(i<buf.length()-1)
			{
				System.out.print(buf.charAt(i)+", ");
			}
			else if(i==buf.length()-1)
			{
				System.out.println(buf.charAt(i));
			}
		}
	}
	else if(stackQueue==2)
	{
		for(int i=0; i<operation; i++)
		{
			if(i<operation-1)
			{
				System.out.print(buf.charAt(i)+", ");
			}
			else if(i==operation-1)
			{
				System.out.println(buf.charAt(i));
			}
		}
	}
}
public static void main (String args[])
{
	//String structure [] = new String [5];
	System.out.println("Welcome to Stacks and Queues!");
	/*structure [0] = "A";
	structure [1] = "B";
	structure [2] = "C";
	structure [3] = "D";
	structure [4] = "E";*/
	int stackQueue = 1;
	int operation = 0;//the number and/or after the operation that specifies the location or letter to insert
	
	//loop through the whole string looking for combination, every time it comes up, do num++, and then count the commas and spaces
	//so that they are not counted in the variable loop
	for (int i=0; i<5; i++)
	{
		Scanner in = new Scanner (System.in);
		System.out.println("Please enter S for stack and Q for queue and then the operations separated by commas, Ex. S, POP 1, PSH A, PRT 2");
		//String userInput[] = in.nextLine().split(","&&"");
		String userInput = in.nextLine();
		userInput = userInput.replaceAll(", ", ",");
		userInput = userInput.replaceAll(","," ");
		//System.out.println("userInput: "+userInput);
		String userArray [] = userInput.split(" ");
		String structure = "ABCDE";
		StringBuffer buf = new StringBuffer (structure);
		StringBuffer ins = new StringBuffer (userInput);
		//System.out.println("INS: "+ins);
		/*for(int l=0; l<ins.length(); l++)//no longer necessary to count number of times user types inserts
		{
			//System.out.println("inside "+l+": "+i);
			if (ins.charAt(l)=='I' && ins.charAt(l+1)=='N' && ins.charAt(l+2)=='S')
			{
				insert++;
			}
		}
		//System.out.println("Number of INS: "+insert);
		for(int k=0; k<userArray.length; k++)
		{
			//System.out.println(userArray[k]);		
		}*/
		//System.out.println("Buf: "+buf);
		int loop = userArray.length-1;//doesn't matter if there is an INS that has an extra comma, the for loop will just do one more loop
		//System.out.println("loop: "+loop);
		if(userArray[0].equals("S"))//stack, problem is SWH
		{
			stackQueue = 1;
		}
		else if(userArray[0].equals("Q"))
		{
			stackQueue = 2;
		}
		for(int j=1; j<loop; j++)
		{
			//System.out.println("integer after: "+userArray[j+1]);
			//operation = Integer.parseInt(userArray[j+1]);
			//System.out.println("j= "+j);
			//System.out.println("operation: "+operation);
			if(userArray[j].equals("POP"))
			{
				operation = Integer.parseInt(userArray[j+1]);
				pop(buf, stackQueue, operation);
			}
			else if(userArray[j].equals("PSH"))
			{
				//StringBuffer conv = new StringBuffer(userArray[j+1]);//have no idea why I created this
				//pushChar = String.toCharacter(userArray[j+1]);
				//System.out.println("conv:"+conv);
				//char pushChar = conv.charAt(0);
				String pushChar = userArray[j+1];
				push(buf, stackQueue, pushChar);
			}
			else if(userArray[j].equals("DUP"))
			{
				operation = Integer.parseInt(userArray[j+1]);
				dup(buf, stackQueue, operation);
			}
			else if(userArray[j].equals("SWP"))
			{
				operation = Integer.parseInt(userArray[j+1]);
				swp(buf, operation);
			}
			else if(userArray[j].equals("SWH"))
			{
				//System.out.println("Before switch="+stackQueue);
				if (stackQueue==1)
				{
					stackQueue=2;
				}
				else if (stackQueue==2)
				{
					stackQueue=1;
				}
				
				//swh(stackQueue);
				//System.out.println("After switch="+stackQueue);
			}
			else if(userArray[j].equals("CRC"))
			{
				operation = Integer.parseInt(userArray[j+1]);
				crc(buf, stackQueue, operation);
			}
			else if(userArray[j].equals("INS"))
			{
				int location = Integer.parseInt(userArray[j+1]);
				String insChar = userArray[j+2];
				ins(buf, stackQueue, location, insChar);
			}
			else if(userArray[j].equals("PIN"))
			{
				//StringBuffer conv = new StringBuffer(userArray[j+1]);
				//pushChar = String.toCharacter(userArray[j+1]);
				//System.out.println("conv:"+conv);
				//char pushChar = conv.charAt(0);
				String pinChar = userArray[j+1];
				pin(buf, stackQueue, pinChar);
			}
			else if(userArray[j].equals("SRT"))
			{
				if (userArray[j+1].equals("A") || userArray[j+1].equals("a"))
				{
					//srtA(buf, stackQueue);
					String str = buf.toString();
					char[] content = str.toCharArray();
				    java.util.Arrays.sort(content);
				    String sorted = new String(content);
				    buf = new StringBuffer(sorted);
				    //System.out.println("buf in method = "+buf);
				}
				else if(userArray[j+1].equals("D") || userArray[j+1].equals("d"))
				{
					//srtD(buf, stackQueue);
					String str = buf.toString();
					char[] content = str.toCharArray();
				    java.util.Arrays.sort(content);
				    String sorted = new String(content);
				    StringBuffer bufTemp = new StringBuffer(sorted);
				    int temp = buf.length()-1;
				    String temp2;
				    //System.out.println(bufTemp);
				    for(int l=0; l<buf.length(); l++)
				    {
				    	temp2 = Character.toString(bufTemp.charAt(temp));
				    	buf.replace(l, l+1, temp2);
				    	temp--;
				    }
				    //System.out.println(buf);
				}
			}
			else if(userArray[j].equals("PRT"))
			{
				operation = Integer.parseInt(userArray[j+1]);
				prt(buf, stackQueue, operation);
			}
		}
	}
}
}