package org.dalton.acsl3.isola14;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * @author Emily Cohen
 * description: store the variables in a single boolean array than check around the piece by adding numbers for what is right next to and diagnol from it
 *
 */

public class ACSL3_Isola14_EC {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    for (int round = 0; round<5; round++){
      Scanner scan = new Scanner(System.in);
      String fullinput = scan.nextLine();
      String [] inputstrings = fullinput.split(", ");
      int pblock = Integer.parseInt(inputstrings[0]); //this is the player we are trying to block in
      int pmove = Integer.parseInt(inputstrings[1]); //it is this players turn to move
      int [] needtoremove = spacestoberemoved(fullinput);
      int [] needtoremovefinal = removeElements(needtoremove);
      int [][] paths = possiblepaths(fullinput);
      int [] answer = compare(paths, needtoremovefinal);
      answer = removeElements(answer);
      //print(needtoremovefinal);
      //System.out.println(Arrays.deepToString(paths));
      try {
        if (needtoremovefinal.length==0){
          System.out.println("NONE");
        }
        else if (answer[0] == 100) System.out.println("NONE");
        else print(answer);
      }
      catch ( ArrayIndexOutOfBoundsException e ) {
        System.out.println("NONE");
      }
      catch ( NullPointerException e ) {
        System.out.print("NONE");
      }
    }
  }//main

  /**
   * 
   * @param takes in the String of the input
   * @return an array of spaces that need to removed in order for player 2 to be blocked in
   */
  public static int[] spacestoberemoved(String fullinput){
    String [] inputstrings = fullinput.split(", ");
    int [] input = new int [inputstrings.length];
    //puts the string array into an int array
    for (int k = 0; k<input.length; k++){
      input [k] = Integer.parseInt(inputstrings[k]);
    }
    //fills the array that represents the board spaces all as true to start
    boolean [] spaces = new boolean [50];
    for (int i = 0; i<spaces.length; i++){
      spaces[i] = true;
    }

    //gets the person who were trying to block and the person moving's locations
    int pblock = Integer.parseInt(inputstrings[0]); //this 
    int pmove = Integer.parseInt(inputstrings[1]); //it is this players turn to move


    //registers the blank spaces as false
    for (int j = 2; j<input.length-1; j++){ // length -1 because we don't want the zero
      spaces[input[j]] = false;
    }
    spaces[pblock] = false;
    spaces[pmove] = false;

    /** plan: sort the pieces into middle pieces, or some sort of end, figure out which spaces around them are/aren't removed
      then once you have a list of which pieces need to be removed see if there is a path from pmove to remove it/them
      if there is print out path **/
    String type = "";
    //top left corner
    if (pblock == 43 ) type = "tl";

    //top right corner
    else if (pblock == 49 ) type = "tr";

    //bottom left corner
    else if (pblock == 1 ) type = "bl";

    //bottom right corner
    else if (pblock == 7 ) type = "br";

    //top ends
    else if (pblock == 44 || pblock == 45 ||pblock == 46||pblock == 47||pblock == 48) type = "te";

    //left ends
    else if (pblock == 36 || pblock == 29 ||pblock == 22||pblock == 15||pblock == 8) type = "le";

    //right ends
    else if (pblock == 42 || pblock == 35 ||pblock == 28||pblock == 21||pblock == 14) type = "re";

    //bottom ends
    else if (pblock == 2 || pblock == 3 ||pblock == 4||pblock == 5 ||pblock == 6) type = "be";

    //middle pieces
    else type = "m";

    int [] needtoblock = new int [8]; //8 because that the max spaces a thing touches, these are the spaces that need to be block

    //top left corner
    if (type.equalsIgnoreCase("tl")){
      int a = 0;
      if (spaces[pblock-7] == true) needtoblock[a] = pblock-7; a++; 
      if (spaces[pblock-6] == true) needtoblock[a] = pblock-6; a++;
      if (spaces[pblock+1] == true) needtoblock[a] = pblock+1; a++; 
    }

    //top right corner
    else if (type.equalsIgnoreCase("tr")){
      int a = 0;
      if (spaces[pblock-7] == true) needtoblock[a] = pblock-7; a++; 
      if (spaces[pblock-8] == true) needtoblock[a] = pblock-8; a++;
      if (spaces[pblock-1] == true) needtoblock[a] = pblock-1; a++; 
    }

    //bottom left corner
    else if (type.equalsIgnoreCase("bl")){
      int a = 0;
      if (spaces[pblock+7] == true) needtoblock[a] = pblock+7; a++; 
      if (spaces[pblock+8] == true) needtoblock[a] = pblock+8; a++;
      if (spaces[pblock+1] == true) needtoblock[a] = pblock+1; a++; 
    }

    //bottom right corner
    else if (type.equalsIgnoreCase("br")){
      int a = 0;
      if (spaces[pblock+7] == true) needtoblock[a] = pblock+7; a++; 
      if (spaces[pblock+6] == true) needtoblock[a] = pblock+6; a++;
      if (spaces[pblock-1] == true) needtoblock[a] = pblock-1; a++; 
    }

    //top ends
    else if (type.equalsIgnoreCase("te")){
      int a = 0;
      if (spaces[pblock-6] == true) needtoblock[a] = pblock-6; a++;
      if (spaces[pblock-7] == true) needtoblock[a] = pblock-7; a++; 
      if (spaces[pblock-8] == true) needtoblock[a] = pblock-8; a++;
      if (spaces[pblock-1] == true) needtoblock[a] = pblock-1; a++; 
      if (spaces[pblock+1] == true) needtoblock[a] = pblock+1; a++; 
    }
    //left ends
    else if (type.equalsIgnoreCase("le")){
      int a = 0;
      if (spaces[pblock+7] == true) needtoblock[a] = pblock+7; a++; 
      if (spaces[pblock-7] == true) needtoblock[a] = pblock-7; a++; 
      if (spaces[pblock+8] == true) needtoblock[a] = pblock+8; a++;
      if (spaces[pblock-6] == true) needtoblock[a] = pblock-6; a++;
      if (spaces[pblock+1] == true) needtoblock[a] = pblock+1; a++; 
    }

    //right ends
    else if (type.equalsIgnoreCase("re")){
      int a = 0;
      if (spaces[pblock+7] == true) needtoblock[a] = pblock+7; a++; 
      if (spaces[pblock-7] == true) needtoblock[a] = pblock-7; a++; 
      if (spaces[pblock-8] == true) needtoblock[a] = pblock-8; a++;
      if (spaces[pblock+6] == true) needtoblock[a] = pblock+6; a++;
      if (spaces[pblock-1] == true) needtoblock[a] = pblock-1; a++; 
    }

    //bottom ends
    else if (type.equalsIgnoreCase("be")){
      int a = 0;
      if (spaces[pblock+6] == true) needtoblock[a] = pblock+6; a++; 
      if (spaces[pblock+7] == true) needtoblock[a] = pblock+7; a++; 
      if (spaces[pblock+8] == true) needtoblock[a] = pblock+8; a++;
      if (spaces[pblock-1] == true) needtoblock[a] = pblock-1; a++; 
      if (spaces[pblock+1] == true) needtoblock[a] = pblock+1; a++; 
    }

    //middle pieces
    else if (type.equalsIgnoreCase("m")){
      int a =0;
      if (spaces[pblock+6] == true) needtoblock[a] = pblock+6; a++; 
      if (spaces[pblock+7] == true) needtoblock[a] = pblock+7; a++; 
      if (spaces[pblock+8] == true) needtoblock[a] = pblock+8; a++;
      if (spaces[pblock-6] == true) needtoblock[a] = pblock-6; a++; 
      if (spaces[pblock-7] == true) needtoblock[a] = pblock-7; a++; 
      if (spaces[pblock-8] == true) needtoblock[a] = pblock-8; a++;
      if (spaces[pblock-1] == true) needtoblock[a] = pblock-1; a++; 
      if (spaces[pblock+1] == true) needtoblock[a] = pblock+1; a++; 
    }
    return needtoblock;
  }

  /**
   * 
   * @param the array of spaces that need to be removed (might have some empty spots)
   * @return an array of the spaces that need to removed with no empty spots
   */
  public static int[] removeElements(int[] original) {


    int counter1 = 0;
    //loops to find out how many spots are equivalent to zero
    for (int i = 0; i <original.length; i++){
      if (original[i] != 0) counter1++;
    }

    int[] newarray = new int[counter1];
    int counter2 = 0;
    for (int i = 0; i < original.length; i++)
      if (original[i] != 0){
        newarray[counter2] = original[i];
        counter2++;
      }
    return newarray;
  }

  /**
   * @param print
   * prints an integer array
   */
  public static void print(int[] print){
    for (int i = 0; i<print.length; i++){
      if (i<print.length-1) System.out.print(print[i] + ", ");
      else System.out.print(print[i]);
    }
    System.out.println();
  }

  public static void printdouble(int[][]print, int rows, int columns){
    for (int i = 0; i < rows; i++)//row loop 
    {
      for (int j = 0; j < columns; j++) //column loop
      {
        System.out.print(print[i][j] + "    "); //prints the matrix at row i and column j
      }
      System.out.println();
    }
  }

  /**
   * 
   * @param fullinput takes in the full string of input
   * @return a double int array of all the paths that the player moving can take
   */
  public static int[][] possiblepaths(String fullinput){
    String [] inputstrings = fullinput.split(", ");
    int [] input = new int [inputstrings.length];
    //puts the string array into an int array
    for (int k = 0; k<input.length; k++){
      input [k] = Integer.parseInt(inputstrings[k]);
    }
    //fills the array that represents the board spaces all as true to start
    boolean [] spaces = new boolean [50];
    for (int i = 0; i<spaces.length; i++){
      spaces[i] = true;
    }

    //gets the person who were trying to block and the person moving's locations
    int pblock = Integer.parseInt(inputstrings[0]); //this 
    int pmove = Integer.parseInt(inputstrings[1]); //it is this players turn to move


    //registers the blank spaces as false
    for (int j = 2; j<input.length-1; j++){ // length -1 because we don't want the zero
      spaces[input[j]] = false;
    }
    spaces[pblock] = false;
    spaces[pmove] = false;

    /** plan: sort the pieces into middle pieces, or some sort of end, figure out which spaces around them are/aren't removed
      then once you have a list of which pieces need to be removed see if there is a path from pmove to remove it/them
      if there is print out path **/
    //top left corner
    if (pmove == 43 ){
      int index=0;
      int[][] paths = new int[3][6];
      for (int k = 0; k<3; k++){
        if (k==0) index = -7;
        else if (k==1) index = -6;
        else if (k==2) index = 1;
        for (int j = 1; j< 7; j++){
          if (pmove+j*k <50 && pmove+j*k>0){
            if(spaces[pmove+j*k] ==true){
              paths[k][j] = pmove+j*k;
            }
            else{
              break;
            }
          }
        }//individual paths
      }//which path we are on
    } //top left corner loop

    //top right corner
    else if (pmove == 49 ) {

    }

    //bottom left corner
    else if (pmove == 1 ) {

    }

    //bottom right corner
    else if (pmove == 7 ) {

    }

    //top ends
    else if (pmove == 44 || pmove == 45 ||pmove == 46||pmove == 47||pmove == 48) {
      int index=0;
      int[][] paths = new int[5][6];
      for (int a=0; a <5; a++){
        for (int b = 0; b<6; b++){
          paths[a][b]=0;
        }
      }
      for (int k = 0; k<5; k++){
        if (k==0) index = -7;
        else if (k==1) index = -6;
        else if (k==2) index = +1;
        else if (k==3) index = -8;
        else if (k==4) index = -1;
        for (int j = 1; j< 7; j++){
          if (pmove+j*index <50 && pmove+j*index>0){
            if(spaces[pmove+j*index] ==true){
              paths[k][j-1] = pmove+j*index;
              //if you get to an end
              if (pmove+j*index == 36 || pmove+j*index== 29 ||pmove+j*index== 22||pmove+j*index == 15||pmove+j*index == 8||pmove+j*index == 1) break;
              else if (pmove+j*index == 42 || pmove+j*index == 35 ||pmove+j*index == 28||pmove+j*index == 21||pmove+j*index == 14||pmove+j*index == 7) break;
            }
            else{
              break;
            }
          }
        }//individual paths
      }//which path we are on
      return paths;
    }

    //left ends
    else if (pmove == 36 || pmove == 29 ||pmove == 22||pmove == 15||pmove == 8){
      int index=0;
      int[][] paths = new int[5][6];
      for (int a=0; a <5; a++){
        for (int b = 0; b<6; b++){
          paths[a][b]=0;
        }
      }
      for (int k = 0; k<5; k++){
        if (k==0) index = +7;
        else if (k==1) index = -7;
        else if (k==2) index = +1;
        else if (k==3) index = +8;
        else if (k==4) index = -6;
        for (int j = 1; j< 7; j++){
          if (pmove+j*index <50 && pmove+j*index>0){
            if(spaces[pmove+j*index] ==true){
              paths[k][j-1] = pmove+j*index;
              //if you get to an end
              if (pmove+j*index == 43 || pmove+j*index== 44 ||pmove+j*index== 45||pmove+j*index == 46||pmove+j*index == 47||pmove+j*index == 48||pmove+j*index == 49) break;
              else if (pmove+j*index == 1 || pmove+j*index== 2 ||pmove+j*index== 3||pmove+j*index == 4||pmove+j*index == 5||pmove+j*index == 6||pmove+j*index == 7) break;
            }
            else{
              break;
            }
          }
        }//individual paths
      }//which path we are on
      return paths;
    }

    //right ends
    else if (pmove == 42 || pmove == 35 ||pmove == 28||pmove == 21||pmove == 14) {
      int index=0;
      int[][] paths = new int[5][6];
      for (int a=0; a <5; a++){
        for (int b = 0; b<6; b++){
          paths[a][b]=0;
        }
      }
      for (int k = 0; k<5; k++){
        if (k==0) index = +7;
        else if (k==1) index = -7;
        else if (k==2) index = -1;
        else if (k==3) index = -8;
        else if (k==4) index = +6;
        for (int j = 1; j< 7; j++){
          if (pmove+j*index <50 && pmove+j*index>0){
            if(spaces[pmove+j*index] ==true){
              paths[k][j-1] = pmove+j*index;
              //if you get to an end
              if (pmove+j*index == 43 || pmove+j*index== 44 ||pmove+j*index== 45||pmove+j*index == 46||pmove+j*index == 47||pmove+j*index == 48||pmove+j*index == 49) break;
              else if (pmove+j*index == 1 || pmove+j*index== 2 ||pmove+j*index== 3||pmove+j*index == 4||pmove+j*index == 5||pmove+j*index == 6||pmove+j*index == 7) break;
            }
            else{
              break;
            }
          }
        }//individual paths
      }//which path we are on
      return paths;
    }

    //bottom ends
    else if (pmove == 2 || pmove == 3 ||pmove == 4||pmove == 5 ||pmove == 6){ 
      int index=0;
      int[][] paths = new int[5][6];
      for (int a=0; a <5; a++){
        for (int b = 0; b<6; b++){
          paths[a][b]=0;
        }
      }
      for (int k = 0; k<5; k++){
        if (k==0) index = +7;
        else if (k==1) index = +6;
        else if (k==2) index = +1;
        else if (k==3) index = +8;
        else if (k==4) index = -1;
        for (int j = 1; j< 7; j++){
          if (pmove+j*index <50 && pmove+j*index>0){
            if(spaces[pmove+j*index] ==true){
              paths[k][j-1] = pmove+j*index;
              //if you get to an end
              if (pmove+j*index == 36 || pmove+j*index== 29 ||pmove+j*index== 22||pmove+j*index == 15||pmove+j*index == 8||pmove+j*index == 1) break;
              else if (pmove+j*index == 42 || pmove+j*index == 35 ||pmove+j*index == 28||pmove+j*index == 21||pmove+j*index == 14||pmove+j*index == 7) break;
            }
            else{
              break;
            }
          }
        }//individual paths
      }//which path we are on
      return paths;
    }


    //middle pieces
    else {
      int index=0;
      int[][] paths = new int[8][6];
      for (int a=0; a <8; a++){
        for (int b = 0; b<6; b++){
          paths[a][b]=0;
        }
      }
      for (int k = 0; k<8; k++){
        if (k==0) index = +7;
        else if (k==1) index = -7;
        else if (k==2) index = -1;
        else if (k==3) index = -8;
        else if (k==4) index = +6;
        else if (k==5) index = +1;
        else if (k==6) index = +8;
        else if (k==7) index = -6;
        for (int j = 1; j< 7; j++){
          if (pmove+j*index <50 && pmove+j*index>0){
            if(spaces[pmove+j*index] ==true){
              paths[k][j-1] = pmove+j*index;
              //if you get to an end
              if (pmove+j*index == 43 || pmove+j*index== 44 ||pmove+j*index== 45||pmove+j*index == 46||pmove+j*index == 47||pmove+j*index == 48||pmove+j*index == 49) break;
              else if (pmove+j*index == 1 || pmove+j*index== 2 ||pmove+j*index== 3||pmove+j*index == 4||pmove+j*index == 5||pmove+j*index == 6||pmove+j*index == 7) break;
              else if (pmove+j*index == 36 || pmove+j*index== 29 ||pmove+j*index== 22||pmove+j*index == 15||pmove+j*index == 8||pmove+j*index == 1) break;
              else if (pmove+j*index == 42 || pmove+j*index == 35 ||pmove+j*index == 28||pmove+j*index == 21||pmove+j*index == 14||pmove+j*index == 7) break;
            }
            else{
              break;
            }
          }
        }//individual paths
      }//which path we are on
      return paths;   
    }
    return null;
  }

  /**
   * 
   * @param paths the paths that the player moving can take
   * @param spots the spots that need to be filled
   * @return the correct path in order to fill the spots, if there is none, returns 0
   */
  public static int [] compare (int[][] paths, int[] spots){
    int correctrow = 1000;
    for (int i = 0; i < paths.length; i++){ //rows
      int spotsfilled = 0;
      for (int k = 0; k<paths[0].length;k++){ //columns
        for (int spot = 0; spot<spots.length;spot++){
          if (paths[i][k] == spots[spot]) spotsfilled++;
        }///columns
        if(spotsfilled==spots.length){
          correctrow = i;
          break;
        }
      }//rows
    }
    int [] fake = new int[1];
    fake[0] = 100;
    if (correctrow>100) return fake ;
    else {
      return paths[correctrow];
    }
  }
}//class