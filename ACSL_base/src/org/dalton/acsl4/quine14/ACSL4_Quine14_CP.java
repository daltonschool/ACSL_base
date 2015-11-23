package org.dalton.acsl4.quine14;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;

public class ACSL4_Quine14_CP {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    for(int i = 0; i < 5; i++) {
      String[] line = input.nextLine().split(", ");
      
     String binary = "01x";
     String bool = toBoolean(binary);
     //System.out.println(bool);
      
      if(i < 3){ //what to do for first 3 inputs
      String[] j = tobinary(line, 3);
      String[] pairs = findpairs(j, 0);
      //print(pairs);
      
      if(pairs.length > 1){
        
      pairs = findpairs(pairs,1);
      //print(pairs);
      if(pairs.length == 0){
        pairs = findpairs(j,0);
        
      }
      
      }//end of if 
      String[] response = new String[pairs.length];
      for(int w = 0; w < pairs.length; w++) {
        if(pairs[w] != null) {
       
            response[w] = toBoolean(pairs[w]);
         
          
        }
        
      }//end of for loop
     
      
      Arrays.sort(response);
      Set<String> mySet = new HashSet<String>(Arrays.asList(response));
      String[] swag = mySet.toArray(new String[mySet.size()]);
      print(swag);
      
      }// end of 3 digit binary inputs
      
      
      else{ //what to do for last two inputs
        String[] j = tobinary(line, 4);
        //print(j);
        String[] pairs = findpairs(j,0);
        //print(pairs);
        
        if(pairs.length > 1){
        
          pairs = findpairs(pairs,1);
          //print(pairs);
          if(pairs.length == 0){
            pairs = findpairs(j,0);
          }
          else if(pairs.length > 1){
            pairs = findpairs(pairs,1);
            //print(pairs);
            if(pairs.length == 0){
              pairs = findpairs(j,0);
              pairs = findpairs(pairs,1);
            }
            
          }
        
        }//end of if 
        
        
        String[] response = new String[pairs.length];
        for(int w = 0; w < pairs.length; w++) {
          if(pairs[w] != null) {
         
              response[w] = toBoolean(pairs[w]);
           
            
          }
          
        }//end of for loop
        Arrays.sort(response);
        Set<String> mySet = new HashSet<String>(Arrays.asList(response));
        String[] swag = mySet.toArray(new String[mySet.size()]);
        Arrays.sort(swag);
        print(swag);
        
        
        
      }
      
      
     
      
      
     
    }
  }
  
  public static String[] tobinary(String[] line, int length) {
    int[] numbers = new int[line.length-1];
    for(int i = 0; i < line.length - 1; i++){
      numbers[i] = Integer.parseInt(line[i]);
       line[i] = Integer.toBinaryString(numbers[i]);
       while(line[i].length() < length) {
         line[i] = "0" + line[i];
       }
    }
    
    
    return line;
  }
  
  
  
  
  public static String[] findpairs(String[] line, int simplify) {
    String[] pairs = new String[line.length*(line.length-1)/2];
    int x = 0;
    int count = 0;
    int[] good = new int[line.length - 1];
    for(int i = 0; i < line.length - 1; i++) {
      char[] array = line[i].toCharArray();
      
      for(int j = i+1; j < line.length -1; j++) {
        char[] array2 = line[j].toCharArray();
        
        
        for(int k = 0; k < array.length; k++) {
          
          if(array[k] != array2[k]) {
            count = count + 1;
            array2[k] = 'x';
          }
          
        }
        
        if(count == 1) {
          for(int w = 0; w < array2.length; w++){
            if(w == 0){
            pairs[x] = Character.toString(array2[w]);
            }
            else{
              pairs[x] = pairs[x] + array2[w];
            } 
          }
          x++;
          
          good[i]++;
          good[j]++;
          
        }
        
        
        count = 0;
        
      }
      
      //this is what im adding in 
      /**
      if(good[i] == 0) {
        for(int w = 0; w < array.length; w++){
          if(w == 0){
          pairs[x] = Character.toString(array[w]);
          }
          else{
            pairs[x] = pairs[x] + array[w];
          }
          
        }
        x++;
      }
      **/
      //good = 0;
      
      
      
    }
    int laughing = 0;
    for(int i = 0; i < pairs.length; i++) {
      if(pairs[i] != null) {
        laughing ++;
      }
    }
    String[] organized = new String[laughing];
    for(int i = 0; i < organized.length; i++) {
      organized[i] = pairs[i];
      
    }
    return organized;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * Takes the final binary expression and turns it into a boolean
   * @param binary
   * @return
   */
  public static String toBoolean(String binary) {
    char[] array = binary.toCharArray();
    
    
    String bool = "";
    for(int i = 0; i < array.length; i++){
      if(array[i] == '0') {
        int cool = (i + 97);
        char ch = (char) cool;
        bool = bool + ch;
      }
      else if(array[i] == '1') {
        int cool = (i + 65);
        char ch = (char) cool;
        bool = bool + ch;
      }
    }
    
    return bool;  
  }
  
  public static void print(String[] array) {
    for(int i = 0; i < array.length; i++){
      if(i == 0){
      System.out.print(array[i]);
      }
      else{
        System.out.print(" + " + array[i]);
      }
    }
    System.out.println();
  }
  
  
}
