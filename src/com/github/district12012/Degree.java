package com.github.district12012;
/*
 * Travis Langston
 * 
 * 8/12/2017
 * This program will determine the degree of each array to determine which sorting algorithm will be the most efficient. 
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
public class Degree {

	public static void main(String[] args) {
		Scanner rdIn;
		try
		{
			rdIn = new Scanner(new File("com/github/district12012/degree.dat"));
			int   sets    = rdIn.nextInt();
			int[] degrees = new int[sets];
			rdIn.nextLine();
			for ( int i = 0; i < sets; i++ )
			{
				String   base  = rdIn.nextLine();
				String[] split = base.split("\\s");
				int[]    array = new int[split.length];
				for ( int k = 0; k < array.length; k++ )
				{
					array[k] = Integer.parseInt(split[k]);
				}
				for ( int k = 0; k < array.length; k++ )
				{
					int element = array[k];
					for ( int j = k; j < array.length; j++ )
					{
						if ( array[j] < element )
						{
							degrees[i]++;
						}
					}
				}
			}
			
			for ( int result : degrees )
			{
				out.println(result);
			}
			rdIn.close();
		}
		catch ( IOException e )
		{
			System.err.println("Error: " + e);
		}

	}

}
