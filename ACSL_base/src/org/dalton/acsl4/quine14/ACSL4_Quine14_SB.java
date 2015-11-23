package org.dalton.acsl4.quine14;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
//1, 3, 4, 5, 6, 7, -1

public class ACSL4_Quine14_SB {//due may 15

  public static void main(String[] args) {
    for (int cats = 0; cats < 5; cats++) {
    String finalprint = "";
    
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    String [] sublists = input.split("\\, ");//splits into substrings
    String [] fSub = Arrays.copyOfRange(sublists, 0, sublists.length-1);//array of actual values
    Map<String, int [] > dict = new HashMap<String, int []>();
    Map<Integer, Map<Set<Integer>, int []>> indexpair= new HashMap<Integer, Map<Set<Integer>, int []>>();
    
    char [] [] finale = new char [] [] {{'a', 'A'}, {'b', 'B'}, {'c', 'C'}, {'d', 'D'}};

    dict.put("0", new int[]{0, 0, 0, 0});
    dict.put("1", new int[]{0, 0, 0, 1});
    dict.put("2", new int[]{0, 0, 1, 0});
    dict.put("3", new int[]{0, 0, 1, 1});
    dict.put("4", new int[]{0, 1, 0, 0});
    dict.put("5", new int[]{0, 1, 0, 1});
    dict.put("6", new int[]{0, 1, 1, 0});
    dict.put("7", new int[]{0, 1, 1, 1});
    dict.put("8", new int[]{1, 0, 0, 0});
    dict.put("9", new int[]{1, 0, 0, 1});
    dict.put("10", new int[]{1, 0, 1, 0});
    dict.put("11", new int[]{1, 0, 1, 1});
    dict.put("12", new int[]{1, 1, 0, 0});
    dict.put("13", new int[]{1, 1, 0, 1});
    dict.put("14", new int[]{1, 1, 1, 0});
    dict.put("15", new int[]{1, 1, 1, 1});



    for (int i = 0; i < fSub.length; i++) {
      int [] bin = dict.get(fSub[i]);
      int ind = getindex(bin);
      if(indexpair.containsKey(ind))
      {
        Set <Integer> oink = new HashSet <Integer> ();
        oink.add(Integer.parseInt(fSub[i]));
        indexpair.get(ind).put(oink, bin);
      }
      else{
        Set <Integer> oink = new HashSet <Integer> ();
        oink.add(Integer.parseInt(fSub[i]));
        Map<Set<Integer>, int []> pig = new HashMap<Set<Integer>, int []>();
        pig.put(oink, bin);
        indexpair.put(ind, pig);
      }
      
    }

    int i=2;
    while(true)
    {
      if(simplify(indexpair)!=1) break;
 //     System.out.println(indexpair);
      removeredun(indexpair,i);
      i = i*2;
 //     System.out.println(indexpair);
    }
    //  simplify(indexpair);
 //   System.out.println(indexpair);
 //   System.out.println("pairs");
    int shift = 0;
    if(cats<3) shift = 1;
    for (Map<Set<Integer>, int[]> pairs: indexpair.values())
    {    
      for (int [] socialism: pairs.values()) {
        
        for (int j = 0; j < socialism.length-shift; j++) { 
          if(socialism[j+shift] != 2) finalprint += (finale[j][socialism[j+shift]]);
        }
        finalprint+= " + ";
        
      }
      
    }
    
    System.out.println(finalprint.substring(0, finalprint.length() - 3));
    }
    
  }

  public static int simplify(Map<Integer, Map<Set<Integer>, int []>> capitalism)
  {
    int simplified = 0;
    for (int i = 0; i < 4; i++) {
      if(capitalism.containsKey(i)&&capitalism.containsKey(i+1))
      {
        Map<Set<Integer>, int[]> m1 = capitalism.get(i);
        Map<Set<Integer>, int[]> m2 = capitalism.get(i+1);

        Map<Set<Integer>, int[]> m1_c = new HashMap<Set<Integer>, int[]>(m1);
        for (Set<Integer> key: m1.keySet()) {
          for (Set<Integer> key2: m2.keySet()) {
            int [] simp = combine(m1.get(key), m2.get(key2));
            if(simp[0] != -1) 
            {
              Set<Integer> corndog = new HashSet<Integer>();
              for (Integer s: key) corndog.add(s);
              for (Integer z: key2) corndog.add(z);
              m1_c.put(corndog, simp); simplified = 1;
              m1_c.remove(key);
            }
          }
        }
        m1 = null;
        capitalism.put(i,m1_c);
      }
    }

    return simplified;
  }

  public static void removeredun(Map<Integer, Map<Set<Integer>, int []>> capitalism, int j)
  {
    Set<Integer> covered = new HashSet<Integer>();
    for (Map<Set<Integer>, int[]> pairs: capitalism.values()) 
    {
      for(Set<Integer> covs : pairs.keySet())
      {
        for(Integer i: covs)
        {
          covered.add(i);
        }

      }

    }
    for (Map<Set<Integer>, int[]> pairs: capitalism.values()) 
    {
      ArrayList<Set<Integer>> to_rem = new ArrayList<Set<Integer>>();
      for(Set<Integer> covs : pairs.keySet())
      {
        if (covs.size()!=j){
          int red = 1;
          for(Integer i: covs)
          {
            if(!covered.contains(i))
            { 
              red = 0;
              break;
            }
          }
          if(red == 1) to_rem.add(covs);
          else for(Integer i: covs) covered.add(i);
        }
      }
      for (Set<Integer> rem: to_rem) pairs.remove(rem);
    }
  }

  public static int getindex(int[] binary)
  {
    int onenum = 0;
    for (int i = 0; i < binary.length; i++) {
      if(binary[i] == 1) onenum++;
    }
    return onenum;
  }

  public static int[] combine(int [] b1, int [] b2)
  {
    int counter = 0;
    //int pos = 0;
    int [] simpl = new int []{-1, 0, 0, 0};
    for (int i = 0; i < b2.length; i++) {
      simpl [i] = b1[i];
      if(b1[i] != b2[i]) 
      {
        counter ++;
        simpl [i] = 2;
      }

    }

    if(counter == 1) 
    {
      return simpl;
    }

    simpl[0] = -1;
    return simpl;

  }

}
//quinne mccluskey method