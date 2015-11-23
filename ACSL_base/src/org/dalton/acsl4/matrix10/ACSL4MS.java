package org.dalton.acsl4.matrix10;
/*Marguerite Silverman
 * ACSL 4
 * April 20th, 2011
 */
import java.util.Scanner;
public class ACSL4MS {
	public static void main(String[]args){
		for (int o=0; o<5; o++){
			Scanner scan = new Scanner(System.in);

			String input= scan.nextLine().trim();

			String enter[]= input.split(", ");

			int a = Integer.parseInt(enter[2]);
			int b = Integer.parseInt(enter[3]);
			int c = Integer.parseInt(enter[4]);
			int d = Integer.parseInt(enter[5]);
			//System.out.println(numbers + " " + b );
			StringBuffer converted= new StringBuffer();

			boolean encryption=false;

			if (enter[0].contains("E")) 
			{
				encryption=true;
				//System.out.println("inside");
			}
			String alphabet= "";

			for (int m=1; m<enter.length-4; m++)
			{
				alphabet =alphabet + enter[m];
				//System.out.println("inside here");
			}
			if (alphabet.length()%2==1) 
			{
				alphabet= alphabet + " ";
			}
			int[] num= new int[alphabet.length()];

			for (int i = 0; i < alphabet.length(); i++ )
			{
				char character = alphabet.charAt(i);
				int r = (int) character-64;
				if (character==' ') r=27;
				num[i]= r;
			}
			if (encryption)
			{
				for (int q=1;q<num.length;q++)
				{
					int x=num[q-1]; 
					int y= num[q];
					int p= (a*x) +(b*y);
					p= p%27;
					p= p+64;
					int n= (c*x) +(d*y);
					n= n%27;
					n= n+64;
					if (p==64)
					{
						p=32; 
					}
					if (n==64)
					{
						n=32;
					}
					char tope = (char)p;
					char bottomf= (char)n; 
					converted.append(tope);
					converted.append(bottomf);
					q++;
				}
				System.out.println(converted);
				converted= null;

			}
			if (encryption==false)
			{
				for (int e=1;e<num.length;e++){
					int x=num[e-1]; 
					int y= num[e];
					int z=(1/((a*d)-(b*c))*d);
					int w=(1/((a*d)-(b*c))*(-b));
					int v=(1/((a*d)-(b*c))*(-c)); 
					int u=(1/((a*d)-(b*c))*(a));
					int g= (z*x) +(w*y);
					int h= (v*x) +(u*y);
					if (g<0)
					{
						g= (27-((-g)%27));
					}
					if (h<0) {
						h= (27-((-h)%27));
					}
					g=((g%27)+64); 
					h=((h%27)+64);
					if (g==64) 
					{
						g=32; 
					}
					if (h==64) {
						h=32;
					}
					char topg = (char) g;
					char bottomh = (char) h;  
					converted.append(topg);
					converted.append(bottomh);
					e++;
				}
				System.out.println(converted);
			}
		}
	}

}