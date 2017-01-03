package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ACSL1_CHMOD_es {

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
			System.out.println(answer);
			if(fop!=null) fop.write((answer+"\n").getBytes());
		}

		fop.flush();
		fop.close();
		scan.close();
	}

	/**
	 * solve for a specific input
	 * @param s the input
	 * @return the output
	 */
	static String solve(String s) {
		String[] inputsplit =null;
		String[] binary = new String[3];
		String[] letters = new String[3];
		inputsplit = s.split(",[ ]*"); 
		 if (Integer.parseInt(inputsplit[0])==0){
			for (int i = 1; i< inputsplit.length; i++){
				int num = Integer.parseInt(inputsplit[i]);
				if(num == 0){
					binary[i-1] = "000"; 
					letters[i-1]= "---";
				}
				else if(num == 1){
					binary[i-1] = "001"; 
					letters[i-1]= "--x";
				}
				else if(num == 2){
					binary[i-1] = "010"; 
					letters[i-1]= "-w-";
				}
				else if(num == 3){
					binary[i-1] = "011";
					letters[i-1]= "-wx";
				}
				else if(num == 4){
					binary[i-1] = "100"; 
					letters[i-1]= "r--";
				}
				else if(num == 5){
					binary[i-1] = "101"; 
					letters[i-1]= "r-x";
				}
				else if(num == 6){
					binary[i-1] = "110"; 
					letters[i-1]= "rw-";
				}
				else if(num == 7){
					binary[i-1] = "111"; 
					letters[i-1]= "rwx";
				}
				
			}
		}
		 else if (Integer.parseInt(inputsplit[0])==1){
			for (int i = 1; i< inputsplit.length; i++){
				int num = Integer.parseInt(inputsplit[i]);
				if(num == 0){
					binary[i-1] = "000"; 
					letters[i-1]= "---";
					
				}
				else if(num == 1){
					binary[i-1] = "001"; 
					letters[i-1]= "--x";
					if ( i == 1 ){
						letters[i-1]= "--s";
					}
				}
				else if(num == 2){
					binary[i-1] = "010"; 
					letters[i-1]= "-w-";
				}
				else if(num == 3){
					binary[i-1] = "011";
					letters[i-1]= "-wx";
					if ( i == 1){
						letters[i-1]= "-ws";
					}
				}
				else if(num == 4){
					binary[i-1] = "100"; 
					letters[i-1]= "r--";
					
				}
				else if(num == 5){
					binary[i-1] = "101"; 
					letters[i-1]= "r-x";
					if ( i == 1){
						letters[i-1]= "r-s";
					}
				}
				else if(num == 6){
					binary[i-1] = "110"; 
					letters[i-1]= "rw-";
				}
				else if(num == 7){
					binary[i-1] = "111"; 
					letters[i-1]= "rwx";
					if ( i == 1){
						letters[i-1]= "rws";
					}
				}
				
			}
		}
		else if (Integer.parseInt(inputsplit[0])==2){
			for (int i = 1; i< inputsplit.length; i++){
				int num = Integer.parseInt(inputsplit[i]);
				if(num == 0){
					binary[i-1] = "000"; 
					letters[i-1]= "---";
					
				}
				else if(num == 1){
					binary[i-1] = "001"; 
					letters[i-1]= "--x";
					if (i == 2){
						letters[i-1]= "--s";
					}
				}
				else if(num == 2){
					binary[i-1] = "010"; 
					letters[i-1]= "-w-";
				}
				else if(num == 3){
					binary[i-1] = "011";
					letters[i-1]= "-wx";
					if (i == 2){
						letters[i-1]= "-ws";
					}
				}
				else if(num == 4){
					binary[i-1] = "100"; 
					letters[i-1]= "r--";
				}
				else if(num == 5){
					binary[i-1] = "101"; 
					letters[i-1]= "r-x";
					if (i == 2){
						letters[i-1]= "r-s";
					}
				}
				else if(num == 6){
					binary[i-1] = "110"; 
					letters[i-1]= "rw-";
				}
				else if(num == 7){
					binary[i-1] = "111"; 
					letters[i-1]= "rwx";
					if (i == 2){
						letters[i-1]= "rws";
					}
				}
				
			}
		}
		else if (Integer.parseInt(inputsplit[0])==4){
			for (int i = 1; i< inputsplit.length; i++){
				int num = Integer.parseInt(inputsplit[i]);
				if(num == 0){
					binary[i-1] = "000"; 
					letters[i-1]= "---";
					
				}
				else if(num == 1){
					binary[i-1] = "001"; 
					letters[i-1]= "--x";
					if (i == 3){
						letters[i-1]= "--t";
					}
				}
				else if(num == 2){
					binary[i-1] = "010"; 
					letters[i-1]= "-w-";
				}
				else if(num == 3){
					binary[i-1] = "011";
					letters[i-1]= "-wx";
					if (i == 3){
						letters[i-1]= "-wt";
					}
				}
				else if(num == 4){
					binary[i-1] = "100"; 
					letters[i-1]= "r--";
				}
				else if(num == 5){
					binary[i-1] = "101"; 
					letters[i-1]= "r-x";
					if (i == 3){
						letters[i-1]= "r-t";
					}
				}
				else if(num == 6){
					binary[i-1] = "110"; 
					letters[i-1]= "rw-";
				}
				else if(num == 7){
					binary[i-1] = "111"; 
					letters[i-1]= "rwx";
					if (i == 3){
						letters[i-1]= "rwt";
					}
				}				
			}
		}
		s= Arrays.toString(binary);
		s+=" and ";
		s+=Arrays.toString(letters);
		s=s.replace(",", "");  //remove the commas
		s=s.replace("[", "");  //remove the right bracket
		s=s.replace("]", "");  //remove the left bracket
		s=s.trim();           //remove trailing spaces from partially initialized arrays
		return s;
	}
}




