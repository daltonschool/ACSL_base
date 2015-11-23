package org.dalton.acsl4.quine14;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * Dillon Azzam
 * The Dalton School
 */
public class ACSL4_Quine14_DA 
{
  public static void main(String[] args) 
  {
    for(int runs=0; runs<5; runs++)
    {
      Scanner scan = new Scanner(System.in);
      String inputRaw = scan.nextLine();
      String[] termsStrings = inputRaw.split(", ");
      termsStrings=Arrays.copyOfRange(termsStrings, 0, termsStrings.length-1);

      int[] terms = new int[termsStrings.length];
      for(int i=0; i<termsStrings.length; i++)
      {
        terms[i]=Integer.parseInt(termsStrings[i]);
      }

      ArrayList<Pair> pairs = new ArrayList<Pair>();
      for(int i=0; i<terms.length; i++)
      {
        Pair pair = new Pair();
        String binaryRepresentation = Integer.toBinaryString(terms[i]);
        while(binaryRepresentation.length()!=4)
        {
          binaryRepresentation="0"+binaryRepresentation;
        }
        //System.out.println(binaryRepresentation);
        pair.setBinaryRepresentation(binaryRepresentation);
        pairs.add(pair);
      }

      boolean fullySimplified=false;
      boolean reversed=false;
      ArrayList<Pair> newPairs = new ArrayList<Pair>();
      newPairs.addAll(pairs);

      while(!fullySimplified)
      {
        //System.out.println("START "+"Pairs: "+pairs.toString()+" New Pairs: "+newPairs.toString());

        fullySimplified=true;
        pairs.clear();
        pairs.addAll(newPairs);
        newPairs.clear();
        for(int mainPairIndex=0; mainPairIndex<pairs.size(); mainPairIndex++)
        {
          boolean simplifiedPair=false;//8, 9, 10, 11, 12, 14, 15, -1
          for(int secondPairIndex=mainPairIndex+1; secondPairIndex<pairs.size(); secondPairIndex++)
          {
            //System.out.println(pairs.get(mainPairIndex).binaryRepresentation+" "+pairs.get(secondPairIndex).binaryRepresentation+" Diff: "+getNumPairDifferences(pairs.get(mainPairIndex), pairs.get(secondPairIndex)));
            //System.out.println("Pairs: "+pairs.toString()+" New Pairs: "+newPairs.toString());
            if((getNumPairDifferences(pairs.get(mainPairIndex), pairs.get(secondPairIndex))==1)&&(reversed||(pairs.get(mainPairIndex).getXPositions().equals(pairs.get(secondPairIndex).getXPositions()))))//If only one differnece between pairs and "x" positions match
            {
              Pair combinedPair=combinePairs(pairs.get(mainPairIndex), pairs.get(secondPairIndex));
              //System.out.println("COMBINED! "+pairs.get(mainPairIndex).binaryRepresentation+" "+pairs.get(secondPairIndex).binaryRepresentation+" = "+combinedPair.binaryRepresentation);
              if(!newPairs.contains(combinedPair))
              {
                newPairs.add(combinedPair);
                //System.out.println("Added "+combinedPair.binaryRepresentation);
              }
              simplifiedPair=true;
              fullySimplified=false;
            }
          }
          if(!simplifiedPair)
          {
            //System.out.println("KEPT! "+pairs.get(mainPairIndex));
            if(!newPairs.contains(pairs.get(mainPairIndex)))
              newPairs.add(pairs.get(mainPairIndex));
          }
        }

        if(fullySimplified)
        {
          if(!reversed)
          {
            //System.out.println("REVERSE");
            Collections.reverse(newPairs);
            fullySimplified=false;
            reversed=true;
          }
          else
          {
            //System.out.println("UNREVERSE");
            Collections.reverse(newPairs);
          }
        }
      }//End fullySimplified   

      String finalString="";
      for(Pair pair:newPairs)
      {
        int startingIndex=0;
        String binaryString="";
        if(runs<3)
        {
          if(pair.binaryRepresentationArray[1].equals("1"))
          {
            binaryString+="A";
          }
          else if(pair.binaryRepresentationArray[1].equals("0"))
          {
            binaryString+="a";
          }
          else
          {
          }
          
          if(pair.binaryRepresentationArray[2].equals("1"))
          {
            binaryString+="B";
          }
          else if(pair.binaryRepresentationArray[2].equals("0"))
          {
            binaryString+="b";
          }
          else
          {
          }
          
          if(pair.binaryRepresentationArray[3].equals("1"))
          {
            binaryString+="C";
          }
          else if(pair.binaryRepresentationArray[3].equals("0"))
          {
            binaryString+="c";
          }
          else
          {
          }
        }
        else
        {
          if(pair.binaryRepresentationArray[0].equals("1"))
          {
            binaryString+="A";
          }
          else if(pair.binaryRepresentationArray[0].equals("0"))
          {
            binaryString+="a";
          }
          else
          {}
          
          if(pair.binaryRepresentationArray[1].equals("1"))
          {
            binaryString+="B";
          }
          else if(pair.binaryRepresentationArray[1].equals("0"))
          {
            binaryString+="b";
          }
          else
          {}
          
          if(pair.binaryRepresentationArray[2].equals("1"))
          {
            binaryString+="C";
          }
          else if(pair.binaryRepresentationArray[2].equals("0"))
          {
            binaryString+="c";
          }
          else
          {}
          
          if(pair.binaryRepresentationArray[3].equals("1"))
          {
            binaryString+="D";
          }
          else if(pair.binaryRepresentationArray[3].equals("0"))
          {
            binaryString+="d";
          }
          else
          {}
        }
        finalString+=binaryString+"+";
      }

      System.out.println(finalString.substring(0, finalString.length()-1));
      
    }//End PRIMARY For
  }//END MAIN

