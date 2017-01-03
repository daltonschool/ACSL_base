package org.dalton.acsl3.abc15;
import java.util.Scanner;
public class ACSL3_ABC15_C17DW {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true){
			char[][] oa = new char[4][4];
			String str = scan.nextLine();
			String[] in = str.split("[, ]+");
			for(int c = 0 ; c<4 ; c++){
				for(int r = 0 ; r<4 ; r++) oa[c][r]='o';
			}
			for (int i = 0; i < 4; i++) {
				int x = Integer.parseInt(in[i]);
				if(x>25) oa[(x-8)%6][3] = 'x';
				else if(x>19) oa[(x-8)%6][2] = 'x';
				else if(x>13) oa[(x-8)%6][1] = 'x';
				else oa[(x-8)%6][0] = 'x';
			}
			for(int i = in.length-1 ; i>4 ; i--){
				int a = Integer.parseInt(in[i]);
				if(a<6){
					for(int r = 0 ; r<4 ; r++){
						if(oa[a-1][r]!='x'){
							oa[a-1][r]=in[i-1].charAt(0);
							break;
						}
					}	
				}
				else if(31<a){
					for(int r = 3 ; r>=0 ; r--){
						if(oa[a%32][r]!='x'){
							oa[a%32][r]=in[i-1].charAt(0);
							break;
						}
					}	
				}
				else if(a==7||a==13||a==19||a==25){
					for(int c = 0 ; c<4 ; c++){
						if(oa[c][((a-1)/6)-1]!='x'){
							oa[c][((a-1)/6)-1]=in[i-1].charAt(0);
							break;
						}
					}	
				}
				else if(a==12||a==18||a==24||a==30){
					for(int c = 3 ; c>=0 ; c--){
						if(oa[c][(a/6)-2]!='x'){
							oa[c][(a/6)-2]=in[i-1].charAt(0);
							break;
						}
					}	
				}
				i=i-1;
			}
			for(int k = 0 ; k<8;k++){
				for(int r = 0 ; r<4 ; r++){
					for(int c = 0 ; c<4 ; c++){
						if(oa[c][r]=='o'){
							change(oa, r, c);
						}
					}	
				}
			}
			for(int r = 0 ; r<4 ; r++){
				for(int c = 0 ; c<4 ; c++){
					if(oa[c][r]!='x'){
						System.out.print(oa[c][r]);
					}	
				}
			}
			System.out.println();
		}
	}
	public static void change(char[][] output, int r, int c){
		boolean A=false;
		boolean B=false;
		boolean C=false;
		for(int x = 0 ; x<4 ; x++){
			if(output[x][r]=='A') A=true;
			if(output[x][r]=='B') B=true;
			if(output[x][r]=='C') C=true;
		}
		for(int x = 0 ; x<4 ; x++){
			if(output[c][x]=='A') A=true;
			if(output[c][x]=='B') B=true;
			if(output[c][x]=='C') C=true;
		}
		if(A==true&&B==true) output[c][r]='C';
		if(A==true&&C==true) output[c][r]='B';
		if(C==true&&B==true) output[c][r]='A';
	}
}