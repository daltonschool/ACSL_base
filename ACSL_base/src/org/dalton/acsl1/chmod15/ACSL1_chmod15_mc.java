package org.dalton.acsl1.chmod15;
/*
 * Author: Marnie Conway
 * 
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Arrays; 
public class ACSL1_chmod15_mc {
	public static void main(String[] args){
		for(int x=0; x<5; x++){

			Scanner scan = new Scanner(System.in);
			String input1 = scan.nextLine();
			String[] inputs = input1.split(", ");
			String owner="";
			String groupy ="";
			String othery ="";
			String nice = "";

			// convert strings to ints
//
//			String special = inputs[0];
//
//			if(special.equals("1")){
//				owner="1";	
//			}
//			if(special.equals("0")){
//				owner="0";	
//			}
//			if(special.equals("2")){
//				groupy="2";	
//			}
//			if(special.equals(4)){
//				othery="4";
//			}


			//System.out.println("owner" + owner);

		//	int special1 = Integer.parseInt(special);
			String one= "11";
			String two= "0";
			String three= "0";

			String finalbinaryu= "";
			String finalbinaryg= "";
			String finalbinaryo= "";


			//user
			String user = inputs[1];
			int user1 = Integer.parseInt(user);
			//System.out.println("user1: "+ user1);

			String binaryuser;

			if(user1==0){
				binaryuser="000";
				finalbinaryu=binaryuser;
			}

			binaryuser=Integer.toBinaryString(user1);

			//	System.out.println(binaryuser + "is binary user!");

			if(binaryuser.equals("1")){
				String binaryuser1 = binaryuser.concat(one);

				finalbinaryu=binaryuser1;			
			}		
			if(binaryuser.equals("10")){
				String binaryuser2 = two.concat(binaryuser);
				finalbinaryu=binaryuser2;

			}		
			if(binaryuser.equals("11")){
				String binaryuser3 = three.concat(binaryuser);
				finalbinaryu=binaryuser3;
			}
			if(binaryuser.equals("100")){
				finalbinaryu=binaryuser;	
			}
			if(binaryuser.equals("101")){
				finalbinaryu=binaryuser;	
			}
			if(binaryuser.equals("110")){
				finalbinaryu=binaryuser;	
			}
			if(binaryuser.equals("111")){
				finalbinaryu=binaryuser;	
			}


			//	System.out.println("finalbinaryu  "+ finalbinaryu);

			String group = inputs[2];
			int group1 = Integer.parseInt(group);
			//	System.out.println("user1: "+ user1);

			String binarygroup;
			binarygroup=Integer.toBinaryString(group1);

			if(group1==0){
				binarygroup="000";
				finalbinaryg=binaryuser;
			}

			//	System.out.println(binaryuser + "is binary user!");

			if(binarygroup.equals("1")){
				String binarygroup1 = binarygroup.concat(one);

				finalbinaryg=binarygroup1;			
			}		
			if(binarygroup.equals("10")){
				String binarygroup2 = two.concat(binarygroup);
				finalbinaryg=binarygroup2;

			}		
			if(binarygroup.equals("11")){
				String binarygroup3 = three.concat(binarygroup);
				finalbinaryg=binarygroup3;
			}
			if(binarygroup.equals("100")){
				finalbinaryg=binarygroup;	
			}
			if(binarygroup.equals("101")){
				finalbinaryg=binarygroup;	
			}
			if(binarygroup.equals("110")){
				finalbinaryg=binarygroup;	
			}
			if(binarygroup.equals("111")){
				finalbinaryg=binarygroup;	
			}

			//System.out.println("finalbinaryg  "+ finalbinaryg);

			String other = inputs[3];
			int other1 = Integer.parseInt(other);
			String binaryother="";
			binaryother=Integer.toBinaryString(other1);

			if(other1==0){
				binaryother="000";
				finalbinaryo=binaryuser;
			}
			//	System.out.println("user1: "+ user1);



			if(binaryother.equals("1")){
				String binaryother1 = binaryother.concat(one);

				finalbinaryo=binaryother1;			
			}		
			if(binaryother.equals("10")){
				String binaryother2 = two.concat(binaryother);
				finalbinaryo=binaryother2;

			}		
			if(binaryother.equals("11")){
				String binaryother3 = three.concat(binaryother);
				finalbinaryo=binaryother3;
			}
			if(binaryother.equals("100")){
				finalbinaryo=binaryother;	
			}
			if(binaryother.equals("101")){
				finalbinaryo=binaryother;	
			}
			if(binaryother.equals("110")){
				finalbinaryo=binaryother;	
			}
			if(binaryother.equals("111")){
				finalbinaryo=binaryother;	
			}

			//	System.out.println("finalbinaryo  "+ finalbinaryo);


			String[] userarr = finalbinaryu.split("");
			//	System.out.println(Arrays.toString(userarr));

			String[] grouparr = finalbinaryg.split("");
			//	System.out.println(Arrays.toString(grouparr));

			String[] otherarr = finalbinaryo.split("");
			//		System.out.println(Arrays.toString(otherarr));

	//		String binaryspecial = Integer.toBinaryString(special1);	
			String userper = "";
			String userper1 = "";
			String userper2 = "";
			String usernew ="";

			if(userarr[0].equals("1")){
				userper="r";
			}		
			if(userarr[0].equals("0")){
				userper="-";
			}
			if(userarr[1].equals("1")){
				userper1= userper+ "w";
			}
			if(userarr[1].equals("0")){
				userper1= userper + "-";
			}

			if(userarr[2].equals("1")){
				userper2= userper1 + "x";
			}				
			else userper2=userper1 + "-";

			//		if(userarr[2].equals("1") && owner.equals("1")){
			//			String strOutput1 = strOutput .replace("as soon as possible","asap");
			//		}





			String groupper = "";
			String groupper1 = "";
			String groupper2 = "";

			if(grouparr[0].equals("1")){
				groupper="r";
			}
			else groupper ="-";

			if(grouparr[1].equals("1")){
				groupper1= groupper+ "w";
			}
			else groupper1= groupper + "-";

			if(grouparr[2].equals("1")){
				groupper2= groupper1 + "x";
			}
			else groupper2=groupper1 + "-";

			String otherper = "";
			String otherper1 = "";
			String otherper2 = "";

			if(otherarr[0].equals("1")){
				otherper="r";
			}
			else otherper ="-";

			if(otherarr[1].equals("1")){
				otherper1= otherper+ "w";
			}
			else otherper1= otherper + "-";

			if(otherarr[2].equals("1")){
				otherper2= otherper1 + "x";
			}
			else otherper2=otherper1 + "-";

			System.out.println(finalbinaryu +" " + finalbinaryg+ " " + finalbinaryo +" and " + userper2 + " "+  groupper2 +" "+ otherper2 );

		}
	} //main
} //class
