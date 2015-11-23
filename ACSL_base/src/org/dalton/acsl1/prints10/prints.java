package org.dalton.acsl1.prints10;

/*
David Mandelbaum
The Dalton School
Code: 9075
*/


import java.util.Scanner;

class prints{

    public static void main(String[] args){
    
    Scanner in = new Scanner(System.in);
    int k = 0;
    for(k=0;k<5;k++){
    String input = in.nextLine();
    int[] numz = new int[2];

    numz[0] = Integer.parseInt(input.split(", ")[0]);
    numz[1] = Integer.parseInt(input.split(", ")[1]);
    numz[0] = numz[0] - 1;
    numz[1] = numz[1] - 1;
    //convert numbers to binary
    String bin1 = Integer.toBinaryString(numz[0]);
    String bin2 = Integer.toBinaryString(numz[1]);

    int i = 0;
    int j = 0;
    boolean[] digits_1 = new boolean[5];
    boolean[] digits_2 = new boolean[5];

    for(i=bin1.length()-1;i>=0;i--){
	if(bin1.substring(i,i+1).equals("1")){
	    digits_1[j] = true;
	}
	else{
	    digits_1[j] = false;
	}
	j++;
    }

    j=0;
    for(i=bin2.length()-1;i>=0;i--){
        if(bin2.substring(i,i+1).equals("1")){
            digits_2[j] = true;
        }
        else{
            digits_2[j] = false;
        }
        j++;
    }

    int[] nums = new int[10];
    i = 0;
    if(digits_1[0]){
	nums[i] = 10;
	i++;
    }
    if(digits_2[0]){
	nums[i] = 9;
	i++;
    }
    if(digits_1[1]){
	nums[i] = 8;
	i++;
    }
    if(digits_2[1]){
	nums[i] = 7;
	i++;
    }
    if(digits_1[2]){
	nums[i] = 6;
	i++;
    }
    if(digits_2[2]){
	nums[i] = 5;
	i++;
    }
    if(digits_1[3]){
	nums[i] = 4;
	i++;
    }
    if(digits_2[3]){
	nums[i] = 3;
	i++;
    }
    if(digits_1[4]){
	nums[i] = 2;
	i++;
    }
    if(digits_2[4]){
	nums[i] = 1;
	i++;
    }

    j=0;
    if(i==0){
	System.out.println("None");
    }
    else{
    for(j=0;j<i;j++){
	if(j == (i-1)){
	    System.out.println(nums[j]);
	}
	else
	    System.out.print(nums[j] + ", ");
    }
    }
    }
    }
}