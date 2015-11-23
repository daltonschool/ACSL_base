package org.dalton.acsl4.matrix10;
/*Darshan Desai/ASCL 4/ 9075 */
import java.util.Scanner;
public class matrixEncryptionDD {
	static double a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0,x=0,y=0;
	public static void main(String[]args){
		for (int k=0; k<5; k++){
			String inputArray[]= new Scanner(System.in).nextLine().trim().split(", ");
			a = Integer.parseInt(inputArray[inputArray.length-4].trim()); 
			b = Integer.parseInt(inputArray[inputArray.length-3].trim());
			c = Integer.parseInt(inputArray[inputArray.length-2].trim());
			d = Integer.parseInt(inputArray[inputArray.length-1].trim());
			StringBuffer lettersb= new StringBuffer(),converted= new StringBuffer();
			for (int m=1; m<inputArray.length-4; m++)lettersb.append(inputArray[m]);
			if (lettersb.length()%2==1) lettersb.append(" ");  
			int[] inputNumbers= new int[lettersb.length()];
			for (int i = 0; i < lettersb.length(); i++ ){
				char character = lettersb.charAt(i);
				int j = (int) character-64;
				if (character==' ') j=27;
				inputNumbers[i]= j;
			}
			for (int q=1;q<inputNumbers.length;q=q+2){
				x=inputNumbers[q-1]; 
				y= inputNumbers[q];
				if (inputArray[0].contains("E")){
					multiplyEncoder(x,y);   
					final char tope = (char)e, bottomf= (char)f; 
					converted.append(tope).append(bottomf);
				}
				else {
					multiplyDecoder(x,y); 
					final char topg = (char) g, bottomh = (char) h;  
					converted.append(topg).append(bottomh);
				}
			}
			System.out.println(converted);
		}
	}
	public static void multiplyEncoder (double x, double y){
		e= ((((a*x) +(b*y))%27)+64);	
		f= ((((c*x) +(d*y))%27)+64);
		if (e==64) e=32; 
		if (f==64) f=32;
	}
	public static void multiplyDecoder (double x, double y){
		double z=(1/((a*d)-(b*c))*d), w=(1/((a*d)-(b*c))*(-b)), v=(1/((a*d)-(b*c))*(-c)), u=(1/((a*d)-(b*c))*(a));
		g= Math.round((z*x) +(w*y));
		h= Math.round((v*x) +(u*y));
		if (g<0) g= (27-((-g)%27));
		if (h<0) h= (27-((-h)%27));
		g=((g%27)+64); 
		h=((h%27)+64);
		if (g==64) g=32; 
		if (h==64) h=32;
	}
}