  public static int getNumPairDifferences(Pair pairOne, Pair pairTwo)
  {
    int numDifferences=0;
    for(int i=0; i<pairOne.binaryRepresentationArray.length; i++)
    {
      if(!pairOne.binaryRepresentationArray[i].equals(pairTwo.binaryRepresentationArray[i]))//&&(!pairOne.binaryRepresentationArray[i].equals("x")))
      {
        numDifferences++;
      }
    }
    return numDifferences;
  }

  public static Pair combinePairs(Pair pairOne, Pair pairTwo)
  {
    String newBinaryRepresentation="";
    for(int i=0; i<pairOne.binaryRepresentationArray.length; i++)
    {
      if(pairOne.binaryRepresentationArray[i].equals(pairTwo.binaryRepresentationArray[i]))
      {
        newBinaryRepresentation+=pairOne.binaryRepresentationArray[i];
      }
      else
      {
        newBinaryRepresentation+="x";
      }
    }
    Pair combinedPair = new Pair();
    combinedPair.setBinaryRepresentation(newBinaryRepresentation);
    return combinedPair;
  }

}//END CLASS

class Pair
{
  String binaryRepresentation="";
  String[] binaryRepresentationArray=new String[4];
  boolean[] isPositionX=new boolean[binaryRepresentationArray.length];
  int numXs=-1;

  public Pair()
  {

  }

  @Override
  public boolean equals(Object object)
  {
    if(object.getClass().equals(this.getClass()))
    {
      if(this.binaryRepresentation.equals(((Pair) object).binaryRepresentation))
      {
        return true;
      }
    }
    return false;
  }

  public String toString()
  {
    return this.binaryRepresentation;
  }

  public ArrayList<Integer> getXPositions()
  {
    ArrayList<Integer> toReturn = new ArrayList<Integer>();
    for(int i=0; i<binaryRepresentationArray.length; i++)
    {
      if(binaryRepresentationArray[i].equals("x"))
      {
        toReturn.add(i);
      }
    }
    Collections.sort(toReturn);
    return toReturn;
  }

  public void setBinaryRepresentation(String binaryRepresentation)
  {
    if(binaryRepresentation.length()!=4)
    {
      System.out.println("ERROR, binary representation: "+binaryRepresentation+" too large!");
    }
    else
    {
      this.binaryRepresentation=binaryRepresentation;
      this.binaryRepresentationArray=Arrays.copyOfRange(binaryRepresentation.split(""), 1, binaryRepresentation.split("").length);

      numXs=0;
      for(int i=0; i<binaryRepresentationArray.length; i++)
      {
        if(binaryRepresentationArray[i].equals("x"))
        {
          isPositionX[i]=true;
          numXs++;
        }
        else
        {
          isPositionX[i]=false;
        }
      }
    }
  }
}