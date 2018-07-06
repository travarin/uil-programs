package com.github.district12012;
/*
 * Travis Langston
 * 
 * 8/12/2017
 * This program will find the smallest non-increasing multiple of a number. 
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
public class Decreasing {

	public static void main(String[] args) {
		Scanner rdIn;
		try 
		{
			rdIn = new Scanner(new File("com/github/district12012/decreasing.dat"));
			int   sets 	  = rdIn.nextInt();
			int[] results = new int[sets];
			
			for ( int i = 0; i < sets; i++ )
			{
				int base, indx, multiple;
				base     = rdIn.nextInt();
				indx     = 2;
				multiple = 0;
				boolean keepLooping = true;
				while ( keepLooping )
				{
					multiple = base * indx;
					indx++;
					String check = String.valueOf(multiple);
					boolean increasing = false;
					for ( int k = 0; k < check.length()-1; k++ )
					{
						if ( check.charAt(k) < check.charAt(k+1) )
						{
							increasing = true;
						}
					}
					keepLooping = increasing;
				}
				results[i] = multiple;
			}
			
			for ( int result : results )
			{
				out.println(result);
			}
			rdIn.close();
		}
		catch ( IOException e )
		{
			System.err.println("Error: " + e );
		}

	}

}
