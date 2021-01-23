/*
TASK: palsquare
LANG: JAVA
*/

import java.util.*;
import java.io.*;

public class palsquare
{
	public static void main (String [] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader ("palsquare.in"));
		
		PrintWriter out = new PrintWriter (new BufferedWriter(new FileWriter ("palsquare.out")));
		
		StringTokenizer firstLine = new StringTokenizer(f.readLine());
		int base = Integer.parseInt(firstLine.nextToken());
		
		
		for (int i = 1; i<=300; i++)
		{
			//converting number to new base
			
			int toDivide = i;
			int remainder;
			String reversedStringNumber = "";
			
			while (toDivide!=0)
			{
				remainder = toDivide%base;
				
				//if remainder is over 9
				
				if (remainder==10)
					reversedStringNumber+="A";
				else if (remainder==11)
					reversedStringNumber+="B";
				else if (remainder==12)
					reversedStringNumber+="C";
				else if (remainder==13)
					reversedStringNumber+="D";
				else if (remainder==14)
					reversedStringNumber+="E";
				else if (remainder==15)
					reversedStringNumber+="F";
				else if (remainder==16)
					reversedStringNumber+="G";
				else if (remainder==17)
					reversedStringNumber+="H";
				else if (remainder==18)
					reversedStringNumber+="I";
				else if (remainder==19)
					reversedStringNumber+="J";
				else 
					reversedStringNumber+=remainder;
				
				toDivide = toDivide/base;

			}
			
			String stringNumber = "";
			
			for (int j = reversedStringNumber.length(); j > 0; j--) 
			{
				stringNumber += reversedStringNumber.substring(j - 1, j);
			}

			// System.out.println("i=" + i + ", stringNumber=" + stringNumber);
			
			
			//converting the square to new base
			
			int square = i*i;
			int toDivideSquare = square;
			int remainderSquare;
			String reversedStringNumberSquare = "";
			while (toDivideSquare!=0)
			{
				//if remainder is over 9
				remainderSquare = toDivideSquare%base;
				
				
				if (remainderSquare==10)
					reversedStringNumberSquare+="A";
				else if (remainderSquare==11)
					reversedStringNumberSquare+="B";
				else if (remainderSquare==12)
					reversedStringNumberSquare+="C";
				else if (remainderSquare==13)
					reversedStringNumberSquare+="D";
				else if (remainderSquare==14)
					reversedStringNumberSquare+="E";
				else if (remainderSquare==15)
					reversedStringNumberSquare+="F";
				else if (remainderSquare==16)
					reversedStringNumberSquare+="G";
				else if (remainderSquare==17)
					reversedStringNumberSquare+="H";
				else if (remainderSquare==18)
					reversedStringNumberSquare+="I";
				else if (remainderSquare==19)
					reversedStringNumberSquare+="J";
				else 
					reversedStringNumberSquare+=remainderSquare;
				
				toDivideSquare = toDivideSquare/base;
			}
			
			String stringNumberSquare = "";
			
			for (int j = reversedStringNumberSquare.length(); j > 0; j--) 
			{
				stringNumberSquare += reversedStringNumberSquare.substring(j - 1, j);
			}
			/*
			for (int j = 1; i<reversedStringNumberSquare.length(); j++)
			{
				stringNumberSquare += reversedStringNumberSquare.substring(j - 1, j);
			}
			*/
			
			if (stringNumberSquare.equals(reversedStringNumberSquare))
			{
				// System.out.println("i=" + i + ", " + stringNumber);
				out.println(stringNumber + " " + stringNumberSquare);
			}
			
		}
		
		out.close();
	}
}