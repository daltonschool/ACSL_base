package org.dalton.acsl4.quine14;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ACSL4_Quine14_AM {

  /*
   * 

6, 3, 1, 7, 4, -1
Ac + AB + BC + aC

5, 8, -1
aBcD + Abcd

15, 13, 2, -1
ABD + abCd

1, 2, -1
aBc + abC

2, 3, -1
aB

2, 5, -1
aBc + AbC

13, 14, -1
ABCd + ABcD

12, 14, -1
ABd

   * 
   */

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner input = new Scanner(System.in);
    for (int ii = 0; ii < 5; ii++) {
      try {
        String line = input.nextLine().trim(); 
        String[] terms = line.substring(0, line.length()-4).split(", "); 
        ArrayList<Term> binTerms = new ArrayList<Term>(); 
        ArrayList<Term> simpTerms = new ArrayList<Term>(); 
        binTerms.clear();
        simpTerms.clear(); 

        for (int jj = 0; jj < terms.length; jj++) {
          String cur = Integer.toString(Integer.parseInt(terms[jj]), 2);
          if(ii < 3)
            cur = String.format("%3s", cur).replace(' ', '0');
          else
            cur = String.format("%4s", cur).replace(' ', '0');
          binTerms.add(new Term(cur));       
        }

        for (Term a : binTerms) {
          for (Term b : binTerms) {
            if(a.equals(b))
              continue; 
            if(canSimp(a, b)){
              if(getIndex(a.data) < getIndex(b.data)){
                simpTerms.add(simp(a, b));
                //System.out.println("Combined " + a + "," + b + " into " + simp(a, b));
                a.used ++; 
                b.used ++; 
              }
            }
          }
        }

        for(Term c : binTerms) //CHECK IF YOU NEED THIS
          if(c.used == 0)
            simpTerms.add(c); 

        ArrayList<Term> finalSimp = new ArrayList<Term>(); 
        for (Term a : simpTerms) {
          for (Term b : simpTerms) {
            if(a.equals(b))
              continue; 
            if(canSimp(a, b)){
              if(getIndex(a.data) < getIndex(b.data)){
                finalSimp.add(simp(a, b)); //check index? 
                //System.out.println("Combined " + a + "," + b + " into " + simp(a, b));
                a.used ++; 
                b.used ++; 
              }
            }
          }
        }
        for(Term c : simpTerms) //CHECK IF YOU NEED THIS
          if(c.used == 0)
            finalSimp.add(c); 

        ArrayList<Term> finalSimp2 = new ArrayList<Term>(); 
        for (Term a : finalSimp) {
          for (Term b : finalSimp) {
            if(a.equals(b))
              continue; 
            if(canSimp(a, b)){
              if(getIndex(a.data) < getIndex(b.data)){
                finalSimp2.add(simp(a, b)); //check index? 
                //System.out.println("Combined " + a + "," + b + " into " + simp(a, b));
                a.used ++; 
                b.used ++; 
              }
            }
          }
        }
        for(Term c : finalSimp) //CHECK IF YOU NEED THIS
          if(c.used == 0)
            finalSimp2.add(c); 

        ArrayList<Term> finalSimp3 = new ArrayList<Term>(); 
        for (Term a : finalSimp2) {
          for (Term b : finalSimp2) {
            if(a.equals(b))
              continue; 
            if(canSimp(a, b)){
              if(getIndex(a.data) < getIndex(b.data)){
                finalSimp3.add(simp(a, b)); //check index? 
                //System.out.println("Combined " + a + "," + b + " into " + simp(a, b));
                a.used ++; 
                b.used ++; 
              }
            }
          }
        }
        for(Term c : finalSimp2) //CHECK IF YOU NEED THIS
          if(c.used == 0)
            finalSimp3.add(c); 

        List<String> finalStr = new ArrayList<>();
        for(Term k : finalSimp3)
          finalStr.add(k.data); 
        Set<String> hs = new HashSet<>();
        hs.addAll(finalStr);
        finalStr.clear();
        finalStr.addAll(hs);
        //String boolExp = ""; 

        for (int jj = 0; jj < finalStr.size(); jj++) {
          String tempStr = ""; 
          for (int kk = 0; kk < finalStr.get(jj).length(); kk++) {
            Character c = finalStr.get(jj).toCharArray()[kk];
            if(c == 'x')
              continue; 
            if(c == '0')
              tempStr += (char)(97+kk); 
            else if(c == '1')
              tempStr += (char)(65+kk); 
          }
          finalStr.set(jj, tempStr); 
        }
        for (int jj = 0; jj < finalStr.size(); jj++) {
          System.out.print(finalStr.get(jj));
          if(jj < finalStr.size()-1 && finalStr.get(jj).length() != 0)
            System.out.print(" + ");
        }
        System.out.println();
        //System.out.println(finalStr);

        /*for (int jj = 0; jj < finalStr.size(); jj++) {
          for (int kk = 0; kk < finalStr.get(jj).toCharArray().length; kk ++) {
            Character c = finalStr.get(jj).toCharArray()[kk]; 
            if(c == 'x')
              continue; 
            if(c == '0')
              boolExp += (char)(97+kk); 
            else if(c == '1')
              boolExp += (char)(65+kk); 
          }
          if(jj < finalStr.size()-1)
            boolExp += " + "; 
        }
        System.out.println(boolExp);*/
      }
      catch(Exception e){
        e.printStackTrace(); 
      }
    }//end for loop 
    input.close(); 
  }

  public static boolean canSimp(Term one, Term two){
    if(Math.abs(getIndex(one.data)-getIndex(two.data)) == 1){
      if(placesDiff(one.data, two.data) == 1)
        return true; 
      else 
        return false; 
    }
    return false; 
  }

  public static Term simp(Term a, Term b){
    StringBuilder simplified = new StringBuilder(a.data);
    for (int ii = 0; ii < a.data.length(); ii++) 
      if(a.data.charAt(ii) != b.data.charAt(ii))
        simplified.setCharAt(ii, 'x');
    return new Term(simplified.toString()); 
  }

  public static int placesDiff(String one, String two){
    if(one.length() != two.length())
      return -1;
    int num = 0; 
    for (int ii = 0; ii < one.length(); ii++) 
      if(one.charAt(ii) != two.charAt(ii))
        num++; 
    return num; 
  }

  public static int getIndex(String str){
    int ind = 0; 
    for(Character c : str.toCharArray())
      if(c == '1')
        ind++; 
    return ind; 
  }
}

class Term{
  String data = ""; 
  int used = 0;
  public Term(String d){
    data = d; 
  }
  public String toString(){
    return data+";"+used; 
  }
}