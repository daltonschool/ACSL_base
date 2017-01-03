package org.dalton.acsl1.chmod15;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ACSL1_chmod16_CS {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/chmod15";
		Scanner scan;
		FileOutputStream fop = null;

		try{
			scan = new Scanner(new BufferedReader(new FileReader(filein)));
			fop = new FileOutputStream(new File(filein+"-out"));
		} catch(FileNotFoundException e) {
			//switch to regular terminal input
			scan = new Scanner(System.in);
		}

		//main loop:
		while(scan.hasNext()) {
			String answer = solve(scan.nextLine());
//			System.out.println(scan.nextLine());
			System.out.println(answer);
			if(fop!=null) fop.write((answer+"\n").getBytes());
		}

		fop.flush();
		fop.close();
		scan.close();
	}

	static String solve(String s){

		//take in the input in a string
		String input = s; // get the entire line after the prompt 
		String[] numbers = input.split(", ");

		int a[] = new int[4];	

		//take the string and fill the int array
		for (int i = 0; i < 4; i++) {
			a[i] = Integer.parseInt(numbers[i]);
			//			System.out.println("a["+i+"]: "+a[i]);
		}	

		//make answer strings
		String binary = "";
		String letters = "";

		//if no one has privileges - x
		if(a[0]==0)
		{
			for(int i=1; i <4; i++)
			{

				if(a[i]==0)
				{
					binary = binary+"000";
					letters = letters+"---";
				}

				if(a[i]==1)
				{
					binary = binary+"001";
					letters = letters+"--x";
				}

				if(a[i]==2)
				{
					binary = binary+"010";
					letters = letters+"-w-";
				}

				if(a[i]==3)
				{
					binary = binary+"011";
					letters = letters+"-wx";
				}

				if(a[i]==4)
				{
					binary = binary+"100";
					letters = letters+"r--";
				}

				if(a[i]==5)
				{
					binary = binary+"101";
					letters = letters+"r-x";
				}

				if(a[i]==6)
				{
					binary = binary+"110";
					letters = letters+"rw-";
				}

				if(a[i]==7)
				{
					binary = binary+"111";
					letters = letters+"rwx";
				}

				if(i<3){
					letters = letters+" ";
					binary = binary+" ";
				}

			}
		}

		//if there are privileges for owner or group
		if(a[0]==1||a[0]==2)
		{

			for(int i=1; i <4; i++)
			{
				//if s should be used
				if(i==1&a[0]==1||i==2&a[0]==2)
				{
					if(a[i]==0)
					{
						binary = binary+"000";
						letters = letters+"---";
					}

					if(a[i]==1)
					{
						binary = binary+"001";
						letters = letters+"--s";
					}

					if(a[i]==2)
					{
						binary = binary+"010";
						letters = letters+"-w-";
					}

					if(a[i]==3)
					{
						binary = binary+"011";
						letters = letters+"-ws";
					}

					if(a[i]==4)
					{
						binary = binary+"100";
						letters = letters+"r--";
					}

					if(a[i]==5)
					{
						binary = binary+"101";
						letters = letters+"r-s";
					}

					if(a[i]==6)
					{
						binary = binary+"110";
						letters = letters+"rw-";
					}

					if(a[i]==7)
					{
						binary = binary+"111";
						letters = letters+"rws";
					}
				}//end of s==true

				//if s isn't being used
				else{
					if(a[i]==0)
					{
						binary = binary+"000";
						letters = letters+"---";
					}

					if(a[i]==1)
					{
						binary = binary+"001";
						letters = letters+"--x";
					}

					if(a[i]==2)
					{
						binary = binary+"010";
						letters = letters+"-w-";
					}

					if(a[i]==3)
					{
						binary = binary+"011";
						letters = letters+"-wx";
					}

					if(a[i]==4)
					{
						binary = binary+"100";
						letters = letters+"r--";
					}

					if(a[i]==5)
					{
						binary = binary+"101";
						letters = letters+"r-x";
					}

					if(a[i]==6)
					{
						binary = binary+"110";
						letters = letters+"rw-";
					}

					if(a[i]==7)
					{
						binary = binary+"111";
						letters = letters+"rwx";
					}
					
				}//end of i (filling up binary and letters) loop

				if(i<3){
					letters = letters+" ";
					binary = binary+" ";
				}

			}
		}

		//if others class has privileges
		if(a[0]==4)
		{
			boolean x = false;
			for(int i=1; i<4; i++)
			{
				//if x shouldn't been used
				if(i==3)
				{
					if(a[i]==0)
					{
						binary = binary+"000";
						letters = letters+"---";
					}

					if(a[i]==1)
					{
						binary = binary+"001";
						letters = letters+"--t";
					}

					if(a[i]==2)
					{
						binary = binary+"010";
						letters = letters+"-w-";
					}

					if(a[i]==3)
					{
						binary = binary+"011";
						letters = letters+"-wt";
					}

					if(a[i]==4)
					{
						binary = binary+"100";
						letters = letters+"r--";
					}

					if(a[i]==5)
					{
						binary = binary+"101";
						letters = letters+"r-t";
					}

					if(a[i]==6)
					{
						binary = binary+"110";
						letters = letters+"rw-";
					}

					if(a[i]==7)
					{
						binary = binary+"111";
						letters = letters+"rwt";
					}	
				}//end of true x

				//if x should be used
				if(i!=3)
				{
					if(a[i]==0)
					{
						binary = binary+"000";
						letters = letters+"---";
					}

					if(a[i]==1)
					{
						binary = binary+"001";
						letters = letters+"--x";
					}

					if(a[i]==2)
					{
						binary = binary+"010";
						letters = letters+"-w-";
					}

					if(a[i]==3)
					{
						binary = binary+"011";
						letters = letters+"-wx";
					}

					if(a[i]==4)
					{
						binary = binary+"100";
						letters = letters+"r--";
					}

					if(a[i]==5)
					{
						binary = binary+"101";
						letters = letters+"r-x";
					}

					if(a[i]==6)
					{
						binary = binary+"110";
						letters = letters+"rw-";
					}

					if(a[i]==7)
					{
						binary = binary+"111";
						letters = letters+"rwx";
					}	
				}//end of false x

				if(i<3){
					letters = letters+" ";
					binary = binary+" ";
				}

			}//end of filling

		}


		return(binary + " and "+letters);
	}
}
