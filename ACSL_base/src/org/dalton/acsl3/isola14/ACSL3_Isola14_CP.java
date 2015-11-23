package org.dalton.acsl3.isola14;
import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ACSL3_Isola14_CP {
  public static void main(String args[]){
    Scanner input = new Scanner(System.in);

    for(int i = 0; i < 5; i++){
    String line = input.nextLine();
    String[] array = line.split(", ");
    String[][] board = setupboard(array);
    
    boolean swag = vertical(board);
    boolean swag2 = horizontal(board);
    boolean swag3 = diagnal(board);
    if(swag == false && swag2 == false && swag3 == false){
      System.out.println("NONE");
    }
    }
       
  }//end of main
  
  public static void printboard(String[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }
  
  public static String[][] setupboard(String[] array) {
    String[][] board = new String[9][9];
    int plus = Integer.parseInt(array[0]);
    int xlocation = Integer.parseInt(array[1]);
    
    for(int i = 0; i < 2; i++){
     if(i == 0){ 
     if(Integer.parseInt(array[i])%7 == 0) {
       board[Integer.parseInt(array[i])/7][7] = "+";
     }
     else {
       board[Integer.parseInt(array[i])/7 + 1][Integer.parseInt(array[i])%7] = "+";
       
       
     }
     }
     else {
       if(Integer.parseInt(array[i])%7 == 0) {
         board[Integer.parseInt(array[i])/7][7] = "X";
       }
       else {
         board[Integer.parseInt(array[i])/7 + 1][Integer.parseInt(array[i])%7] = "X";
         
       }
     }
    }
   
    
    for(int i = 2; i < array.length; i++) {
      int counter = Integer.parseInt(array[i]);
      if(counter%7 == 0) {
        board[counter/7][7] = "x";
      }
      else {
        board[counter/7 + 1][counter%7] = "x";
      }
           
    }//end of for loop
    for(int i = 0; i < board.length; i++){
      board[0][i] = "x";
      board[i][0] = "x";
      board[i][8] = "x";
      board[8][i] = "x";
    }
    
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){
        if(board[i][j] != "x" && board[i][j] != "X" && board[i][j] != "+") {
          board[i][j] = "0";
        }
      }
    }
    
    
    
    return board;
  }//end of setupboard
  
  public static int[] findplus(String board[][]) {
    int[] coords = new int[2];
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board.length; j++) {
        if(board[i][j].equals("+")) {
          coords[0] = i;
          coords[1] = j;
        }
      }
    }
    return coords;
  }
  
  public static int[] findx(String board[][]) {
    int[] coords = new int[2];
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board.length; j++) {
        if(board[i][j].equals("X")) {
          coords[0] = i;
          coords[1] = j;
          
        }
      }
    }
    return coords;
  }
  
  public static boolean isblocking(String board[][]){
    int[] coords = findplus(board);
    int x = coords[0];
    int y = coords[1];
    
    if(board[x+1][y].equalsIgnoreCase("x") && board[x+1][y-1].equalsIgnoreCase("x") && board[coords[0]+1][coords[1]+1].equalsIgnoreCase("x") && board[coords[0]][coords[1]+1].equalsIgnoreCase("x") && board[coords[0]][coords[1]-1].equalsIgnoreCase("x") && board[coords[0]-1][coords[1]+1].equalsIgnoreCase("x") && board[coords[0]-1][coords[1]].equalsIgnoreCase("X") && board[coords[0]-1][coords[1]-1].equalsIgnoreCase("X")) {
      return true;
    }
    else {
      return false;
    }
  }
  
  public static boolean vertical(String board[][]) {
    
    int x = findx(board)[0];
    
    int y = findx(board)[1];
    String[][] newboard = new String[9][9];
    for(int i = 0; i < board.length; i ++) {
      for(int j = 0; j < board.length; j++) {
        newboard[i][j] = board[i][j];
      }
    }
    
    
    int[] results = new int[] {0,0,0,0,0,0,0};
    int w = 0;
    while(true) {
      
      if(newboard[x+1][y].equals("0")) {
        results[w] = x*7 + y;
        newboard[x+1][y] = "x";
        w++;
        x = x+1;
      }
      else {
        break;
      }
    }
    String finished = "";
    if(isblocking(newboard) == true) {
      for(int i = 0; i < results.length; i++) {
        if(results[i] != 0) {
          finished = finished + results[i] + ", ";
        }
      }
      
    }
    else { //this is going downwards
      w = 0;
      
      int[] resultstwo = new int[] {0,0,0,0,0,0,0};
      for(int i = 0; i < board.length; i ++) {
        for(int j = 0; j < board.length; j++) {
          newboard[i][j] = board[i][j];
        }
      }
      x = findx(newboard)[0];
      y = findx(newboard)[1];
      while(true) {
        
        if(x != 0 && newboard[x-1][y].equals("0")) {
          resultstwo[w] = x*7 - 14 + y;
          newboard[x-1][y] = "x";
          w++;
          x = x-1;
        }
        else {
          break;
        }
      }
      if(isblocking(newboard) == true) {
        for(int i = 0; i < resultstwo.length; i++) {
          if(resultstwo[i] != 0) {
            finished = finished + resultstwo[i] + ", ";
            
          }
        }
      }
    }
    
    if(finished.length() == 0){
      return false;
      
    }
    else {
      System.out.println(finished.substring(0, finished.length() - 2));
      return true;
    }
  }
  
  public static boolean horizontal(String board[][]) { //fix horizontal for input 2 on sheet

    int x = findx(board)[0];
    int y = findx(board)[1];
    String[][] newboard = new String[9][9];
    for(int i = 0; i < board.length; i ++) {
      for(int j = 0; j < board.length; j++) {
        newboard[i][j] = board[i][j];
      }
    }//end of double for loop
    int[] results = new int[] {0,0,0,0,0,0,0};
    int w = 0;
    while(true) {
      
      if(newboard[x][y+1].equals("0")) {
        results[w] = (x-1)*7 + (y+1);
        newboard[x][y+1] = "x";
        w++;
        y = y+1;
      }
      else {
        break;
      }
    }
    String finished = "";
    if(isblocking(newboard) == true) {

      for(int i = 0; i < results.length; i++) {
        if(results[i] != 0) {
          finished = finished + results[i] + ", ";
          
        }
      }
      
    }
    else { //this is going downwards
      int[] resultstwo = new int[] {0,0,0,0,0,0,0};
      for(int i = 0; i < board.length; i ++) {
        for(int j = 0; j < board.length; j++) {
          newboard[i][j] = board[i][j];
        }
      }
      y = findx(board)[1];
      w = 0;
      x = findx(board)[0];
      while(true) {
        
        if(y != 0 && newboard[x][y-1].equals("0")) {
          resultstwo[w] = (x-1)*7 + (y-1);
          newboard[x][y-1] = "x";
          w++;
          y = y-1;
        }
        else {
          break;
        }
      }
      if(isblocking(newboard) == true) {
        for(int i = 0; i < resultstwo.length; i++) {
          if(resultstwo[i] != 0) {
            finished = finished + resultstwo[i] + ", ";
            
          }
        }
      }
    }
    if(finished.length() == 0) {
      return false;
    }
    else {
      System.out.println(finished.substring(0, finished.length() - 2));
      return true;
    }
    
  }
  
  public static void fillboard(String board[][], String newboard[][]){
    for(int i = 0; i < board.length; i ++) {
      for(int j = 0; j < board.length; j++) {
        newboard[i][j] = board[i][j];
      }
    }//end of double for loop
  }
  
  public static boolean diagnal(String board[][]){
    int x = findx(board)[0];
    int y = findx(board)[1];
    String finished = "";
    String[][] newboard = new String[9][9];
    fillboard(board, newboard);
    int[] results = new int[] {0,0,0,0,0,0,0};
    int w = 0;
    
    while(true) {
      if(newboard[x+1][y+1].equals("0")) {
        results[w] = (x)*7 + (y+1);
        newboard[x+1][y+1] = "x";
        w++; y = y+1; x = x+1;
      }
      else {
        break;
      }
    }
    if(isblocking(newboard) == true) {
      for(int i = 0; i < results.length; i++) {
        if(results[i] != 0) {
          finished = finished + results[i] + ", ";
          
        }    
      }//end of for
    }//end of if statement 
    else {
      x = findx(newboard)[0];
      y = findx(newboard)[1];
      int[] resultstwo = {0,0,0,0,0,0,0};
      fillboard(board,newboard);
      while(true) {
        if(newboard[x+1][y-1].equals("0")) {
          resultstwo[w] = (x)*7 + (y-1);
          newboard[x+1][y-1] = "x";
          w++; y = y-1; x = x+1;
        }
        else {
          break;
        }
      }
      if(isblocking(newboard) == true) {
        for(int i = 0; i < resultstwo.length; i++) {
          if(resultstwo[i] != 0) {
            finished = finished + resultstwo[i] + ", ";
            
          }    
        }//end of for
      }//end of if statement
      else {
        x = findx(newboard)[0];
        y = findx(newboard)[1];
        int[] resultsthree = {0,0,0,0,0,0,0};
        fillboard(board,newboard);
        while(true) {
          if(newboard[x-1][y-1].equals("0")) {
            resultsthree[w] = (x-2)*7 + (y-1);
            newboard[x-1][y-1] = "x";
            w++; y = y-1; x = x-1;
          }
          else {
            break;
          }
        }
        if(isblocking(newboard) == true) {
          for(int i = 0; i < resultsthree.length; i++) {
            if(resultsthree[i] != 0) {
              finished = finished + resultsthree[i] + ", ";
              
            }    
          }//end of for
        }//end of if statement
        else { 
          x = findx(newboard)[0];
          y = findx(newboard)[1];
          int[] resultsfour = {0,0,0,0,0,0,0};
          fillboard(board,newboard);
          while(true) {
            if(newboard[x-1][y+1].equals("0")) {
              resultsfour[w] = (x-2)*7 + (y+1);
              newboard[x-1][y+1] = "x";
              w++; y = y+1; x = x-1;
            }
            else {
              break;
            }
          }
          if(isblocking(newboard) == true) {
            for(int i = 0; i < resultsfour.length; i++) {
              if(resultsfour[i] != 0) {
                finished = finished + resultsfour[i] + ", ";
                
              }    
            }//end of for
          }//end of if statement
        }//end of else3
      }//end of else2
      
    }//end of else1
    
   
    
    
    //seeing if 
    if(finished.length() == 0) {
      return false;
    }
    else{
      System.out.println(finished.substring(0, finished.length()-2));
      return true;
    }
    
  }
   
  
}//end of class
