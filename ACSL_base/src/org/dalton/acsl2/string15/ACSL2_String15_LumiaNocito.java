package org.dalton.acsl2.string15;
import java.util.Arrays;
import java.util.Scanner;


public class ACSL2_String15_LumiaNocito {

	public static void main(String[] args){

		//get input
		Scanner s= new Scanner(System.in);
		//	s.useDelimiter(", ");

		String numbers = s.nextLine();
		String parts[] = numbers.split(",");
		String number = parts[0];

		double fullnum = Double.parseDouble(number);

		int length = Integer.parseInt(parts[1].trim()); // makes integer
		int decimal = Integer.parseInt(parts[2].trim());
		String afterrounding = null;
		int n=0;
		int lessthan;
		String hashtag="";
		int doesntfit = 0;
		char hashtagg='#';
		StringBuffer output= new StringBuffer();
		int minus=0;




		if(decimal==2){
			afterrounding =	String.format("%.2f", fullnum);

			n=afterrounding.length();
			doesntfit=length-3;
			System.out.println(doesntfit);
		}
		else if(decimal==1){
			afterrounding = String.format("%.1f", fullnum);
			n=afterrounding.length();
			doesntfit=length-2;


		}
		// don't forget your else 

		//if the strings length is equal to the length it needs to be then print
		if (n==length){
			System.out.println(afterrounding);
		}

		else if(n<length){
			lessthan=length-n;

			if (lessthan==1){
				hashtag="#";
				output.append(hashtag + afterrounding);	


			}
			else if (lessthan==2){
				hashtag="##";
				output.append(hashtag + afterrounding);	


			}
			else if (lessthan==3){
				hashtag="###";
				output.append(hashtag + afterrounding);	


			}
			else if (lessthan==4){
				hashtag="####";
				output.append(hashtag + afterrounding);	


			}
			else if (lessthan==5){
				hashtag="#####";
				output.append(hashtag + afterrounding);	


			}
			else if (lessthan==6){
				hashtag="######";
				output.append(hashtag + afterrounding);	


			}
			else if (lessthan==7){
				hashtag="#######";
				output.append(hashtag + afterrounding);	


			}
			else if (lessthan==8){
				hashtag="########";
				output.append(hashtag + afterrounding);	


			}
			else if (lessthan==9){
				hashtag="#########";
				output.append(hashtag + afterrounding);	


			}
			else if (lessthan==10){
				hashtag="##########";
				output.append(hashtag + afterrounding);	


			}
		}

		else if(n>length){


			if (decimal==1){
				char [] repeat = new char[doesntfit];
				Arrays.fill(repeat, hashtagg);
				hashtag += new String(repeat);
				output.append(hashtag + ".#");
			}
			else if (decimal==2){
				char [] repeat = new char[doesntfit];
				Arrays.fill(repeat, hashtagg);
				hashtag += new String(repeat);
				output.append(hashtag + ".##");
			}



		}
		//end brackets
		System.out.println(output);

	}

}
