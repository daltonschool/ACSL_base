package org.dalton.acsl4.quine14;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/******** 
 * Author: Jamie Konigsberg
 * Purpose: Complete ACSL4
 * Date: 4/10/15 
 * Sample Data: 
0, 7, -1
2, 3, 5, 7, -1
1, 3, 4, 5, 6, 7, -1
8, 9, 10, 11, 12, 14, 15, -1
9, 10, 11, 12, 13, 14, 15, -1
	Expected Output:
abc + ABC
AC + aB
A + C
Ab + Ad+ AC
AB + AC + AD 
	Expected Bonus Output:
AC + A --> A
Bc
AC + aB
A + C
A(b + d + C)
A(B + C + D) 

 */
public class ACSL4_Quine14_JK {
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in); 
		for(int i = 0; i<3; i++) //8 Variable Function 
		{
			String[] input = s.nextLine().split(", ");	
			String binaryinput = ""; 
			boolean checker = true; 
			String [] binaryinputarray = new String[input.length-1];
			for(int k = 0; k<input.length-1; k++)
			{
				if(input[k].equals("0"))
				{
					binaryinput = "000";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("1"))
				{
					binaryinput = "001";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("2"))
				{
					binaryinput = "010";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("3"))
				{
					binaryinput = "011";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("4"))
				{
					binaryinput = "100";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("5"))
				{
					binaryinput = "101";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("6"))
				{
					binaryinput = "110";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("7"))
				{
					binaryinput = "111";
					binaryinputarray[k] = binaryinput; 
				}
			}
			combine(binaryinputarray);
			System.out.println();
		}
		for(int j = 0; j<2; j++) //16 Variable Function 
		{
			String[] input = s.nextLine().split(", ");	
			String binaryinput = ""; 
			String [] binaryinputarray = new String[input.length-1];
			for(int k = 0; k<input.length-1; k++)
			{
				if(input[k].equals("0"))
				{
					binaryinput = "0000";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("1"))
				{
					binaryinput = "0001";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("2"))
				{
					binaryinput = "0010";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("3"))
				{
					binaryinput = "0011";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("4"))
				{
					binaryinput = "0100";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("5"))
				{
					binaryinput = "0101";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("6"))
				{
					binaryinput = "0110";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("7"))
				{
					binaryinput = "0111";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("8"))
				{
					binaryinput = "1000";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("9"))
				{
					binaryinput = "1001";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("10"))
				{
					binaryinput = "1010";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("11"))
				{
					binaryinput = "1011";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("12"))
				{
					binaryinput = "1100";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("13"))
				{
					binaryinput = "1101";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("14"))
				{
					binaryinput = "1110";
					binaryinputarray[k] = binaryinput; 
				}
				else if(input[k].equals("15"))
				{
					binaryinput = "1111";
					binaryinputarray[k] = binaryinput; 
				}
			}
			combine(binaryinputarray);
			System.out.println();
		}
	}
	public static boolean cancombine(String [] binaryinputarray) { //can it combine method	
		for(int i=0; i<binaryinputarray.length; i++)
		{
			for(int j = 0; j<binaryinputarray.length; j++)
			{
				boolean check = true;
				int numberofones1 = 0;
				int numberofones2 = 0;
				int placeswrong = 0;
				if(i!= j) {
					for(int k = 0; k<binaryinputarray[i].length(); k++)
					{
						if(binaryinputarray[i].charAt(k) == '1')
						{
							numberofones1++;
						}
						if(binaryinputarray[j].charAt(k) == '1')
						{
							numberofones2++;
						}
						if(binaryinputarray[i].charAt(k) != binaryinputarray[j].charAt(k)) placeswrong++;
						if((binaryinputarray[i].charAt(k) == 'x' && binaryinputarray[j].charAt(k) != 'x') || 
								(binaryinputarray[j].charAt(k) == 'x' && binaryinputarray[i].charAt(k) != 'x'))
							check = false;
					}
					if((numberofones1-numberofones2)<(-2)&&(numberofones1-numberofones2)>2) check = false; 
					if(placeswrong>1) check = false; 
					if(check == true)
					{
						return true; 
					}
				}
			}
		}
		return false;	
	}

	public static int howmanycombos(String[] binaryinputarray)
	{
		int howmany = 0;
		for(int k = 0; k <binaryinputarray.length; k++)
		{
			for(int l = 0; l<binaryinputarray.length; l++)
			{
				if(l>k)
				{
					boolean check = true;
					int numberofones1 = 0;
					int numberofones2 = 0;
					int placeswrong = 0;	
					for(int m = 0; m<binaryinputarray[k].length(); m++)
					{
						if(binaryinputarray[k].charAt(m) == '1')
						{
							numberofones1++;
						}
						if(binaryinputarray[l].charAt(m) == '1')
						{
							numberofones2++;
						}
						if(binaryinputarray[k].charAt(m) != binaryinputarray[l].charAt(m)) placeswrong++;
						if((binaryinputarray[k].charAt(m) == 'x' && binaryinputarray[l].charAt(m) != 'x') || 
								(binaryinputarray[k].charAt(m) == 'x' && binaryinputarray[l].charAt(m) != 'x'))
							check = false;
					}
					if((numberofones1-numberofones2)<(-2)&&(numberofones1-numberofones2)>2) check = false; 
					if(placeswrong>1) check = false; 
					if(check == true) 
					{ 
						howmany++;
					}
				}
			}
		}
		return howmany;
	}

	public static String combine(String [] binaryinputarray)
	{
		int q = 0; 
		String [] simplified = new String[howmanycombos(binaryinputarray)];
		if(howmanycombos(binaryinputarray) == 0)
		{
			translatetoABCD(binaryinputarray);
			for(int d = 0; d<binaryinputarray.length; d++)
			{
				System.out.print(binaryinputarray[d]);
				if(d!=binaryinputarray.length-1) System.out.print(" + ");
			}
		}
		int jicama = binaryinputarray.length;
		for(int i =0; i <binaryinputarray.length; i++)
		{
			for(int j =0; j<binaryinputarray.length; j++)
			{
				if(j>i)
				{
					boolean check = true;
					int numberofones1 = 0;
					int numberofones2 = 0;
					int placeswrong = 0;	
					for(int k = 0; k<binaryinputarray[i].length(); k++)
					{
						if(binaryinputarray[i].charAt(k) == '1')
						{
							numberofones1++;
						}
						if(binaryinputarray[j].charAt(k) == '1')
						{
							numberofones2++;
						}
						if(binaryinputarray[i].charAt(k) != binaryinputarray[j].charAt(k)) placeswrong++;
						if((binaryinputarray[i].charAt(k) == 'x' && binaryinputarray[j].charAt(k) != 'x') || 
								(binaryinputarray[j].charAt(k) == 'x' && binaryinputarray[i].charAt(k) != 'x'))
							check = false;
					}
					if((numberofones1-numberofones2)<(-2)&&(numberofones1-numberofones2)>2) check = false; 
					if(placeswrong>1) check = false; 
					if(check == true) 
					{
						String woof = "";
						for(int k = 0; k<binaryinputarray[i].length(); k++)
						{
							if(binaryinputarray[i].charAt(k) == 120 && binaryinputarray[j].charAt(k) == 120 
									&& binaryinputarray[j].charAt(k) != 0 && binaryinputarray[i].charAt(k) != 0)
							{
								woof = woof + 'x';
							}
							else if(binaryinputarray[i].charAt(k) == 48 && binaryinputarray[j].charAt(k) == 48
									&& binaryinputarray[j].charAt(k) != 0 && binaryinputarray[i].charAt(k) != 0)
							{
								woof = woof + '0'; 
							}
							else if(binaryinputarray[i].charAt(k) == 49 && binaryinputarray[j].charAt(k) == 49
									&& binaryinputarray[j].charAt(k) != 0 && binaryinputarray[i].charAt(k) != 0)
							{
								woof = woof + '1';
							}
							else if((binaryinputarray[i].charAt(k) == 49 && binaryinputarray[j].charAt(k) == 48)
									&& binaryinputarray[j].charAt(k) != 0 && binaryinputarray[i].charAt(k) != 0)
							{
								woof = woof + 'x';	
							}
							else if((binaryinputarray[i].charAt(k) == 48 && binaryinputarray[j].charAt(k) == 49)
									&& binaryinputarray[j].charAt(k) != 0 && binaryinputarray[i].charAt(k) != 0)
							{
								woof = woof + 'x';
							}
						}
						if(woof!= "xxx") {
							simplified[q] = woof;
							q++;
						}

					}
				}
			}
		}
		if(cancombine(simplified) == false) {
			translatetoABCD(simplified);
			for(int d = 0; d<simplified.length; d++)
			{
				System.out.print(simplified[d]);
				if(d!=simplified.length-1) System.out.print(" + ");
			}
		}
		else combine(simplified);
		return null;
	}

	public static String[] translatetoABCD(String [] penguin) { //translate to ABCD form method

		for(int i = 0; i<penguin.length; i++)
		{
			for(int k = 0; k<penguin[i].length(); k++)
			{
				if(k==0 && penguin[i].charAt(0) == 49)
				{
					penguin[i] = penguin[i].replaceFirst("1", "A");
				}
				else if(k == 0 && penguin[i].charAt(0) == 48) 
				{
					penguin[i] = penguin[i].replaceFirst("0", "a");
				}
				else if(k== 1 && penguin[i].charAt(1) == 49) 
				{
					penguin[i] = penguin[i].replaceFirst("1", "B");
				}
				else if(k==1 && penguin[i].charAt(1) == 48)
				{
					penguin[i] = penguin[i].replaceFirst("0", "b");
				}
				else if(k==2 && penguin[i].charAt(2) == 49) 
				{
					penguin[i] = penguin[i].replaceFirst("1", "C");
				}
				else if(k==2 && penguin[i].charAt(2) == 48) 
				{
					penguin[i] = penguin[i].replaceFirst("0", "c");
				}
				else if(k==3 && penguin[i].charAt(3) == 49)
				{
					penguin[i] = penguin[i].replaceFirst("1", "D");
				}
				else if(k == 3 && penguin[i].charAt(3) == 48) 
				{
					penguin[i] = penguin[i].replaceFirst("0", "d");
				}
			}
		}
		for(int i =0; i< penguin.length; i++)
		{
			penguin[i] = penguin[i].replace("x", "");
		}
		return penguin; 
	}
}