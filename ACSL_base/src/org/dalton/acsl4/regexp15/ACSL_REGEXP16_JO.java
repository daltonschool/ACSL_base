package org.dalton.acsl4.regexp15;
import java.util.Scanner;

public class ACSL_REGEXP16_JO {
    
    public static void main (String args[]){
        
        Scanner scan = new Scanner(System.in);
        
        //input
        String input = scan.nextLine();
        
        String[] match = input.split(", ");
        
        for(int i = 0; i < 5; i++){
            
            String reg = scan.nextLine();
            int count = 0;
            boolean printed = false;
            
            for(int ii = 0; ii < match.length; ii++){
                
                if (match[ii].matches(reg)){
                    if(printed) System.out.print(", ");
                    System.out.print(match[ii]);
                    printed = true;
                }else count++;
                
                if(count == match.length) System.out.print("NONE");
                
            }
            
        }
        
    }
    
    
    
}
