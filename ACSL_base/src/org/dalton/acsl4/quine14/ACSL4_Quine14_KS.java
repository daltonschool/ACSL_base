package org.dalton.acsl4.quine14;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class ACSL4_Quine14_KS 
{
  public static void main(String[] args) 
  {
    // TODO extended simplification for (3), (4), and (5)

    String input = " ";
    Scanner scan = new Scanner(System.in);
    int totalinputs = 0;

    while(true)
    {
      input = scan.nextLine();
      totalinputs++;
      String[] parsed = input.split(", ");     //remember that parsed[parsed.length-1] = -1

      String[][] inputtobinary = new String[parsed.length-1][2];
      Set<String> printthese1 = new HashSet<String>();
      Set<String> printthese2 = new HashSet<String>();

      for (int i = 0; i < parsed.length-1; i++)   //creates String[][] such that the first column is each number in the input (except -1)
      {                                           //and second column is corresponding binary
        if (totalinputs <= 3)
        {
          int stringparsedtointparsed = Integer.parseInt(parsed[i]);
          inputtobinary[i][0] = parsed[i];
          //System.out.println(inputtobinary[i][0]);
          String binaryString = String.format("%"+Integer.toString(3)+"s",Integer.toBinaryString(stringparsedtointparsed)).replace(" ","0");
          inputtobinary[i][1] = binaryString;
          //System.out.println(inputtobinary[i][1]);
        }
        else 
        {
          int stringparsedtointparsed = Integer.parseInt(parsed[i]);
          inputtobinary[i][0] = parsed[i];
          //System.out.println(inputtobinary[i][0]);
          String binaryString = String.format("%"+Integer.toString(4)+"s",Integer.toBinaryString(stringparsedtointparsed)).replace(" ","0");
          inputtobinary[i][1] = binaryString;
          //System.out.println(inputtobinary[i][1]);
        }
      }

      for (int i = 0; i < parsed.length-1; i++)     //comparing binary forms in inputtobinary String[][]
      {
        for (int j = 0; j < parsed.length-1; j++)
        {
          //if (i == j) break;                          //i and j represent rows in inputtobinar
          if (i != j)
          {
            char firstcomparitive[] = inputtobinary[i][1].toCharArray();
            char secondcomparitive[] = inputtobinary[j][1].toCharArray();
            //System.out.println("length " + secondcomparitive.length);
            char finalaftercompared[] = new char[secondcomparitive.length];

            int charequals1 = 0;
            int notequal1 = 0;
            //int lengthdiff = secondcomparitive.length - firstcomparitive.length;
            //int k = 0;

            /**
            while (lengthdiff > 0)
            {
              if ('0' == secondcomparitive[k]) charequals++;
              else if ('0' != secondcomparitive[k]) notequal = k;

              k++;
              lengthdiff--;
            }
             **/

            for (int k = 0; k < secondcomparitive.length; k++)
            {
              if (firstcomparitive[k] == secondcomparitive[k]) charequals1++;
              else if (firstcomparitive[k] != secondcomparitive[k]) notequal1 = k;
            }

            if (charequals1 == secondcomparitive.length-1)
            {
              //System.out.println("first: " + inputtobinary[i][1] + "second: " + inputtobinary[j][1]);
              for (int l = 0; l < secondcomparitive.length; l++)
              {
                if (l == notequal1) finalaftercompared[l] = 'x';
                else finalaftercompared[l] = secondcomparitive[l];
              }
              String done = new String(finalaftercompared);
              printthese1.add(done);
            }
          }
        }
      }

      String[] printthesetoarray = printthese1.toArray(new String[printthese1.size()]);

      for (int n = 0; n < printthesetoarray.length; n++)
      {
        for (int j = 0; j < printthesetoarray.length; j++)
        {
          if (n != j)
          {

            char extendedsimp1[] = printthesetoarray[n].toCharArray();
            char extendedsimp2[] = printthesetoarray[j].toCharArray();
            char finalaftercomparedextendedsimp[] = new char[extendedsimp2.length];

            int charequals2 = 0;
            int notequal2 = 0;


            for (int k = 0; k < extendedsimp2.length; k++)
            {
              //System.out.println("1: " + extendedsimp1[k] + ", 2: " + extendedsimp2[k]);
              if (extendedsimp1[k] == extendedsimp2[k]) charequals2++;
              else if (extendedsimp1[k] != extendedsimp2[k]) notequal2 = k;
            }
            //System.out.println("Charequals = " + charequals2);

            if (charequals2 == extendedsimp2.length-1)
            {
              //System.out.println("first: " + inputtobinary[i][1] + "second: " + inputtobinary[j][1]);
              for (int l = 0; l < extendedsimp2.length; l++)
              {
                if (l == notequal2) finalaftercomparedextendedsimp[l] = 'x';
                else finalaftercomparedextendedsimp[l] = extendedsimp2[l];
              }
              String done = new String(finalaftercomparedextendedsimp);
              //System.out.println("Done: " + done);
              printthese2.add(done);
            }
          }
        }
      }

      String[] printthesetoarray2 = printthese2.toArray(new String[printthese2.size()]);
      for (int n = 0; n < printthesetoarray2.length; n++)
      {
        //System.out.println("Elements to print: " + printthesetoarray2[n]);
      }

      if (printthese2.size() == 0)
      {
        //System.out.println("HERE1");
        for (int n = 0; n < printthesetoarray.length; n++)
        {
          char convert1[] = printthesetoarray[n].toCharArray();
          if (totalinputs <= 3) 
          {
            if (convert1[0] == '0')
            {
              convert1[0] = 'a';
            }
            if (convert1[0] == '1')
            {
              convert1[0] = 'A';
            }
            if (convert1[0] == 'x')
            {
              convert1[0] = ' ';
            }
            if (convert1[1] == '0')
            {
              convert1[1] = 'b';
            }
            if (convert1[1] == '1')
            {
              convert1[1] = 'B';
            }
            if (convert1[1] == 'x')
            {
              convert1[1] = ' ';
            }
            if (convert1[2] == '0')
            {
              convert1[2] = 'c';
            }
            if (convert1[2] == '1')
            {
              convert1[2] = 'C';
            }
            if (convert1[2] == 'x')
            {
              convert1[2] = ' ';
            }
          }

          else 
          {
            if (convert1[0] == '0')
            {
              convert1[0] = 'a';
            }
            if (convert1[0] == '1')
            {
              convert1[0] = 'A';
            }
            if (convert1[0] == 'x')
            {
              convert1[0] = ' ';
            }
            if (convert1[1] == '0')
            {
              convert1[1] = 'b';
            }
            if (convert1[1] == '1')
            {
              convert1[1] = 'B';
            }
            if (convert1[1] == 'x')
            {
              convert1[1] = ' ';
            }
            if (convert1[2] == '0')
            {
              convert1[2] = 'c';
            }
            if (convert1[2] == '1')
            {
              convert1[2] = 'C';
            }
            if (convert1[2] == 'x')
            {
              convert1[2] = ' ';
            }
            if (convert1[3] == '0')
            {
              convert1[3] = 'd';
            }
            if (convert1[3] == '1')
            {
              convert1[3] = 'D';
            }
            if (convert1[3] == 'x')
            {
              convert1[3] = ' ';
            }
          }
          printthesetoarray[n] = new String (convert1).replaceAll("\\s+","");
        }

        for (int m = 0; m < printthesetoarray.length-1; m++)
        {
          //System.out.print("Here: ");
          System.out.print(printthesetoarray[m] + " + ");
        }
        System.out.println(printthesetoarray[printthesetoarray.length-1]);
      }

      else
      { 
        //System.out.println("HERE2");
        for (int y = 0; y < printthesetoarray2.length; y++)
        {
          char convert2[] = printthesetoarray2[y].toCharArray();
          
          //System.out.println(convert2[2]);
          if (totalinputs <= 3) 
          {
            if (convert2[0] == '0')
            {
              convert2[0] = 'a';
            }
            if (convert2[0] == '1')
            {
              convert2[0] = 'A';
            }
            if (convert2[0] == 'x')
            {
              convert2[0] = ' ';
            }
            if (convert2[1] == '0')
            {
              convert2[1] = 'b';
            }
            if (convert2[1] == '1')
            {
              convert2[1] = 'B';
            }
            if (convert2[1] == 'x')
            {
              convert2[1] = ' ';
            }
            if (convert2[2] == '0')
            {
              convert2[2] = 'c';
            }
            if (convert2[2] == '1')
            {
              convert2[2] = 'C';
            }
            if (convert2[2] == 'x')
            {
              convert2[2] = ' ';
            }
          }

          else 
          {
            if (convert2[0] == '0')
            {
              convert2[0] = 'a';
            }
            if (convert2[0] == '1')
            {
              convert2[0] = 'A';
            }
            if (convert2[0] == 'x')
            {
              convert2[0] = ' ';
            }
            if (convert2[1] == '0')
            {
              convert2[1] = 'b';
            }
            if (convert2[1] == '1')
            {
              convert2[1] = 'B';
            }
            if (convert2[1] == 'x')
            {
              convert2[1] = ' ';
            }
            if (convert2[2] == '0')
            {
              convert2[2] = 'c';
            }
            if (convert2[2] == '1')
            {
              convert2[2] = 'C';
            }
            if (convert2[2] == 'x')
            {
              convert2[2] = ' ';
            }
            if (convert2[3] == '0')
            {
              convert2[3] = 'd';
            }
            if (convert2[3] == '1')
            {
              convert2[3] = 'D';
            }
            if (convert2[3] == 'x')
            {
              convert2[3] = ' ';
            }
          }
          printthesetoarray2[y] = new String (convert2).replaceAll("\\s+","");
        }

        for (int m = 0; m < printthesetoarray2.length-1; m++)
        {
          System.out.print(printthesetoarray2[m] + " + ");
        }
        System.out.println(printthesetoarray2[printthesetoarray2.length-1]);
      }

    } //while
  } //main
} //class